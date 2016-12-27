package com.nextcoach.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = -6486643672967679201L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String username;

	@Column
	private String pass;

	@Column(unique = true)
	private String email;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Profile profile;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column
	private boolean active;

	@Column
	private boolean receiveNotifications;

	@Column
	private boolean verified;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isReceiveNotifications() {
		return receiveNotifications;
	}

	public void setReceiveNotifications(boolean receiveNotifications) {
		this.receiveNotifications = receiveNotifications;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
}
