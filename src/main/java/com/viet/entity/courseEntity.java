package com.viet.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name="courses")
public class courseEntity {
	@Id	//set privamy key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//id tự tăngF
	private int id;
	@Column(name="courses_code")
	private String coursesCode;
	@Column(name="courses")	//định nghĩa table name sẽ tạo ra trong mysql
	private String name;
	@Column(name="credit_hour")
	private String creditHour;
	@Column(name="class_hour")
	private String classHour;
	@OneToMany(mappedBy = "courses")
	private List<coursesGroupEntity> grp = new ArrayList<>();
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
	public List<coursesGroupEntity> getGrp() {
		return grp;
	}
	public void setGrp(List<coursesGroupEntity> grp) {
		this.grp = grp;
	}
	
	
}
