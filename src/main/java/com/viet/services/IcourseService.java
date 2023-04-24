package com.viet.services;

import java.util.List;

import com.viet.dto.NewDTO;
import com.viet.dto.courseDTO;
import com.viet.entity.courseEntity;

public interface IcourseService {
	String	save(courseDTO	coursedto);
	String	update(courseDTO	coursedto);
	void delete(int id);
	List<courseEntity>  getAll();
}

