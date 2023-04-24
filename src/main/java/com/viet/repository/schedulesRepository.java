package com.viet.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.viet.entity.courseEntity;
import com.viet.entity.coursesGroupEntity;
import com.viet.entity.scheduleEntity;
public interface schedulesRepository extends JpaRepository<scheduleEntity, Integer>{
    List<scheduleEntity> findBycoursesGroupId(int cGI);
    List<scheduleEntity> findByDayAndRoom(String day, int room);
    List<scheduleEntity> findByDayAndRoomAndIdNot(String day, int room,int id);
    List<scheduleEntity> findBycoursesGroupIdAndDay(int id,String day);

    
		
}
