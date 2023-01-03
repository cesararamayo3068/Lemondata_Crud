package ar.com.lemondata.ejercicio.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Fernando
 * 
 */
@Entity(name = "PERSONAS")
@Table(name = "PERSONAS")
public class Persona implements Serializable {

	private static final long serialVersionUID = 5836967339724076670L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "persona_id", unique = true, nullable = false)
	private Long id;

	@NotNull(message = "Debe ingresar el nombre")
	@Column(name = "persona_nombre", nullable = false, length = 80)
	private String nombre;

	@NotEmpty
	@Column(name = "persona_apellido", nullable = false, length = 80)
	private String apellido;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "persona_fecha_nacimiento",nullable = false, length = 20)
	private Date fechaNacimiento;

	@NotNull
	@Column(name = "persona_dni",nullable = false, length = 20)
	private Integer dni;

	@NotEmpty
	@Column(name = "persona_sexo",nullable = false, length = 12)
	private String sexo;

	@NotEmpty
	@Column(name = "persona_domicilio",nullable = false, length = 50)
	private String domicilio;



	@OneToMany(mappedBy = "persona")
	private List<Vehiculo> vehiculos;


	
	public Persona() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

}
