package com.nextcoach.dto.mapper;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.nextcoach.domain.Admin;
import com.nextcoach.domain.Club;
import com.nextcoach.domain.Coach;
import com.nextcoach.domain.Job;
import com.nextcoach.domain.User;
import com.nextcoach.dto.AdminDTO;
import com.nextcoach.dto.ClubDTO;
import com.nextcoach.dto.CoachDTO;
import com.nextcoach.dto.ExperienceDTO;
import com.nextcoach.dto.JobDTO;
import com.nextcoach.dto.UserDTO;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class Mapper extends ConfigurableMapper {

	public Mapper() {
		super(false);
	}

	@PostConstruct
	public void initMapper() {
		init();
	}

	protected void configure(MapperFactory factory) {
		factory.classMap(Club.class, ClubDTO.class).byDefault().register();
		factory.classMap(Coach.class, CoachDTO.class).byDefault().register();
		factory.classMap(Admin.class, AdminDTO.class).byDefault().register();
		factory.classMap(ExperienceDTO.class, ExperienceDTO.class).byDefault().register();
		factory.classMap(Job.class, JobDTO.class).byDefault().register();
		factory.classMap(User.class, UserDTO.class)
				.exclude("isAdmin")
				.exclude("isCoach")
				.exclude("isClub")
				.byDefault().register();
	}
}
