package com.imuka.imuka.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "training_sessions")
public class TrainingSessions extends AuditModel implements Serializable{

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
	private Date start_date;
	
	@Column(name = "end_date")
	private Date end_date;

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

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
