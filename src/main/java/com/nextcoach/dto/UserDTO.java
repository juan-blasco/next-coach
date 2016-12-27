package com.nextcoach.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	private String username;

	@NotNull
	private String pass;

	@NotNull
	@Email
	private String email;

	@Valid
	private ProfileDTO profile;

	@NotNull
	private Boolean active;

	@NotNull
	private Boolean receiveNotifications;

	@NotNull
	private Date dob;

	private Boolean verified;

	private Boolean isAdmin;

	private Boolean isClub;

	private Boolean isCoach;

	public UserDTO() {
		this.verified = Boolean.FALSE;
		this.isAdmin = Boolean.FALSE;
		this.isClub = Boolean.FALSE;
		this.isCoach = Boolean.FALSE;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ProfileDTO getProfile() {
		return profile;
	}

	public void setProfile(ProfileDTO profile) {
		this.profile = profile;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getReceiveNotifications() {
		return receiveNotifications;
	}

	public void setReceiveNotifications(Boolean receiveNotifications) {
		this.receiveNotifications = receiveNotifications;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsCoach() {
		return isCoach;
	}

	public void setIsCoach(Boolean isCoach) {
		this.isCoach = isCoach;
	}

	public Boolean getIsClub() {
		return isClub;
	}

	public void setIsClub(Boolean isClub) {
		this.isClub = isClub;
	}
}
