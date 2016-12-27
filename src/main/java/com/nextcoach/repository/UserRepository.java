package com.nextcoach.repository;

import org.springframework.data.repository.CrudRepository;

import com.nextcoach.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);

}
