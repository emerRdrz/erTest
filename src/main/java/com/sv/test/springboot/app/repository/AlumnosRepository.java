package com.sv.test.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.test.springboot.app.pojos.Alumnos;

@Repository("alumnosRepository")
public interface AlumnosRepository extends JpaRepository<Alumnos, Serializable>{
	
	public abstract Alumnos findByIdAlumno(int idAlumno);
	
	public abstract Alumnos findByNumeroCarnet(String numeroCarnet);

}
