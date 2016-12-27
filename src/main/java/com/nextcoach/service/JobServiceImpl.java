package com.nextcoach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextcoach.domain.Club;
import com.nextcoach.domain.Job;
import com.nextcoach.dto.JobDTO;
import com.nextcoach.dto.mapper.Mapper;
import com.nextcoach.repository.ClubRepository;
import com.nextcoach.repository.JobRepository;
import com.nextcoach.service.search.JobSearchCriteria;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private ClubRepository clubRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public JobDTO getJob(Long id) {
		return fromJob(jobRepository.findOne(id));
	}

	@Override
	public Page<JobDTO> getJobs(JobSearchCriteria criteria) {
		Page<Job> jobs = null;

		if (criteria.getClubId() == null) {
			jobs = jobRepository.findAll(criteria.getPageRequest());
		} else {
			Club club = clubRepository.findOne(criteria.getClubId());
			jobs = jobRepository.findByClub(club, criteria.getPageRequest());
		}

		return jobs.map(job -> fromJob(job));
	}

	private JobDTO fromJob(Job job) {
		return mapper.map(job, JobDTO.class);
	}
}
