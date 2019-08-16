package com.imuka.imuka.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "training_sessions")
public class TrainingSessions  implements Serializable{
	

	public TrainingSessions(Long id, String location, String trainer, String sector, String fee,
			LocalDateTime start_date, LocalDateTime end_date) {
		super();
		this.id = id;
		this.location = location;
		this.trainer = trainer;
		this.sector = sector;
		this.fee = fee;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	//public class TrainingSessions extends AuditModel implements Serializable{

	public TrainingSessions() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5489793884372589639L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "location")
	public String location;
	
	@Column(name = "trainer")
	public String trainer;
	
	@Column(name = "sector")
	private String sector;
	
	@Column(name = "fee")
	private String fee;
	
	@Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime start_date;
    
	@Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime end_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	//@Column(name = "start_date")
	//private String start_date;
	
	//@Column(name = "end_date")
	//private String end_date;

	
}
