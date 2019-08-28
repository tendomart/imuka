package com.imuka.imuka.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "confirmation")
public class Confirmation implements Serializable{

	

	public Confirmation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Confirmation(Long id, String phone, String email) {
		super();
		this.id = id;
		this.phone = phone;
		this.email = email;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 4621608379792669408L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "phone")
	public String phone;

	@Column(name = "email")
	public String email;
	public String getContact() {
		return email;
	}
	public void setContact(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
