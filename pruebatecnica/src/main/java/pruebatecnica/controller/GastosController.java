
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
import pruebatecnica.domain.GastosGrupo;
import pruebatecnica.infraestructure.GastosRepo;
import pruebatecnica.infraestructure.GastosService;

@Validated
@Controller("/gastos")
public class GastosController {

    @Inject
    public GastosRepo repo;
    
    public GastosService service;
    
    
    @Post("/add")
    public  HttpResponse<?> add(@Body GastosGrupo gasto){
        repo.save(gasto);
        return HttpResponse.status(HttpStatus.CREATED).body(gasto);
    }
    
    @Get("/list/{id}")
    public List<GastosGrupo> listGastosByGroup(@PathVariable String id){
        service = new GastosService();
        return service.listByGroup(Long.parseLong(id));
    }
    
    

    
}
