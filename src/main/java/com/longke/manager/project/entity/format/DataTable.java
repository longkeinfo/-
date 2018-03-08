package com.longke.manager.project.entity.format;

import java.util.List;

import com.longke.manager.project.entity.base.BaseEntity;
/**
 * 
 * @ClassName: DataTable  
 * @Description: 表格返回模板
 * @author "Alex Hu"
 * @date 2018年1月19日 下午2:36:01  
 *  
 * @param <T>
 */
public class DataTable<T> extends BaseEntity {

	/**  
	 * @Fields serialVersionUID : 序列化
	 */  
	private static final long serialVersionUID = 1L;

	/**
	 * 当前页
	 */
	private int current;

	/**
	 * 每页的行数
	 */
	private int rowCount;

	/**
	 * 数据总数
	 */
	private long total;

	/**
	 * 数据列表
	 */
	private List<T> rows;

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
