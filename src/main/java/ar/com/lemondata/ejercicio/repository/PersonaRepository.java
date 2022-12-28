package ar.com.lemondata.ejercicio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.lemondata.ejercicio.entity.DatosPersona;
import ar.com.lemondata.ejercicio.entity.Persona;

/**
 * @author Fernando
 * Repositorio de la Entidad Persona
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	public Optional<Persona> findById(Long id);
	

	public Persona saveAndFlush(Persona persona);
	
	public List<Persona> findAll();
	
	public List<DatosPersona> findAllProjectedBy();

	@Query("select p from PERSONAS p WHERE  p.nombre LIKE %:nombre%")
	public List<Persona> findByName(@Param("nombre")  String nombre);

	
}
