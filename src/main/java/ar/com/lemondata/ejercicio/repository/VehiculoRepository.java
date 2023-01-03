package ar.com.lemondata.ejercicio.repository;

import java.util.List;
import java.util.Optional;

import ar.com.lemondata.ejercicio.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.lemondata.ejercicio.entity.DatosVehiculo;
import ar.com.lemondata.ejercicio.entity.Vehiculo;

/**
 * @author Cesar Repositorio de la Entidad Vehiculo
 */
@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

	public Optional<Vehiculo> findById(Long id);

	public Vehiculo saveAndFlush(Vehiculo vehiculo);

	public List<Vehiculo> findAll();

	public List<DatosVehiculo> findAllProjectedBy();

	@Query("select v from VEHICULOS v WHERE  v.marca LIKE %:marca%")
	public List<Vehiculo> findByName(@Param("marca")  String marca);


}
