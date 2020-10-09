package pruebatecnica;

import io.micronaut.runtime.Micronaut;
import javax.inject.Inject;
import pruebatecnica.domain.Persona;
import pruebatecnica.infraestructure.PersonaRepo;

public class Application {
    
    

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);

    }
   
    
}
