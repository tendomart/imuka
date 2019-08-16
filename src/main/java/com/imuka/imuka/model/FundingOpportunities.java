package com.imuka.imuka.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funding_opportunities")
public class FundingOpportunities  implements Serializable{
	//public class FundingOpportunities extends AuditModel implements Serializable{

	public FundingOpportunities(Long id, String location, String funder, String organisation) {
		super();
		this.id = id;
		this.location = location;
		this.funder = funder;
		this.organisation = organisation;
	}

	public FundingOpportunities() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4899317661143532295L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(name = "location")
	public String location;
	
	@Column(name = "funder")
	private String funder;
	
	@Column(name = "organisation")
	private String organisation;

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

	public String getFunder() {
		return funder;
	}

	public void setFunder(String funder) {
		this.funder = funder;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
