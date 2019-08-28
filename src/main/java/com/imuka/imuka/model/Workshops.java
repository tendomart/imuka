package com.imuka.imuka.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "workshops")
public class Workshops   implements Serializable{
	public Workshops(Long id, String location, String address, String trainer, String topic, String fee,
			String contact,String start_date, String end_date) {
		super();
		this.id = id;
		this.location = location;
		this.address = address;
		this.trainer = trainer;
		this.topic = topic;
		this.fee = fee;
		this.contact = contact;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	//public class Workshops extends AuditModel implements Serializable{

	

	public Workshops() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = -929252149761771211L;
	
	
	
	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "location")
	public String location;
	
	@Column(name = "address")
	public String address;
	
	@Column(name = "trainer")
	public String trainer;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "fee")
	private String fee;
	
	@Column(name = "contact")
	private String contact;
	
	//@DateTimeFormat(pattern = "MM/dd/yyyy")
	//@Column(name = "start_date")
	//private Date start_date;
	
	//@DateTimeFormat(pattern = "MM/dd/yyyy")
	//@Column(name = "end_date")
	//private Date end_date;

	@Column(name = "start_date")
	private String start_date;
	
	@Column(name = "end_date")
	private String end_date;

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

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
}
