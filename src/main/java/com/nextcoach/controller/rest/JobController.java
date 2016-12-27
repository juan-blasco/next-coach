package com.nextcoach.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextcoach.dto.JobDTO;
import com.nextcoach.service.JobService;
import com.nextcoach.service.search.JobSearchCriteria;

@RestController
@RequestMapping("/api/v1/")
public class JobController {

	@Autowired
	private JobService jobService;

	@RequestMapping(value = "/jobs/{jobId}", method = RequestMethod.GET)
	public JobDTO getJob(@PathVariable Long jobId) {
		return jobService.getJob(jobId);
	}

	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public Page<JobDTO> getJobs(@RequestParam Integer page, @RequestParam Integer pageSize,
			@RequestParam(required = false) Long clubId) {

		JobSearchCriteria criteria = JobSearchCriteria.builder()
				.page(page)
				.pageSize(pageSize)
				.clubId(clubId)
				.build();

		return jobService.getJobs(criteria);
	}
}
