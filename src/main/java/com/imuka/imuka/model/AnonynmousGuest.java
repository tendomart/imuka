package com.imuka.imuka.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anonymous_guest")
//public class AnonynmousGuest extends AuditModel implements Serializable{
	public class AnonynmousGuest  implements Serializable{

	public AnonynmousGuest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnonynmousGuest(Long id, String district, String gender, String job, String interest,
			String country) {
		super();
		this.id = id;
		this.district = district;
		this.gender = gender;
		this.job = job;
		this.interest = interest;
		this.country = country;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8628416285602314314L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "district", nullable = false)
	public String district;
	
	@Column(name = "gender", nullable = false)
	public String gender;
	
	@Column(name = "job", nullable = false)
	private String job;
	
	@Column(name = "interest", nullable = false)
	private String interest;
	
	@Column(name = "country", nullable = false)
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
//	@Override
//	public Date getCreatedAt() {
//		// TODO Auto-generated method stub
//		return super.getCreatedAt();
//	}
//	
//	@Override
//	public void setCreatedAt(Date createdAt) {
//		// TODO Auto-generated method stub
//		super.setCreatedAt(createdAt);
//	}
	
}
