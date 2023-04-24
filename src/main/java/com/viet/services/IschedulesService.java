package com.viet.services;

import java.util.List;

import com.viet.dto.courseDTO;
import com.viet.dto.schedulesDTO;
import com.viet.entity.coursesGroupEntity;
import com.viet.entity.scheduleEntity;

public interface IschedulesService {
	String	save(schedulesDTO	schedulesdto);
	String	update(schedulesDTO	schedulesdto);
	void delete(int id);
	List<scheduleEntity>  getAll(int x);
	scheduleEntity getone(int id);

}
