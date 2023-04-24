package com.viet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viet.converter.scheduleConverter;
import com.viet.dto.courseDTO;
import com.viet.dto.schedulesDTO;
import com.viet.repository.courseRepository;
import com.viet.repository.schedulesRepository;
import com.viet.services.IschedulesService;
import com.viet.entity.courseEntity;
import com.viet.entity.scheduleEntity;
@Service
public class schedulesService implements IschedulesService {
	
	@Autowired 
	private schedulesRepository sR;
	@Autowired
	private scheduleConverter sC;
	@Override
	public String save(schedulesDTO schedulesdto) {
		List<scheduleEntity> check = sR.findByDayAndRoom(schedulesdto.getDay(), schedulesdto.getRoom());
		boolean check1 = true;
		if(!check.isEmpty()) {
			for(scheduleEntity item:check) {
				if(item.getStart() == schedulesdto.getStart()) {
					
					check1 = false; break;
				}
				else if(item.getStart()+ item.getLessonTime()>schedulesdto.getStart()&&schedulesdto.getStart()>item.getStart()) {
					check1 = false; break;
				}
				else if(schedulesdto.getStart() < item.getStart()&& schedulesdto.getStart()+schedulesdto.getLessonTime() > item.getStart()) {
					check1 = false; break;

				}
			}
		}
		List<scheduleEntity> check2 = sR.findBycoursesGroupIdAndDay( schedulesdto.getCoursesGroupId(),schedulesdto.getDay());
		if(!check2.isEmpty()) {
			for(scheduleEntity item : check2) {
				if(item.getStart() == schedulesdto.getStart()) {
					check1 = false;break;
				}
				else if(item.getStart()+ item.getLessonTime()>schedulesdto.getStart()&&schedulesdto.getStart()>item.getStart()) {
					check1 = false; break;
				}
				else if(schedulesdto.getStart() < item.getStart()&& schedulesdto.getStart()+schedulesdto.getLessonTime() > item.getStart()) {
					check1 = false; break;

				}
			}
		}
		
		if(check1 == true) {
			scheduleEntity sE = new scheduleEntity();
			sE = sC.toEntity(schedulesdto);
			sR.save(sE);
			return "Success";
		}
		else {
			return "Duplicated";
		}
		
		// TODO Auto-generated method stub

		
	}
	public String update(schedulesDTO schedulesdto) {
		List<scheduleEntity> check = sR.findByDayAndRoomAndIdNot(schedulesdto.getDay(), schedulesdto.getRoom(),schedulesdto.getId());
		boolean check1 = true;
		if(!check.isEmpty()) {
			for(scheduleEntity item:check) {
				if(item.getStart() == schedulesdto.getStart()) {
					
					check1 = false; break;
				}
				else if(item.getStart()+ item.getLessonTime()>schedulesdto.getStart()&&schedulesdto.getStart()>item.getStart()) {
					check1 = false; break;
				}
				else if(schedulesdto.getStart() < item.getStart()&& schedulesdto.getStart()+schedulesdto.getLessonTime() > item.getStart()) {
					check1 = false; break;

				}
			}
		}
		List<scheduleEntity> check2 = sR.findBycoursesGroupIdAndDay( schedulesdto.getCoursesGroupId(),schedulesdto.getDay());
		if(!check2.isEmpty()) {
			for(scheduleEntity item : check2) {
				if(item.getStart() == schedulesdto.getStart()) {
					check1 = false;break;
				}
				else if(item.getStart()+ item.getLessonTime()>schedulesdto.getStart()&&schedulesdto.getStart()>item.getStart()) {
					check1 = false; break;
				}
				else if(schedulesdto.getStart() < item.getStart()&& schedulesdto.getStart()+schedulesdto.getLessonTime() > item.getStart()) {
					check1 = false; break;

				}
			}
		}
		if(check1 == true) {
			scheduleEntity sE = sR.findOne(schedulesdto.getId());
			scheduleEntity sE1= sC.toEntity(schedulesdto, sE);
			sE1.setCoursesGroupId(sE.getCoursesGroupId());
			sR.save(sE1);
			return "Success";
		}
		else {
			return"Duplicated";
		}
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sR.delete(id);
		
	}
	@Override
	public List<scheduleEntity> getAll(int x) {
		// TODO Auto-generated method stub
		return sR.findBycoursesGroupId(x);
	}
	@Override
	public scheduleEntity getone(int id) {
		
		return sR.findOne(id);
	}
	
	
	

}
