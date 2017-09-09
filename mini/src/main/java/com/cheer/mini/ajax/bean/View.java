package com.cheer.mini.ajax.bean;

import java.io.Serializable;
import java.util.List;

public abstract class View<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4302849221058948678L;
	
	private Pageinfo pageinfo;
	private List<T> records;
	public Pageinfo getPageinfo() {
		return pageinfo;
	}
	public void setPageinfo(Pageinfo pageinfo) {
		this.pageinfo = pageinfo;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "View [pageinfo=" + pageinfo + ", records=" + records + "]";
	}

	
}
