package com.edubridge.app2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WashingMachine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // Unique identifier for the washing machine.
	private String name; // Brand/model name of the washing machine.
	private String email; // Contact email for the service center.
	private String mobile; // Contact mobile number for service or support.

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "WashingMachine [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
}
