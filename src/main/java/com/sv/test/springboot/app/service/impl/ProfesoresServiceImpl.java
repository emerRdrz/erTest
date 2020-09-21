package com.sv.test.springboot.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sv.test.springboot.app.pojos.Profesores;
import com.sv.test.springboot.app.repository.ProfesoresRepository;
import com.sv.test.springboot.app.service.ProfesoresService;



@Service("profesoresService")
public class ProfesoresServiceImpl implements ProfesoresService{
	
	@Autowired
	@Qualifier("profesoresRepository")
	private ProfesoresRepository profesorRepository;

	@Override
	public Profesores addProfesor(Profesores profesor) {
		return profesorRepository.save(profesor);
	}
	
	@Override
	public List<Profesores> listAllProfesores() {
		return profesorRepository.findAll();
	}
	
	@Override
	public Profesores findProfesorById(int idProfesor) {		
		return profesorRepository.findByIdProfesor(idProfesor);
	}
	
	@Override
	public void removeProfesor(int idProfesor) {
		profesorRepository.deleteById(idProfesor);		
	}
}
