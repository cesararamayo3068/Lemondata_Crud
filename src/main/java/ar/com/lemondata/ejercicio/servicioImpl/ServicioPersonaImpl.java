package ar.com.lemondata.ejercicio.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.com.lemondata.ejercicio.entity.DatosPersona;
import ar.com.lemondata.ejercicio.entity.Persona;
import ar.com.lemondata.ejercicio.repository.PersonaRepository;
import ar.com.lemondata.ejercicio.servicio.ServicioPersona;

/**
 * @author Fernando
 * Implementacion del Servicio Persona
 */
@SessionScope
@Service
public class ServicioPersonaImpl implements ServicioPersona {

	@Autowired
	private PersonaRepository personaRepository;
	
	

	public Persona guardarPersona(Persona persona) {
		return personaRepository.saveAndFlush(persona);
	}

	@Override
	 public List<Persona> buscarPersonaXNombre(String nombre) {
		//TODO Implementar metodo que devuelva todas las personas por el nombre pasado por parametro
	 return personaRepository.findByName(nombre);

	}

	public Persona buscarPersonaXId(Long id) {
		return personaRepository.findById(id).get();
	}
	
	public List<DatosPersona> obtenerDatosComboPersona() {
		return personaRepository.findAllProjectedBy();
	}

	@Override
	public void eliminarPersona(Long id) {
	    personaRepository.deleteById(id);
	}
	
	public Persona modificarPersona(Persona persona , Long id) {
		Persona personaActual = personaRepository.findById(id).get();
		 personaActual.setApellido(persona.getApellido());
		return personaRepository.save(personaActual);
	}



	
	 
	
	

}
