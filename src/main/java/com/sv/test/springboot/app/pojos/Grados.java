package com.sv.test.springboot.app.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grados")
public class Grados {
	
	@Id
	@GeneratedValue
	@Column(name = "id_grado")
	private int idGrado;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "idGrado")
    private List<Profesores> profesoresList;

	public Grados() {
	}

	public int getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Profesores> getProfesoresList() {
		return profesoresList;
	}

	public void setProfesoresList(List<Profesores> profesoresList) {
		this.profesoresList = profesoresList;
	}	
	

}
