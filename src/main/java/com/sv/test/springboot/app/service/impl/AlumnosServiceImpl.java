package com.sv.test.springboot.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sv.test.springboot.app.pojos.Alumnos;
import com.sv.test.springboot.app.repository.AlumnosRepository;
import com.sv.test.springboot.app.service.AlumnosService;

@Service("alumnosService")
public class AlumnosServiceImpl implements AlumnosService{
	
	@Autowired
	@Qualifier("alumnosRepository")
	private AlumnosRepository alumnoRepository;

	@Override
	public Alumnos addAlumno(Alumnos alumno) {
		return alumnoRepository.save(alumno);
	}
	
	@Override
	public List<Alumnos> listAllAlumnos() {
		return alumnoRepository.findAll();
	}
	
	@Override
	public Alumnos findAlumnoById(int idAlumno) {		
		return alumnoRepository.findByIdAlumno(idAlumno);
	}
	
	@Override
	public void removeAlumno(int idAlumno) {
		alumnoRepository.deleteById(idAlumno);		
	}
	
	@Override
	public Alumnos findAlumnoByNumeroCarnet(String numeroCarnet) {
		return alumnoRepository.findByNumeroCarnet(numeroCarnet);
	}
}
