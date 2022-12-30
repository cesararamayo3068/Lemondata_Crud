package ar.com.lemondata.ejercicio.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.com.lemondata.ejercicio.entity.DatosPersona;
import ar.com.lemondata.ejercicio.entity.Persona;
import ar.com.lemondata.ejercicio.servicioImpl.ServicioPersonaImpl;

/**
 * @author Fernando
 *
 */
@Named("modificaPersonaBean")
@ViewScoped
public class ModificaPersonaBean extends GenericBean {

	@Value("${modificaPersona}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosPersona> datosCombo;
	private Persona persona;

	@Autowired
	private ServicioPersonaImpl servicio;

	@PostConstruct
	private void init() {
		setDatosCombo(servicio.obtenerDatosComboPersona());
		setIdSeleccionado(null);
		setPersona(null);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosPersona> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosPersona> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void consultarPersona() {
		if (idSeleccionado != null) {
			setPersona(servicio.buscarPersonaXId(getIdSeleccionado()));
		}
	}

	public void modificarPersona(Persona persona , Long id) {
		// TODO Guardar, refrescar combo, limpiar pantalla, mostrar mensaje de exito de
		// modificacion
		
		servicio.modificarPersona(persona, id);
		mostrarMensaje("Se modifico la Persona: " + persona.getNombre() + " " + persona.getApellido() + " con el ID: "
				+ persona.getId());
		init();
		
	}

}
