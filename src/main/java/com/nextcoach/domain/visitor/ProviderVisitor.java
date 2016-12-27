package com.nextcoach.domain.visitor;

public interface ProviderVisitor {

	boolean acceptsClub();

	boolean acceptsCoach();

	boolean acceptsAdmin();
}
