package com.tshop.page;

import java.util.HashMap;
import java.util.Map;

/**
 * 公用条件查询类
 */
public class Criteria {
	/**
	 * 存放条件查询值
	 */
	private Map<String, Object> condition;

	/**
	 * 是否相异
	 */
	protected boolean distinct;

	private int currentPage = 1; // 当前页
	private int pageSize = 10; // 页大小

	/**
	 * 排序字段
	 */
	protected String orderByClause;
	/**
	 * 分页字段
	 */
	protected String limitClause;

	protected Criteria(Criteria example) {
		this.orderByClause = example.orderByClause;
		this.condition = example.condition;
		this.distinct = example.distinct;
		this.limitClause = example.limitClause;
	}

	public Criteria() {
		condition = new HashMap<String, Object>();
	}

	public void clear() {
		condition.clear();
		orderByClause = null;
		distinct = false;
		limitClause = null;
	}

	/**
	 * @param condition
	 *            查询的条件名称
	 * @param value
	 *            查询的值
	 */
	public Criteria put(String condition, Object value) {
		this.condition.put(condition, value);
		return (Criteria) this;
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

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}