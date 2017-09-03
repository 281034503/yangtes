package com.cheer.mini.ajax.bean;

import java.io.Serializable;

public class Pageinfo implements Serializable {
	/**
	 * 
	 */
	
	private int pageSize;
	private int pageNo;
	private int count;
	private int total;
	
	
	
	public int getPageNo() {
		return pageNo;
	}



	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}



	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}




	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	@Override
	public String toString() {
		return "Pageinfo [pageNo=" + pageNo + ", pageSize=" + pageSize + ", total=" + total + ", count=" + count
				+ "]";
	}


}
