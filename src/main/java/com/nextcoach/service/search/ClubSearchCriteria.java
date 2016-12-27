package com.nextcoach.service.search;

import org.springframework.data.domain.PageRequest;

public class ClubSearchCriteria {
	private int page;
	private int pageSize;

	private ClubSearchCriteria() {

	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		int page;
		int pageSize;

		public Builder page(int page) {
			this.page = page;
			return this;
		}

		public Builder pageSize(int pageSize) {
			this.pageSize = pageSize;
			return this;
		}

		public ClubSearchCriteria build() {
			ClubSearchCriteria o = new ClubSearchCriteria();
			o.setPage(page);
			o.setPageSize(pageSize);
			return o;
		}
	}

	public PageRequest getPageRequest() {
		return new PageRequest(page, pageSize);
	}

	public int getPage() {
		return page;
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
