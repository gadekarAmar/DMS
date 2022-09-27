package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "milk_tbl",uniqueConstraints = {@UniqueConstraint(columnNames= {"user_id","session","date"})})
public class MilkCollection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private Session session;

	private double liter;

	private double fate;

	private double fateRate;

	private LocalDate date;

	private double price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	
	private Users user;

	public MilkCollection() {
		super();
	}

	public MilkCollection(Session session, double liter, double fate, double fateRate, Users user, LocalDate date) {
		super();
		this.session = session;
		this.liter = liter;
		this.fate = fate;
		this.fateRate = fateRate;
		this.price = liter * fate * fateRate;
		this.date = date;
		this.user=user;

	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public double getLiter() {
		return liter;
	}

	public void setLiter(double liter) {
		this.liter = liter;
	}

	public double getFate() {
		return fate;
	}

	public void setFate(double fate) {
		this.fate = fate;
	}

	public double getFateRate() {
		return fateRate;
	}

	public void setFateRate(double fateRate) {
		this.fateRate = fateRate;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public LocalDate getEntryDate() {
		return date;
	}


	@Override
	public String toString() {
		return "MilkCollection [id=" + id + ", session=" + session + ", liter=" + liter + ", fate=" + fate
				+ ", fateRate=" + fateRate + ", entryDate=" + date + ", price=" + price + ", user=" + user + "]";
	}

	
}
