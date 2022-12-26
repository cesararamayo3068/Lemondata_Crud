package ar.com.lemondata.ejercicio.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "persona_nombre", nullable = false, length = 80)
	private String nombre;

	@Column(name = "persona_apellido", nullable = false, length = 80)
	private String apellido;
	
	@Column(name = "persona_fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "persona_dni")
	private Integer dni;
	
	@Column(name = "persona_sexo")
	private String sexo;
	
	@Column(name = "persona_domicilio")
	private String domicilio;
	
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
	
	

}
