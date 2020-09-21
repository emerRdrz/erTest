package com.sv.test.springboot.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log {
	
	@Id
	@GeneratedValue
	@Column(name = "id_log")
	private int idLog;
	
	@Column(name = "registration_date")
	private Date registrationDate;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "url")
	private String url;

	public Log() {
	}

	public Log(int idLog, Date registrationDate, String details, String username, String url) {
		super();
		this.idLog = idLog;
		this.registrationDate = registrationDate;
		this.details = details;
		this.username = username;
		this.url = url;
	}

}
