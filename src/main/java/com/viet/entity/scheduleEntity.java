package com.viet.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "schedules")
public class scheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "day")
    private String day;

    @Column(name = "start")
    private int start;

    @Column(name = "lesson_time")
    private int lessonTime;

    @Column(name = "room")
    private int room;

    @Column(name = "courses_group_id")
    private int coursesGroupId;

    @Column(name = "week")
    private int[] week;
    // ...

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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