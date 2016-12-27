package com.nextcoach.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nextcoach.domain.Club;
import com.nextcoach.domain.Job;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {

	Page<Job> findByClub(Club club, Pageable page);

}
