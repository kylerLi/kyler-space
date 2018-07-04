package com.kyler.space.common;

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

	/**
	 * 排序字段
	 */
	protected String orderByClause;

	private Integer mysqlOffset;

	private Integer mysqlLength;

	protected Criteria(Criteria example) {
		this.orderByClause = example.orderByClause;
		this.condition = example.condition;
		this.distinct = example.distinct;
		this.mysqlLength = example.mysqlLength;
		this.mysqlOffset = example.mysqlOffset;
	}

	public Criteria() {
		condition = new HashMap<String, Object>();
	}

	public void clear() {
		condition.clear();
		orderByClause = null;
		distinct = false;
		this.mysqlOffset = null;
		this.mysqlLength = null;
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
	 * 得到键值，C层和S层的参数传递时取值所用<br>
	 * 自行转换对象
	 * 
	 * @param key
	 *            键值
	 * @return 返回指定键所映射的值
	 */
	public Object get(String key) {
		return this.condition.get(key);
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

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	/**
	 * @param mysqlOffset
	 *            指定返回记录行的偏移量<br>
	 *            mysqlOffset= 5,mysqlLength=10; // 检索记录行 6-15
	 */
	public void setMysqlOffset(Integer mysqlOffset) {
		this.mysqlOffset = mysqlOffset;
	}

	/**
	 * @param mysqlLength
	 *            指定返回记录行的最大数目<br>
	 *            mysqlOffset= 5,mysqlLength=10; // 检索记录行 6-15
	 */
	public void setMysqlLength(Integer mysqlLength) {
		this.mysqlLength = mysqlLength;
	}
	
	public String getOrderByClause() {
		return orderByClause;
	}

	public Integer getMysqlOffset() {
		return mysqlOffset;
	}

	public Integer getMysqlLength() {
		return mysqlLength;
	}
	
	
}