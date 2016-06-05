package com.tshop.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公用条件查询类
 */
public class Page<T> {

    private List<T> list;

    public Page(Criteria criteria) {
        this.currentPage = criteria.getCurrentPage();
        this.pageSize = criteria.getPageSize();
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


    public Page() {

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