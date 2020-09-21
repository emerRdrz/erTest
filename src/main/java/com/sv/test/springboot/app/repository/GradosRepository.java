package com.sv.test.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.test.springboot.app.pojos.Grados;

@Repository("gradosRepository")
public interface GradosRepository extends JpaRepository<Grados, Serializable>{
	
	public abstract Grados findByIdGrado(int idGrado);

}
