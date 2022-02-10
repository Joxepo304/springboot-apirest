package com.formacionspring.app.apirest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name="clientes") //Esto es para definir como se va a llamar la base de datos
public class Cliente implements Serializable{
	//Lo que hacemos con esta implementacion es para generar el Id unico y nos vamos
	//a Cliente subrayado amarillo y encima pinchamos "add serial version Id"
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	//Poniendo @Id y despues @GeneratedValue(strategy= GenerationType.IDENTITY)
	//lo que hacemos es que el Id nos coja como un identificiador unico de la base de datos.
	private long id; //es el identificador de la base de datos
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	
	@Column(name="create_at") //Con esto vamos a ser capaces de modificar la base de datos
	@Temporal(TemporalType.DATE) //Esto nos reconoce el dato Date
	private Date createdAt;
	
	@PrePersist //Esto es para que se ejecute este metodo (el insertar la fecha actual) cuando introducimos un dato pero por setters.
	public void prePersist() {
		if (createdAt==null) {
		createdAt = new Date();
		}
	}//con este metodo nos toma la fecha actual, 
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	
}
