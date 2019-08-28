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
@Table(name = "visit_opportunities")
public class VisitOpportunities  implements Serializable{
public VisitOpportunities(Long id, String location, String agent, String fee, String contact, String start_date,
			String end_date) {
		super();
		this.id = id;
		this.location = location;
		this.agent = agent;
		this.fee = fee;
		this.contact = contact;
		this.start_date = start_date;
		this.end_date = end_date;
	}

public VisitOpportunities() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public class VisitOpportunities extends AuditModel implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7136042703655478360L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "location")
	public String location;
	
	@Column(name = "agent")
	public String agent;
	
	
	@Column(name = "fee")
	private String fee;
	

	@Column(name = "contact")
	public String contact;
	
	
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

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
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

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date.toString();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
