package com.nextcoach.service;

import org.springframework.data.domain.Page;

import com.nextcoach.dto.ClubDTO;
import com.nextcoach.dto.JobDTO;
import com.nextcoach.service.search.ClubSearchCriteria;

public interface ClubService {

	ClubDTO getClub(Long id);

	ClubDTO saveClub(ClubDTO club);
	
	ClubDTO editClub(Long clubId, ClubDTO club);

	Page<ClubDTO> getClubs(ClubSearchCriteria searchCriteria);

	ClubDTO addJob(Long clubId, JobDTO job);

	ClubDTO removeJob(Long clubId, Long jobId);
}
