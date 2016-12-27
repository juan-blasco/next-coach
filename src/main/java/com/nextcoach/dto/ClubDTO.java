package com.nextcoach.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ClubDTO extends ProfileDTO {

	private static final long serialVersionUID = 6176397149954023454L;

	private List<JobDTO> jobs;

	@NotNull
	private String name;

	@NotNull
	private String location;

	@NotNull
	private String phone;

	@NotNull
	private String contactName;

	public ClubDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<JobDTO> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobDTO> jobs) {
		this.jobs = jobs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
}
