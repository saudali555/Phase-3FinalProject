package com.org.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Product implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int pid;
	private String pname;
	private String color;
	private BigDecimal price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	private Category category;
	
	@ManyToMany//(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name="orders",
		joinColumns = @JoinColumn(name = "pid"),
		inverseJoinColumns = @JoinColumn(name = "uid"))
	private List<User> users=new ArrayList<>();
	
	public Product() {
		
	}
	
	public Product(int pid, String pname, String color, BigDecimal price, Category category, List<User> users) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.color = color;
		this.price = price;
		this.category = category;
		this.users = users;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<User> getUsers() {
		return users;
	}

	public void addUsers(User user) {
		this.users.add(user);
	}
	
}