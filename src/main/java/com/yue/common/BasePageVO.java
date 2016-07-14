package com.yue.common;

import com.yue.utils.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * 公共的查询参数
 */
public class BasePageVO {
	public final static int PAGE_SHOW_COUNT = 20;
	private int pageNum = 1;    //第几页
	private int pageSize = 0;   //每页多少条
	private int totalCount = 0;
	private String orderField;
	private String orderDirection;
	public BasePageVO(int pageNum, int pageSize, int totalCount, String orderField, String orderDirection){
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.orderField = orderField;
		this.orderDirection = orderDirection;
	}


	public Pageable getPageable(){
		Pageable pageable = null;
		if (!StringUtils.isEmpty(orderField)){
			Sort sort = new Sort(this.getDirection(),orderField);
			pageable = new PageRequest(this.getStartIndex(),this.getPageSize(),sort);
		}else {
			pageable = new PageRequest(this.getStartIndex(),this.getPageSize());
		}
		return pageable;
	}

	public Sort.Direction getDirection(){
		return "desc".equals(orderDirection) ? Sort.Direction.DESC : Sort.Direction.ASC;
	}

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize > 0 ? pageSize : PAGE_SHOW_COUNT;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderDirection() {
		return "desc".equals(orderDirection) ? "desc" : "asc";
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartIndex() {
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		return pageNum;
	}
}
