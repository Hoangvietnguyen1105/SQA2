package com.viet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viet.converter.newConverter;
import com.viet.dto.NewDTO;
import com.viet.repository.courseRepository;
import com.viet.repository.coursesGroupRepository;
import com.viet.services.courseService;
import com.viet.services.coursesGroupService;
import com.viet.entity.coursesGroupEntity;
import com.viet.entity.courseEntity;
@Service
public class newService implements coursesGroupService{
	@Autowired
	private coursesGroupRepository cGR;
	@Autowired
	private courseRepository cR;
	@Autowired
	private newConverter nC;
	@Override
	public NewDTO save(NewDTO newDTO) {
		// TODO Auto-generated method stub
		courseEntity cE = cR.findOneBycoursesCode(newDTO.getCoursesCode());
		coursesGroupEntity cGE = nC.toEntity(newDTO);
		cGE.setCourses(cE);
		cGE = cGR.save(cGE);
		return nC.toDTO(cGE);
	}
	public NewDTO update(NewDTO newDTO) {
		coursesGroupEntity OcGE = cGR.findOne(newDTO.getId());
		coursesGroupEntity NcGE	= nC.toEntity(newDTO, OcGE);
		courseEntity cE = cR.findOneBycoursesCode(newDTO.getCoursesCode());
		NcGE.setCourses(cE);
		NcGE = cGR.save(NcGE);
		return nC.toDTO(NcGE);
	}
	public void delete(int id) {
		cGR.delete(id);
	}
	
	
}
