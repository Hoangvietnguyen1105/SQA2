package com.viet.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.viet.entity.courseEntity;
public interface courseRepository extends JpaRepository<courseEntity, Integer>{
		courseEntity findOneBycoursesCode(String coursesCode);
		courseEntity findOneByNameAndIdNot(String name,int id);
		courseEntity findOneBycoursesCodeAndIdNot(String coursesCode,int id);
		courseEntity findOneByName(String name);


}
