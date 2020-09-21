package com.sv.test.springboot.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sv.test.springboot.app.pojos.Grados;
import com.sv.test.springboot.app.repository.GradosRepository;
import com.sv.test.springboot.app.service.GradosService;

@Service("gradosService")
public class GradosServiceImpl implements GradosService{
	
	@Autowired
	@Qualifier("gradosRepository")
	private GradosRepository gradoRepository;

	@Override
	public Grados addGrado(Grados grado) {
		return gradoRepository.save(grado);
	}
	
	@Override
	public List<Grados> listAllGrados() {
		return gradoRepository.findAll();
	}
	
	@Override
	public Grados findGradoById(int idGrado) {		
		return gradoRepository.findByIdGrado(idGrado);
	}
	
	@Override
	public void removeGrado(int idGrado) {
		gradoRepository.deleteById(idGrado);		
	}
}
