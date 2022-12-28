package ar.com.lemondata.ejercicio.entity;


/**
 * @author Cesar
 * Objeto del tipo DTO para el uso de Combos de Vehiculos.
 */
public interface DatosVehiculo {
	
	Long getId();
	
	String getMarca();
	
	String getModelo();
	
	default String getFormatoCombo() {
		return getMarca() + " " + getModelo();
	}

}
