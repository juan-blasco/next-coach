package com.nextcoach.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nextcoach.dto.CoachDTO;
import com.nextcoach.dto.ExperienceDTO;
import com.nextcoach.service.search.CoachSearchCriteria;

public interface CoachService {

	CoachDTO saveCoach(CoachDTO coachDTO);

	CoachDTO addExperience(Long coachId, ExperienceDTO experienceDTO);

	CoachDTO removeExperience(Long coachId, Long experienceId);

	List<ExperienceDTO> getExperience(Long coachId);

	CoachDTO getCoach(Long id);

	Page<CoachDTO> getCoaches(CoachSearchCriteria criteria);

	CoachDTO editCoach(Long coachId, CoachDTO coachDTO);

}
