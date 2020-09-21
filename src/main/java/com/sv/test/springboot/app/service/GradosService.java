package com.sv.test.springboot.app.service;

import java.util.List;

import com.sv.test.springboot.app.pojos.Grados;


public interface GradosService {

	public abstract Grados addGrado(Grados grado);
	
	public abstract List<Grados> listAllGrados();
	
	public abstract Grados findGradoById(int idGrado);
	
	public abstract void removeGrado(int idGrado);

}
