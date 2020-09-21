package com.sv.test.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.test.springboot.app.pojos.Profesores;

@Repository("profesoresRepository")
public interface ProfesoresRepository extends JpaRepository<Profesores, Serializable>{
	
	public abstract Profesores findByIdProfesor(int idProfesor);

}
