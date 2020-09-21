package com.sv.test.springboot.app.service;

import java.util.List;

import com.sv.test.springboot.app.pojos.Alumnos;



public interface AlumnosService {

	public abstract Alumnos addAlumno(Alumnos alumno);
	
	public abstract List<Alumnos> listAllAlumnos();
	
	public abstract Alumnos findAlumnoById(int idAlumno);
	
	public abstract void removeAlumno(int idAlumno);
	
	public abstract Alumnos findAlumnoByNumeroCarnet(String numeroCarnet);

}
