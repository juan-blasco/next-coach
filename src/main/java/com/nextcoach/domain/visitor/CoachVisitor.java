package com.nextcoach.domain.visitor;

public class CoachVisitor implements ProviderVisitor {

	@Override
	public boolean acceptsClub() {
		return false;
	}

	@Override
	public boolean acceptsCoach() {
		return true;
	}

	@Override
	public boolean acceptsAdmin() {
		return false;
	}
}
