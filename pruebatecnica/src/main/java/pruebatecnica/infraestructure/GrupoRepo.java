package pruebatecnica.infraestructure;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import pruebatecnica.domain.GrupoAmigos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bunn3
 */
@Repository
public interface GrupoRepo extends CrudRepository<GrupoAmigos, Integer>{
    
}
