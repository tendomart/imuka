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
@Table(name = "events")

public class Events  implements Serializable{
//	public class Events extends AuditModel implements Serializable{

	public Events(Long id, String event_name, String location, String topic, String facilitator, String fee,
			String start_date) {
		super();
		this.id = id;
		this.event_name = event_name;
		this.location = location;
		this.topic = topic;
		this.facilitator = facilitator;
		this.fee = fee;
		this.start_date = start_date;
	}


	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 6085650249556688612L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "event_name")
	public String event_name;
	
	@Column(name = "location")
	public String location;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "facilitator")
	private String facilitator;
	
	@Column(name = "fee")
	private String fee;

	
	@Column(name = "start_date")
	private String start_date;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEvent_name() {
		return event_name;
	}


	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getFacilitator() {
		return facilitator;
	}


	public void setFacilitator(String facilitator) {
		this.facilitator = facilitator;
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


	public void setStart_date(Date start_date) {
		this.start_date = start_date.toString();
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


		
}
