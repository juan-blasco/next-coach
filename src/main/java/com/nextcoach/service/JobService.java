package com.nextcoach.service;

import org.springframework.data.domain.Page;

import com.nextcoach.dto.JobDTO;
import com.nextcoach.service.search.JobSearchCriteria;

public interface JobService {

	Page<JobDTO> getJobs(JobSearchCriteria criteria);

	JobDTO getJob(Long id);

}
