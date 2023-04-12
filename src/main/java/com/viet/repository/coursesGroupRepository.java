package com.viet.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.viet.entity.courseEntity;
import com.viet.entity.coursesGroupEntity;
public interface coursesGroupRepository extends JpaRepository<coursesGroupEntity, Integer>{
		
}
