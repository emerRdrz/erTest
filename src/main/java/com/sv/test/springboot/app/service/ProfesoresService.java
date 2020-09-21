package com.sv.test.springboot.app.service;

import java.util.List;

import com.sv.test.springboot.app.pojos.Profesores;



public interface ProfesoresService {

	public abstract Profesores addProfesor(Profesores profesor);
	
	public abstract List<Profesores> listAllProfesores();
	
	public abstract Profesores findProfesorById(int idProfesor);
	
	public abstract void removeProfesor(int idProfesor);

}
