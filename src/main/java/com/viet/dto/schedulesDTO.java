package com.viet.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.viet.entity.courseEntity;

public class schedulesDTO {
	
    private String day;
	private int id;

    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	private int start;

   
    private int lessonTime;

    
    private int room;

   
    private int coursesGroupId;

   
    private int[] week;


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getLessonTime() {
		return lessonTime;
	}


	public void setLessonTime(int lessonTime) {
		this.lessonTime = lessonTime;
	}


	public int getRoom() {
		return room;
	}


	public void setRoom(int room) {
		this.room = room;
	}


	public int getCoursesGroupId() {
		return coursesGroupId;
	}


	public void setCoursesGroupId(int coursesGroupId) {
		this.coursesGroupId = coursesGroupId;
	}


	public int[] getWeek() {
		return week;
	}


	public void setWeek(int[] week) {
		this.week = week;
	}
	
	
	
	
    
   
}