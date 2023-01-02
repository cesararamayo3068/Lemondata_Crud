package ar.com.lemondata.ejercicio.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author César
 * 
 */
@Entity(name = "VEHICULOS")
@Table(name = "VEHICULOS")
public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 5836967339724076670L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehiculo_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "vehiculo_patente", length = 8)
	private String patente;

	@Column(name = "vehiculo_anio", length = 4)
	private Integer anio;

	@Column(name = "vehiculo_marca", length = 16)
	private String marca;

	@Column(name = "vehiculo_modelo", length = 16)
	private String modelo;

	@Column(name = "vehiculo_color", length = 16)
	private String color;

	@Column(name = "vehiculo_tipo_uso", length = 30)
	private String tipoDeUso;



	//@Column(name = "vehiculo_propietario", length = 30)
	@ManyToOne
	private Persona persona;

	public Vehiculo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipoDeUso() {
		return tipoDeUso;
	}

	public void setTipoDeUso(String tipoDeUso) {
		this.tipoDeUso = tipoDeUso;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
	
	
	

}
