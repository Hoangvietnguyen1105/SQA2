	package com.viet.services;

import java.util.List;

import com.viet.dto.NewDTO;
import com.viet.entity.courseEntity;
import com.viet.entity.coursesGroupEntity;

public interface coursesGroupService {
	String	save(NewDTO	newDTO);
	String	update(NewDTO newDTO);
	void delete(int id);
	List<coursesGroupEntity>  getCG(String id);
	

}
	