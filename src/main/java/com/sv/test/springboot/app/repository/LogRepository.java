package com.sv.test.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sv.test.springboot.app.pojos.Log;



@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable>{

}
