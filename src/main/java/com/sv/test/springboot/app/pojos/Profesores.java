package com.sv.test.springboot.app.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "profesores")
public class Profesores {

	@Id
	@GeneratedValue
	@Column(name = "id_profesor")
	private int idProfesor;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "titulo")
	private String titulo;	
	
	@JoinColumn(name = "id_grado", referencedColumnName = "id_grado")
    @ManyToOne
    private Grados idGrado;
	
	@OneToMany(mappedBy = "idProfesor")
    private List<Alumnos> alumnosList;

	public Profesores() {
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	

	public Grados getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(Grados idGrado) {
		this.idGrado = idGrado;
	}

	public List<Alumnos> getAlumnosList() {
		return alumnosList;
	}

	public void setAlumnosList(List<Alumnos> alumnosList) {
		this.alumnosList = alumnosList;
	}
	
	
}
