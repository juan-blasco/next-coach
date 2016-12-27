package com.nextcoach.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nextcoach.dto.CoachDTO;
import com.nextcoach.dto.ExperienceDTO;
import com.nextcoach.service.CoachService;
import com.nextcoach.service.search.CoachSearchCriteria;

@RestController
@RequestMapping("/api/v1/")
public class CoachController {

	@Autowired
	private CoachService coachService;

	@RequestMapping(value = "/coachs/{coachId}", method = RequestMethod.GET)
	@ResponseBody
	public CoachDTO getCoach(@PathVariable Long coachId) {
		return coachService.getCoach(coachId);
	}

	@Secured("ROLE_COACH")
	@RequestMapping(value = "/coachs/{coachId}", method = RequestMethod.PUT)
	@ResponseBody
	public CoachDTO editCoach(@PathVariable Long coachId, @RequestBody CoachDTO coachDTO) {
		return coachService.editCoach(coachId, coachDTO);
	}

	@Secured("ROLE_COACH")
	@RequestMapping(value = "/coachs/{coachId}/experiences", method = RequestMethod.POST)
	@ResponseBody
	public CoachDTO addExperience(@PathVariable Long coachId, @RequestBody ExperienceDTO experienceDTO) {
		return coachService.addExperience(coachId, experienceDTO);
	}

	@Secured("ROLE_COACH")
	@RequestMapping(value = "/coachs/{coachId}/experiences/{experienceId}", method = RequestMethod.DELETE)
	@ResponseBody
	public CoachDTO removeExperience(@PathVariable Long coachId, @PathVariable Long experienceId) {
		return coachService.removeExperience(coachId, experienceId);
	}

	@RequestMapping(value = "/coachs", method = RequestMethod.GET)
	@ResponseBody
	public Page<CoachDTO> getCoachs(@RequestParam Integer page, @RequestParam Integer size) {
		return coachService.getCoaches(
				CoachSearchCriteria.builder()
						.page(page)
						.pageSize(size)
						.build());
	}
}
