package ar.com.lemondata.ejercicio.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import ar.com.lemondata.ejercicio.entity.DatosVehiculo;
import ar.com.lemondata.ejercicio.entity.Persona;
import ar.com.lemondata.ejercicio.entity.Vehiculo;
import ar.com.lemondata.ejercicio.servicioImpl.ServiceVehiculoImpl;
import ar.com.lemondata.ejercicio.servicioImpl.ServicioPersonaImpl;

/**
 * @author Cesar
 *
 */
@Named("consultaVehiculoBean")
@ViewScoped
public class ConsultaVehiculoBean extends GenericBean {

	@Value("${consultaVehiculo}")
	private String titulo;

	private Long idSeleccionado;
	private List<DatosVehiculo> datosCombo;
	private Vehiculo vehiculo;

	@Autowired
	private ServiceVehiculoImpl servicio;

	@PostConstruct
	private void init() {
		setDatosCombo(servicio.obtenerDatosComboVehiculo());
		setIdSeleccionado(null);
		setVehiculo(null);
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

	public List<DatosVehiculo> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosVehiculo> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public void consultarPersona() {
		if (idSeleccionado != null) {
			setVehiculo(servicio.buscarVehiculoPorId(getIdSeleccionado()));
		}
	}
	
	/*
	 * public void consultarPersonaPorNombre(String nombre) {
	 * 
	 * servicio.buscarPersonaXNombre(nombre);
	 * 
	 * }
	 */
}
