package com.zhp.ml.text;

/**
 * label概率范围信息
 * @author zhp
 *
 */
public class ItemInfo {
	// name
	private String name;
	// 最小概率边界
	private double least_boundary;
	// 最大概率边界
	private double most_boundary;
	/**
	 * 构造函数
	 * @param name
	 * @param least_boundary
	 * @param most_boundary
	 */
	public ItemInfo(String name, double least_boundary, double most_boundary) {
		this.name = name;
		this.least_boundary = least_boundary;
		this.most_boundary = most_boundary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getLeast_boundary() {
		return least_boundary;
	}
	
	public void setLeast_boundary(double least_boundary) {
		this.least_boundary = least_boundary;
	}
	
	public double getMost_boundary() {
		return most_boundary;
	}
	
	public void setMost_boundary(double most_boundary) {
		this.most_boundary = most_boundary;
	}
	
	public String toString() {
		return name + ":[" + least_boundary + "," + most_boundary + ")";
	}
}
