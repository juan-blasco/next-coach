package com.nextcoach.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.nextcoach.domain.visitor.ProviderVisitor;

@Entity
public class Club extends Profile {

	private static final long serialVersionUID = 8836094075497277316L;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "club")
	private List<Job> jobs = new ArrayList<>();

	@Column
	private String name;

	@Column
	private String location;

	@Column
	private String phone;

	@Column
	private String contactName;

	public Club() {
		// TODO Auto-generated constructor stub
	}

	public boolean addJob(Job job) {
		return getJobs().add(job);
	}

	public boolean removeJob(Job job) {
		return getJobs().remove(job);
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
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

	@Override
	public boolean accepts(ProviderVisitor visitor) {
		return visitor.acceptsClub();
	}
}
