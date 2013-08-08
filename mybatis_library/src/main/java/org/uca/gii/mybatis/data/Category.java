package org.uca.gii.mybatis.data;

public class Category {
     private String descripcion;
     private int minimum_age;
	/**
	 * @return the description
	 */
	public String getDescription() {
		return descripcion;
	}
	/**
	 * @param descripcion the description to set
	 */
	public void setDescription(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the minimum_age
	 */
	public int getMinimum_age() {
		return minimum_age;
	}
	/**
	 * @param minimum_age the minimum_age to set
	 */
	public void setMinimum_age(int minimum_age) {
		this.minimum_age = minimum_age;
	}
}
