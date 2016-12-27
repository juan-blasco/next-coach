package com.nextcoach.domain.visitor;

public class ClubVisitor implements ProviderVisitor {

	@Override
	public boolean acceptsClub() {
		return true;
	}

	@Override
	public boolean acceptsCoach() {
		return false;
	}
	
	@Override
	public boolean acceptsAdmin() {
		return false;
	}
}
