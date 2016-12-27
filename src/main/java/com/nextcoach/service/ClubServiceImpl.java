package com.nextcoach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nextcoach.domain.Club;
import com.nextcoach.domain.Job;
import com.nextcoach.dto.ClubDTO;
import com.nextcoach.dto.JobDTO;
import com.nextcoach.dto.mapper.Mapper;
import com.nextcoach.repository.ClubRepository;
import com.nextcoach.repository.JobRepository;
import com.nextcoach.service.search.ClubSearchCriteria;

@Service
public class ClubServiceImpl implements ClubService {

	@Autowired
	private ClubRepository clubRepository;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public ClubDTO getClub(Long id) {
		Club club = clubRepository.findOne(id);
		return fromClub(club);
	}

	@Override
	public ClubDTO saveClub(ClubDTO clubDTO) {
		Club club = toClub(clubDTO);
		club = clubRepository.save(club);
		return fromClub(club);
	}

	@Override
	public ClubDTO editClub(Long id, ClubDTO clubDTO) {
		Club club = clubRepository.findOne(id);
		club.setContactName(clubDTO.getContactName());
		club.setLocation(clubDTO.getLocation());
		club.setName(clubDTO.getName());
		club.setPhone(clubDTO.getPhone());
		club = clubRepository.save(club);
		return fromClub(club);
	}

	@Override
	public Page<ClubDTO> getClubs(ClubSearchCriteria searchCriteria) {
		return clubRepository.findAll(searchCriteria.getPageRequest())
				.map(club -> fromClub(club));
	}

	@Override
	public ClubDTO addJob(Long clubId, JobDTO jobDTO) {
		Club club = clubRepository.findOne(clubId);
		club.addJob(toJob(jobDTO));
		club = clubRepository.save(club);
		return fromClub(club);
	}

	@Override
	public ClubDTO removeJob(Long clubId, Long jobId) {
		Job job = jobRepository.findOne(jobId);
		Club club = clubRepository.findOne(clubId);
		club.removeJob(job);
		club = clubRepository.save(club);
		return fromClub(club);
	}

	private Club toClub(ClubDTO clubDTO) {
		return mapper.map(clubDTO, Club.class);
	}

	private ClubDTO fromClub(Club club) {
		return mapper.map(club, ClubDTO.class);
	}

	private Job toJob(JobDTO jobDTO) {
		return mapper.map(jobDTO, Job.class);
	}
}
