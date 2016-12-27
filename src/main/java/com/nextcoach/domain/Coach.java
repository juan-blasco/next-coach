package com.nextcoach.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.nextcoach.domain.visitor.ProviderVisitor;

@Entity
public class Coach extends Profile {

	private static final long serialVersionUID = 1798718954338544142L;

	@Column
	private String name;

	@Column
	private String location;

	@Column
	private String phone;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Experience> experience = new ArrayList<>();

	public Coach() {
		// TODO Auto-generated constructor stub
	}

	public boolean addExperience(Experience experience) {
		return this.getExperience().add(experience);
	}

	public boolean removeExperience(Experience experience) {
		return this.getExperience().remove(experience);
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

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}

	@Override
	public boolean accepts(ProviderVisitor visitor) {
		return visitor.acceptsCoach();
	}

}
