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

import com.nextcoach.dto.ClubDTO;
import com.nextcoach.dto.JobDTO;
import com.nextcoach.service.ClubService;
import com.nextcoach.service.search.ClubSearchCriteria;

@RestController
@RequestMapping("/api/v1/")
public class ClubController {

	@Autowired
	private ClubService clubService;

	@RequestMapping(value = "/clubs/{clubId}", method = RequestMethod.GET)
	@ResponseBody
	public ClubDTO getClub(@PathVariable Long clubId) {
		return clubService.getClub(clubId);
	}

	@Secured("ROLE_CLUB")
	@RequestMapping(value = "/clubs/{clubId}", method = RequestMethod.PUT)
	@ResponseBody
	public ClubDTO editClub(@PathVariable Long clubId, @RequestBody ClubDTO clubDTO) {
		return clubService.editClub(clubId, clubDTO);
	}

	@Secured("ROLE_CLUB")
	@RequestMapping(value = "/clubs/{clubId}/jobs", method = RequestMethod.POST)
	@ResponseBody
	public ClubDTO addJob(@PathVariable Long clubId, @RequestBody JobDTO jobDTO) {
		return clubService.addJob(clubId, jobDTO);
	}

	@Secured("ROLE_CLUB")
	@RequestMapping(value = "/clubs/{clubId}/jobs/{jobId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ClubDTO removeJob(@PathVariable Long clubId, @PathVariable Long jobId) {
		return clubService.removeJob(clubId, jobId);
	}

	@RequestMapping(value = "/clubs", method = RequestMethod.GET)
	@ResponseBody
	public Page<ClubDTO> getClubs(@RequestParam Integer page, @RequestParam Integer size) {
		return clubService.getClubs(
				ClubSearchCriteria.builder()
						.page(page)
						.pageSize(size)
						.build());
	}
}
