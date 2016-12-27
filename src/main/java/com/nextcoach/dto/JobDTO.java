package com.nextcoach.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class JobDTO implements Serializable {

	private static final long serialVersionUID = 2801031992342879064L;

	private Long id;

	@NotNull
	private String position;

	@NotNull
	private String description;

	@NotNull
	private String salary;

	private ClubDTO club;

	public JobDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public ClubDTO getClub() {
		return club;
	}

	public void setClub(ClubDTO club) {
		this.club = club;
	}
}
