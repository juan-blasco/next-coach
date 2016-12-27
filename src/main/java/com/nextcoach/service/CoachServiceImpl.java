package com.nextcoach.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextcoach.domain.Coach;
import com.nextcoach.domain.Experience;
import com.nextcoach.dto.CoachDTO;
import com.nextcoach.dto.ExperienceDTO;
import com.nextcoach.dto.mapper.Mapper;
import com.nextcoach.repository.CoachRepository;
import com.nextcoach.repository.ExperienceRepository;
import com.nextcoach.service.search.CoachSearchCriteria;

@Service
public class CoachServiceImpl implements CoachService {

	@Autowired
	private CoachRepository coachRepository;

	@Autowired
	private ExperienceRepository experienceRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public CoachDTO saveCoach(CoachDTO coachDTO) {
		Coach coach = coachRepository.save(toCoach(coachDTO));
		return fromCoach(coach);
	}

	@Override
	public CoachDTO addExperience(Long coachId, ExperienceDTO experienceDTO) {
		Coach coach = coachRepository.findOne(coachId);
		coach.addExperience(toExperience(experienceDTO));
		coach = coachRepository.save(coach);
		return fromCoach(coach);
	}

	@Override
	public CoachDTO removeExperience(Long coachId, Long experienceId) {
		Experience experience = experienceRepository.findOne(experienceId);
		Coach coach = coachRepository.findOne(coachId);
		coach.removeExperience(experience);
		coach = coachRepository.save(coach);
		return fromCoach(coach);
	}

	@Override
	public List<ExperienceDTO> getExperience(Long coachId) {
		Coach coach = coachRepository.findOne(coachId);
		return coach.getExperience()
				.stream()
				.map(exp -> fromExperience(exp))
				.collect(Collectors.toList());
	}

	@Override
	public CoachDTO getCoach(Long id) {
		Coach coach = coachRepository.findOne(id);
		return fromCoach(coach);
	}

	@Override
	public Page<CoachDTO> getCoaches(CoachSearchCriteria criteria) {
		return coachRepository.findAll(criteria.getPageRequest())
				.map(coach -> fromCoach(coach));
	}

	@Override
	public CoachDTO editCoach(Long coachId, CoachDTO coachDTO) {
		Coach coach = coachRepository.findOne(coachId);
		coach.setLocation(coachDTO.getLocation());
		coach.setName(coachDTO.getName());
		coach.setPhone(coachDTO.getPhone());
		coachRepository.save(coach);
		return fromCoach(coach);
	}

	private Coach toCoach(CoachDTO coachDTO) {
		return mapper.map(coachDTO, Coach.class);
	}

	private CoachDTO fromCoach(Coach coach) {
		return mapper.map(coach, CoachDTO.class);
	}

	private Experience toExperience(ExperienceDTO experienceDTO) {
		return mapper.map(experienceDTO, Experience.class);
	}

	private ExperienceDTO fromExperience(Experience experience) {
		return mapper.map(experience, ExperienceDTO.class);
	}
}
