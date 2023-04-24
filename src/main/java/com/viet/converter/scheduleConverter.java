package com.viet.converter;

import org.springframework.stereotype.Component;

import com.viet.dto.NewDTO;
import com.viet.dto.courseDTO;
import com.viet.dto.schedulesDTO;
import com.viet.entity.courseEntity;
import com.viet.entity.coursesGroupEntity;
import com.viet.entity.scheduleEntity;

@Component
public class scheduleConverter {
	public scheduleEntity toEntity(schedulesDTO dto) {
		scheduleEntity sE = new scheduleEntity();
		sE.setCoursesGroupId(dto.getCoursesGroupId());
		sE.setDay(dto.getDay());
		sE.setLessonTime(dto.getLessonTime());
		sE.setRoom(dto.getRoom());
		sE.setStart(dto.getStart());
		sE.setWeek(dto.getWeek());
		
		return sE;
	}
	public schedulesDTO toDTO(scheduleEntity entity) {
		schedulesDTO dto = new schedulesDTO();
		dto.setCoursesGroupId(entity.getCoursesGroupId());
		dto.setDay(entity.getDay());
		dto.setLessonTime(entity.getLessonTime());
		dto.setRoom(entity.getRoom());
		dto.setStart(entity.getStart());
		dto.setWeek(entity.getWeek());
		return dto;
	}
	public scheduleEntity toEntity(schedulesDTO dto,scheduleEntity sE) {
		
		sE.setDay(dto.getDay());
		sE.setLessonTime(dto.getLessonTime());
		sE.setRoom(dto.getRoom());
		sE.setStart(dto.getStart());
		sE.setWeek(dto.getWeek());
		
		return sE;
	}
	
}
