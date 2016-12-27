package com.nextcoach.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Experience implements Serializable {

	private static final long serialVersionUID = -2007894388333459815L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String clubName;

	@Column
	private String position;

	@Column
	@Temporal(TemporalType.DATE)
	private Date from;

	@Column
	@Temporal(TemporalType.DATE)
	private Date to;

	@Column(length = 5000)
	private String description;

	@Column
	private boolean currentJob;

	public Experience() {
		// TODO Auto-generated constructor stub
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public boolean isCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(boolean currentJob) {
		this.currentJob = currentJob;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
