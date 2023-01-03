package ar.com.lemondata.ejercicio.controller;

import ar.com.lemondata.ejercicio.entity.Persona;
import ar.com.lemondata.ejercicio.servicio.ServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaRestController {

    @Autowired
    private ServicioPersona personaServicio;

    @GetMapping("/personas")
    public List<Persona> index(){
        return personaServicio.findAll();

    }

    @GetMapping("/personas/{id}")
    public Persona mostrar(@PathVariable Long id){
        return personaServicio.buscarPersonaXId(id);

    }

    @PostMapping("/personas")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona crear(@RequestBody Persona persona){
        return personaServicio.guardarPersona(persona);
    }

    @PutMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona actualizar(@RequestBody Persona persona,@PathVariable Long id){
        Persona personaActual = personaServicio.buscarPersonaXId(id);
        personaActual.setNombre(persona.getNombre());
        personaActual.setApellido(persona.getApellido());
        personaActual.setFechaNacimiento(persona.getFechaNacimiento());
        personaActual.setDni(persona.getDni());
        personaActual.setSexo(persona.getSexo());
        personaActual.setDomicilio(persona.getDomicilio());

        return personaServicio.guardarPersona(personaActual);
    }
    @DeleteMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        personaServicio.eliminarPersona(id);
    }
}
