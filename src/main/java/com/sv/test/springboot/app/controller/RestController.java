package com.sv.test.springboot.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sv.test.springboot.app.pojos.Alumnos;
import com.sv.test.springboot.app.pojos.dto.AlumnoDTO;
import com.sv.test.springboot.app.service.AlumnosService;







@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	@Autowired
	@Qualifier("alumnosService")
	AlumnosService alumnosService;
	
	@GetMapping("/consultaAlumno/{numeroCarnet}")
	public ResponseEntity<AlumnoDTO> consultaAlumno(@PathVariable("numeroCarnet") String numeroCarnet){
		Alumnos alumno = new Alumnos();
		AlumnoDTO alumnoDTO = new AlumnoDTO();
		
		alumno = alumnosService.findAlumnoByNumeroCarnet(numeroCarnet);
		
		if(alumno != null) {
			alumnoDTO.setNombre(alumno.getNombre());
			alumnoDTO.setApellidos(alumno.getApellidos());
			alumnoDTO.setEdad(alumno.getEdad());
			alumnoDTO.setNumeroCarnet(alumno.getNumeroCarnet());
			alumnoDTO.setNombrePadre(alumno.getNombrePadre());
			alumnoDTO.setNombreMadre(alumno.getNombreMadre());
			alumnoDTO.setNotaFinal(alumno.getNotaFinal());
			alumnoDTO.setProfesor(alumno.getIdProfesor().getNombre() + " " + alumno.getIdProfesor().getApellidos());
			alumnoDTO.setGrado(alumno.getIdProfesor().getIdGrado().getNombre());
		}
		
		return new ResponseEntity<AlumnoDTO>(alumnoDTO, HttpStatus.OK);
	}
	

}
