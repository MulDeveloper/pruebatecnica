/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatecnica.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import pruebatecnica.domain.GrupoAmigos;
import pruebatecnica.domain.Persona;
import pruebatecnica.infraestructure.GastosRepo;
import pruebatecnica.infraestructure.PersonaRepo;
import pruebatecnica.infraestructure.GrupoRepo;

@Validated
@Controller("/grupo")
public class GrupoController {
    
    @Inject
    private GrupoRepo grupoRepo;
    
    @Inject
    public GastosRepo gastosRepo;
    
    @Inject
    public PersonaRepo repo;
    
    
    @Get("/list")
    public List<GrupoAmigos> list(){
        return (List) grupoRepo.findAll();
        
    }
    
    @Get("/listByGroup/{id}")
    public List<Persona> listUsers(@PathVariable String id){
        
        GrupoAmigos g = this.grupoRepo.findById(Integer.parseInt(id)).get();
        
        return g.getPersonaList();
        
    }
    
    @Post("/add")
    public HttpResponse<?> save(@Body @Valid GrupoAmigos g) {
               
        this.grupoRepo.save(g);
        
        return HttpResponse.status(HttpStatus.CREATED).body(g);
        
    }
    
    @Get("/{id}")
    public GrupoAmigos getOne(@PathVariable String id){
        return this.grupoRepo.findById(Integer.parseInt(id)).get();
    }
    
    @Post("/addPersona/{idGrupo}")
    public HttpResponse<?> addPersona(@Body @Valid Persona u,
            @PathVariable String idGrupo){
        
        //persist the person and add to the group
        
        Persona user = this.repo.save(u);
        
        GrupoAmigos g = this.grupoRepo.findById(Integer.parseInt(idGrupo)).get();
        
        
        g.getPersonaList().add(user);
        
        
        this.grupoRepo.update(g);
        
        return HttpResponse.status(HttpStatus.CREATED).body(user);
    }
    
    /*
    
    
    
    @Delete("/del")
    public boolean del(@QueryValue String idGrupo){
        try{
            this.grupoRepo.deleteById(Integer.parseInt(idGrupo));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    */
    
    
    
    
}
