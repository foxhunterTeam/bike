package com.poshbike.core.web;

import java.util.ArrayList;

import org.springframework.data.domain.Page;

public class PageResult<T> {

	private Iterable<T> data = new ArrayList<T>();

	private Long totalSize = 0L;

	public PageResult(Page<T> page) {
		this.data = page.getContent();
		this.totalSize = page.getTotalElements();
	}

	public PageResult(Iterable<T> data, Long totalSize) {
		this.data = data;
		this.totalSize = totalSize;
	}

	public PageResult(Iterable<T> data, Integer totalSize) {
		this.data = data;
		this.totalSize = Long.valueOf(totalSize);
	}

	public Iterable<T> getData() {
		return data;
	}

	public Long getTotalSize() {
		return totalSize;
	}

}
