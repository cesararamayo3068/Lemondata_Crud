package ar.com.lemondata.ejercicio.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.com.lemondata.ejercicio.entity.DatosPersona;
import ar.com.lemondata.ejercicio.entity.DatosVehiculo;
import ar.com.lemondata.ejercicio.entity.Persona;
import ar.com.lemondata.ejercicio.entity.Vehiculo;
import ar.com.lemondata.ejercicio.repository.PersonaRepository;
import ar.com.lemondata.ejercicio.repository.VehiculoRepository;
import ar.com.lemondata.ejercicio.servicio.ServiceVehiculo;
import ar.com.lemondata.ejercicio.servicio.ServicioPersona;

/**
 * @author Cesar
 * Implementacion del Service Vehiculo
 */
@SessionScope
@Service
public class ServiceVehiculoImpl implements ServiceVehiculo {

	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	

	public Vehiculo guardarVehiculo(Vehiculo vehiculo) {
		return vehiculoRepository.saveAndFlush(vehiculo);
	}


	public Vehiculo buscarVehiculoPorId(Long id) {
		return vehiculoRepository.findById(id).get();
	}
	
	public List<DatosVehiculo> obtenerDatosComboVehiculo() {
		return vehiculoRepository.findAllProjectedBy();
	}

	@Override
	public void eliminarVehiculo(Long id) {
		vehiculoRepository.deleteById(id);
	}
	
	public Vehiculo modificarVehiculo(Vehiculo vehiculo , Long id) {
		Vehiculo vehiculoActual = vehiculoRepository.findById(id).get();
		vehiculoActual.setMarca(vehiculo.getMarca());
		vehiculoActual.setPatente(vehiculo.getPatente());
		vehiculoActual.setAnio(vehiculo.getAnio());
		vehiculoActual.setModelo(vehiculo.getModelo());
		vehiculoActual.setColor(vehiculo.getColor());
		vehiculoActual.setTipoDeUso(vehiculo.getTipoDeUso());
		return vehiculoRepository.save(vehiculoActual);
	}


	@Override
	public Vehiculo buscarVehiculoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}


	


	


	
	
	 
	
	

}
