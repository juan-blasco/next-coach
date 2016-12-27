package com.nextcoach.service.search;

import org.springframework.data.domain.PageRequest;

public class JobSearchCriteria {

	private int page;
	private int pageSize;
	private Long clubId;

	private JobSearchCriteria() {

	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		int page;
		int pageSize;
		Long clubId;

		public Builder page(int page) {
			this.page = page;
			return this;
		}

		public Builder pageSize(int pageSize) {
			this.pageSize = pageSize;
			return this;
		}

		public Builder clubId(Long clubId) {
			this.clubId = clubId;
			return this;
		}

		public JobSearchCriteria build() {
			JobSearchCriteria o = new JobSearchCriteria();
			o.setPage(page);
			o.setPageSize(pageSize);
			o.setClubId(clubId);
			return o;
		}
	}

	public PageRequest getPageRequest() {
		return new PageRequest(page, pageSize);
	}

	public int getPage() {
		return page;
	}

	public void setClubId(Long clubId) {
		this.clubId = clubId;
	}

	public Long getClubId() {
		return clubId;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
