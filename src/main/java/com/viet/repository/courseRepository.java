package com.viet.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.viet.entity.courseEntity;
public interface courseRepository extends JpaRepository<courseEntity, Integer>{
		courseEntity findOneBycoursesCode(String coursesCode);
		courseEntity findOneByName(String name);

}
