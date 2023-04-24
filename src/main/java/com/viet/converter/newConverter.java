package com.viet.converter;

import org.springframework.stereotype.Component;

import com.viet.dto.NewDTO;
import com.viet.entity.coursesGroupEntity;

@Component
public class newConverter {
	public coursesGroupEntity toEntity(NewDTO dto) {
		coursesGroupEntity entity = new coursesGroupEntity();
		entity.setGroupCode(dto.getGroupCode());
		entity.setLabCode(dto.getLabCode());
		entity.setCourseCode(dto.getCourse_code());
		return entity;
	}
	public NewDTO toDTO(coursesGroupEntity cGE) {
		NewDTO dto = new NewDTO();
		dto.setGroupCode(cGE.getGroupCode());
		dto.setLabCode(cGE.getLabCode());
		
		return dto;
	}
	public coursesGroupEntity toEntity(NewDTO dto,coursesGroupEntity entity) {
		
		entity.setGroupCode(dto.getGroupCode());
		
		
		return entity;
	}
}
