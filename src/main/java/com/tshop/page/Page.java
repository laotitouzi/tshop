package com.tshop.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公用条件查询类
 */
public class Page <T>{
	/**
	 * 存放条件查询值
	 */
	private List<T> list;

	public Page(int currentPage, int pageSize) {
		this.currentPage  = currentPage;
		this.pageSize = pageSize;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	/**
	 * 是否相异
	 */
	protected boolean distinct;

	private int currentPage = 1; // 当前页
	private int totalCount = 0; // 总行数
	private int pageSize = 10; // 页大小

	/**
	 * 排序字段
	 */
	protected String orderByClause;
	/**
	 * 分页字段
	 */
	protected String limitClause;

	protected Page(Page example) {
		this.orderByClause = example.orderByClause;
		this.distinct = example.distinct;
		this.limitClause = example.limitClause;
	}

	public Page() {

	}

	public void clear() {
		orderByClause = null;
		distinct = false;
		limitClause = null;
	}



	/**
	 * @param orderByClause
	 *            排序字段
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * @param distinct
	 *            是否相异
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public String getLimitClause() {
		int pageOffset = (this.currentPage - 1) * this.pageSize;
		limitClause = " limit " + pageOffset + "," + pageSize;
		return limitClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 得到总行数
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 得到总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		int pageCount = this.totalCount / this.pageSize + 1;
		// 如果模板==0，且总数大于1，则减一
		if ((this.totalCount % this.pageSize == 0) && pageCount > 1)
			pageCount--;
		return pageCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}