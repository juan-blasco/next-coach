package com.nextcoach.domain;

import javax.persistence.Entity;

import com.nextcoach.domain.visitor.ProviderVisitor;

@Entity
public class Admin extends Profile {

	private static final long serialVersionUID = 1210213353380464856L;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accepts(ProviderVisitor providerVisitor) {
		return providerVisitor.acceptsAdmin();
	}
}
