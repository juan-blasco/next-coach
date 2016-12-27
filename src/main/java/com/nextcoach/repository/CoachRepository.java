package com.nextcoach.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nextcoach.domain.Coach;

public interface CoachRepository extends PagingAndSortingRepository<Coach, Long> {

}
