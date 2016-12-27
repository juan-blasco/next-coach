package com.nextcoach.dto;

import java.io.Serializable;

public abstract class ProfileDTO implements Serializable {

	private static final long serialVersionUID = -4492161777920490541L;

	private Long id;

	public ProfileDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
