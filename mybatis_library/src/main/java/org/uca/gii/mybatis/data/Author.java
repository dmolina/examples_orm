package org.uca.gii.mybatis.data;

public class Author {
	private String name;
	private String direction;
	private String genero;
	private int age;

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the genero
	 */
	private String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	private void setGenero(String genero) {
		this.genero = genero;
	}

}
