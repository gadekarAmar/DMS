package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="fate_rate")
public class FatePrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private Cattle cattle;

	private  double fateRate;
	public FatePrice() {
		super();
	}
	public FatePrice( double fateRate) {
		super();
		this.fateRate = fateRate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getFateRate() {
		return fateRate;
	}
	public void setFateRate(double fateRate) {
		this.fateRate = fateRate;
	}
	public Cattle getCattle() {
		return cattle;
	}
	public void setCattle(Cattle cattle) {
		this.cattle = cattle;
	}
	@Override
	public String toString() {
		return "FatePrice [id=" + id + ", cattle=" + cattle + ", fateRate=" + fateRate + "]";
	}
	
	

	
	
	

}
