package com.nextcoach.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.nextcoach.domain.visitor.ProviderVisitor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Profile implements Serializable {

	private static final long serialVersionUID = -2604801642829754943L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	public Profile() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public abstract boolean accepts(ProviderVisitor providerVisitor);
}
