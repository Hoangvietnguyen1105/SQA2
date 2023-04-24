package com.viet.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.viet.entity.courseEntity;
import com.viet.entity.coursesGroupEntity;
import com.viet.entity.scheduleEntity;
public interface coursesGroupRepository extends JpaRepository<coursesGroupEntity, Integer>{
   
    List<coursesGroupEntity> findBycourseCode(String courseCode);
    coursesGroupEntity findByGroupCodeAndCourseCode(int labCode, String courseCode);
    coursesGroupEntity findByGroupCodeAndCourseCodeAndIdNot(int labCode, String courseCode,int id);

}
