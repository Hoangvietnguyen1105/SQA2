package com.viet.converter;

import org.springframework.stereotype.Component;

import com.viet.dto.NewDTO;
import com.viet.dto.courseDTO;
import com.viet.entity.courseEntity;
import com.viet.entity.coursesGroupEntity;

@Component
public class courseConverter {
	public courseEntity toEntity(courseDTO dto) {
		courseEntity entity = new courseEntity();
		entity.setClassHour(dto.getClassHour());
		entity.setCoursesCode(dto.getCoursesCode());
		entity.setCreditHour(dto.getCreditHour());
		entity.setName(dto.getName());
		entity.setCoursesCode(dto.getCoursesCode());
		
		return entity;
	}
	public courseDTO toDTO(courseEntity entity) {
		courseDTO dto = new courseDTO();
		dto.setClassHour(entity.getClassHour());
		dto.setCoursesCode(entity.getCoursesCode());
		dto.setCreditHour(entity.getCreditHour());
		dto.setName(entity.getName());
		return dto;
	}
	public courseEntity toEntity(courseDTO dto,courseEntity entity) {
		entity.setClassHour(dto.getClassHour());
		entity.setCreditHour(dto.getCreditHour());
		entity.setName(dto.getName());
		
		
		return entity;
	}
	
}
