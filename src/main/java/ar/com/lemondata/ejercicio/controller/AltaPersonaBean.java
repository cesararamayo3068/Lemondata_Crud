package ar.com.lemondata.ejercicio.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.com.lemondata.ejercicio.entity.Persona;
import ar.com.lemondata.ejercicio.servicioImpl.ServicioPersonaImpl;

/**
 * @author Fernando
 *
 */
@Named("altaPersonaBean")
@ViewScoped
public class AltaPersonaBean extends GenericBean {

	@Value("${altaPersona}")
	private String titulo;

	private Persona persona;

	@Autowired
	private ServicioPersonaImpl servicio;

	@PostConstruct
	public void init() {
		setPersona(new Persona());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void guardarPersona() {
		Persona resultado = servicio.guardarPersona(getPersona());
		mostrarMensaje("Se creó la Persona: " + resultado.getNombre() + " " + resultado.getApellido() + " con el ID: "
				+ resultado.getId());
		init();
	}

}
