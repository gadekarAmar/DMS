package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user_tbl",uniqueConstraints = {@UniqueConstraint(columnNames= {"email","cattle"})})
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Column(length = 20)
	private String name;
	@NotBlank
	@Column(length = 20)
	private String lastName;
	@Column(length = 255)
	private String address;
	@Column(length = 30)
	@NotBlank
	private String password;
	@Enumerated(EnumType.STRING)
	
	private Cattle cattle;
	@NotBlank(message = "Email is Cumpalsary")
	@Column(length = 30,unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	private Role role;
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	private String imageUrl;
	
	
	//edited by sameer ,cascade = CascadeType.ALL
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private Set<MilkCollection> milkCollection=new HashSet<MilkCollection>();
	
	
	
	public Users() {
		super();
	}
	
	
	public Users(@NotBlank String name, @NotBlank String lastName, String address, String password, Cattle cattle,String email,Role role) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.password = password;
		this.cattle = cattle;
		this.email=email;
		this.role=role;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Cattle getCattle() {
		return cattle;
	}


	public void setCattle(Cattle cattle) {
		this.cattle = cattle;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address + ", password="
				+ password + ", cattle=" + cattle + ", email=" + email + ", role=" + role + "]";
	}


	}





	
	

	
	


