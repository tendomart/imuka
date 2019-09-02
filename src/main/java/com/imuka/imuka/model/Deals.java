package com.imuka.imuka.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deals")
public class Deals implements Serializable{

	public Deals(Long id, Double init_price, Double disc_price, String deal) {
		super();
		this.id = id;
		this.init_price = init_price;
		this.disc_price = disc_price;
		this.deal = deal;
	}

	public Deals() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 207792248830601228L;
	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "init_price")
	public Double init_price;
	
	@Column(name = "disc_price")
	public Double disc_price;

	@Column(name = "deal")
	public String deal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getInit_price() {
		return init_price;
	}

	public void setInit_price(Double init_price) {
		this.init_price = init_price;
	}

	public Double getDisc_price() {
		return disc_price;
	}

	public void setDisc_price(Double disc_price) {
		this.disc_price = disc_price;
	}

	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Double getDiscount(String init_price,String disc_price) {	
		return (this.init_price-this.disc_price);
		
	}
}
