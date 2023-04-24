package com.viet.dto;

import javax.persistence.Column;

public class courseDTO {
	private int id;
	
	private String coursesCode;
	private String name;
	private String creditHour;
	private String classHour;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoursesCode() {
		return coursesCode;
	}
	public void setCoursesCode(String coursesCode) {
		this.coursesCode = coursesCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreditHour() {
		return creditHour;
	}
	public void setCreditHour(String creditHour) {
		this.creditHour = creditHour;
	}
	public String getClassHour() {
		return classHour;
	}
	public void setClassHour(String classHour) {
		this.classHour = classHour;
	}
	
}
