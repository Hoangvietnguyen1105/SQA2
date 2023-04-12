package com.viet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="schedules")
public class scheduleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "day")
	private String day;
	@Column(name="start")
	private	int start;
	@Column(name="lession_time")
	private	int lession_time;
	@Column(name = "room")
	private int room;
	@ManyToOne
	@JoinColumn(name = "weeks_id")
	private weekEntity weeks;
	@ManyToOne
	@JoinColumn(name = "courses_groups_id")
	private coursesGroupEntity coursesGroup;
	
}
