package com.viet.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses_groups")
public class coursesGroupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "group_code",nullable = false,unique = false)
	private int groupCode;
	@Column(name = "lab_code",nullable = true,unique = false)
	private int labCode;
	@ManyToOne
	@JoinColumn(name = "course_id")
	private courseEntity courses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}
	public int getLabCode() {
		return labCode;
	}
	public void setLabCode(int labCode) {
		this.labCode = labCode;
	}
	public courseEntity getCourses() {
		return courses;
	}
	public void setCourses(courseEntity courses) {
		this.courses = courses;
	}
	@OneToMany(mappedBy = "coursesGroup")
	private List<scheduleEntity> schedules = new ArrayList<>();
	
	
}
