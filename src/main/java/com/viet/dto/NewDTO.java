package com.viet.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.viet.entity.courseEntity;

public class NewDTO {

	
	
	private int groupCode;
	private int labCode;
	private int id;
	
    private String course_code;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	
    
   
}