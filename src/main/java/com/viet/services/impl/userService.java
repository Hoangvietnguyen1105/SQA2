package com.viet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viet.converter.newConverter;
import com.viet.dto.NewDTO;
import com.viet.repository.courseRepository;
import com.viet.repository.coursesGroupRepository;
import com.viet.repository.schedulesRepository;
import com.viet.repository.userRepository;
import com.viet.services.IschedulesService;
import com.viet.services.IuserService;
import com.viet.services.coursesGroupService;
import com.viet.entity.coursesGroupEntity;
import com.viet.entity.scheduleEntity;
import com.viet.entity.userEntity;
import com.viet.entity.courseEntity;
@Service
public class userService implements IuserService{
	@Autowired
	private userRepository uR;
	
	
	@Override
	public String getAll(userEntity uE) {
		userEntity uE1 = uR.findByusername(uE.getUsername());
		if(uE1 != null) {
			if(uE.getPassword().equals(uE1.getPassword())) {
				return "Success";
			}
			else {
				return "Password is incorrect";
			}
		}
		else {
			return "Username is incorrect ";
		}
		
	}
	
	
	
}
