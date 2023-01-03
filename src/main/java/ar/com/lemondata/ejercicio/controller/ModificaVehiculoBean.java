package ar.com.lemondata.ejercicio.controller;


import ar.com.lemondata.ejercicio.entity.DatosVehiculo;
import ar.com.lemondata.ejercicio.entity.Vehiculo;
import ar.com.lemondata.ejercicio.servicioImpl.ServiceVehiculoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

/**
 * @author Cesar
 *
 */
@Named("modificaVehiculoBean")
@ViewScoped
public class ModificaVehiculoBean extends GenericBean {

	@Value("${modificaVehiculo}")
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

	public void consultarVehiculo() {
		if (idSeleccionado != null) {
			setVehiculo(servicio.buscarVehiculoPorId(getIdSeleccionado()));
		}
	}

	public void modificarVehiculo(Vehiculo vehiculo , Long id) {

		servicio.modificarVehiculo(vehiculo, id);
		mostrarMensaje("Se modifico el Vehiculo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " con el ID: "
				+ vehiculo.getId());
		init();
		
	}

}
