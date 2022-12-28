package ar.com.lemondata.ejercicio.servicio;

import java.util.List;


import ar.com.lemondata.ejercicio.entity.DatosVehiculo;
import ar.com.lemondata.ejercicio.entity.Vehiculo;

/**
 * @author Cesar
 * Service de Vehiculo
 */
public interface ServiceVehiculo {

	public Vehiculo guardarVehiculo(Vehiculo vehiculo);

	public Vehiculo buscarVehiculoPorNombre(String nombre);

	public Vehiculo buscarVehiculoPorId(Long id);

	public List<DatosVehiculo> obtenerDatosComboVehiculo();

	public void eliminarVehiculo(Long id);
	
	public Vehiculo modificarVehiculo(Vehiculo vehiculo ,Long id);

	//void modificarPersona(Persona persona, Long id);

}
