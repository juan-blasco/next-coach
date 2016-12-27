package com.nextcoach.domain.visitor;

public class AdminVisitor implements ProviderVisitor {

	@Override
	public boolean acceptsClub() {
		return false;
	}

	@Override
	public boolean acceptsCoach() {
		return false;
	}
	
	@Override
	public boolean acceptsAdmin() {
		return true;
	}
}
