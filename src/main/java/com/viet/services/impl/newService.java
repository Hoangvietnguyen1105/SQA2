package com.viet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viet.converter.newConverter;
import com.viet.dto.NewDTO;
import com.viet.repository.courseRepository;
import com.viet.repository.coursesGroupRepository;
import com.viet.repository.schedulesRepository;
import com.viet.services.IschedulesService;
import com.viet.services.coursesGroupService;
import com.viet.entity.coursesGroupEntity;
import com.viet.entity.scheduleEntity;
import com.viet.entity.courseEntity;
@Service
public class newService implements coursesGroupService{
	@Autowired
	private coursesGroupRepository cGR;
	@Autowired
	private courseRepository cR;
	@Autowired
	private newConverter nC;
	@Autowired
	private schedulesRepository sR;
	@Autowired
	private IschedulesService schedulesService;
	@Override
	public String save(NewDTO newDTO) {
		// TODO Auto-generated method stub
		coursesGroupEntity a =cGR.findByGroupCodeAndCourseCode(newDTO.getGroupCode(), newDTO.getCourse_code());
		if(a != null) {
			return "Duplicated";
		}
		coursesGroupEntity cGE = nC.toEntity(newDTO);
		cGE = cGR.save(cGE);
		return "Success";
	}
	public String update(NewDTO newDTO) {
		coursesGroupEntity a =cGR.findByGroupCodeAndCourseCodeAndIdNot(newDTO.getGroupCode(), newDTO.getCourse_code(),newDTO.getId());
		if(a != null) {
			return "Duplicated";
		}
		
		coursesGroupEntity OcGE = cGR.findOne(newDTO.getId());
		coursesGroupEntity NcGE	= nC.toEntity(newDTO, OcGE);
		
		NcGE = cGR.save(NcGE);

		return "Success";
	}
	public void delete(int id) {
		List<scheduleEntity>a = sR.findBycoursesGroupId(id);
		if(!a.isEmpty()) {
			for(scheduleEntity item:a) {
				schedulesService.delete(item.getId());
			}
		}
		
		cGR.delete(id);
	}
	@Override
	public List<coursesGroupEntity> getCG(String courseCode) {
		
		return cGR.findBycourseCode(courseCode);
	}
	
	
	
}
