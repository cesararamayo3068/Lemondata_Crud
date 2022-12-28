package ar.com.lemondata.ejercicio.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.com.lemondata.ejercicio.entity.Vehiculo;
import ar.com.lemondata.ejercicio.servicioImpl.ServiceVehiculoImpl;


/**
 * @author Cesar
 *
 */
@Named("altaVehiculoBean")
@ViewScoped
public class AltaVehiculoBean extends GenericBean {

	@Value("${altaVehiculo}")
	private String titulo;

	private Vehiculo vehiculo;

	@Autowired
	private ServiceVehiculoImpl servicioVehiculo;

	@PostConstruct
	public void init() {
		setVehiculo(new Vehiculo());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public void guardarVehiculo() {
		Vehiculo resultado = servicioVehiculo.guardarVehiculo(getVehiculo());
		mostrarMensaje("Se creo el Vehiculo: " + resultado.getMarca() + " " + resultado.getModelo() + " con el ID: "
				+ resultado.getId());
		init();
	}

}
