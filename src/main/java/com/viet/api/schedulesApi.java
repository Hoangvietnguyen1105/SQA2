package com.viet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viet.dto.NewDTO;
import com.viet.dto.courseDTO;
import com.viet.dto.schedulesDTO;
import com.viet.entity.coursesGroupEntity;
import com.viet.entity.scheduleEntity;
import com.viet.services.IcourseService;
import com.viet.services.IschedulesService;
import com.viet.services.coursesGroupService;
import com.viet.services.impl.newService;
import com.viet.services.impl.schedulesService;

@RestController

public class schedulesApi {

		@Autowired
		private IschedulesService schedulesService;
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @PostMapping(value="/create-schedule")
        public String create(@RequestBody schedulesDTO model) {
        		if(model.getRoom()> 150 ||model.getRoom() <101) {
        			return "room number is illegal";
        		}
        		String a = schedulesService.save(model);
                return a;
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @PutMapping(value = "/update-schedule")
        
        public String update(@RequestBody schedulesDTO model) {
        	if(model.getRoom()> 150 ||model.getRoom() <101) {
    			return "room number is illegal";
    		}
        	 String a = schedulesService.update(model);
        	return a;
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @DeleteMapping(value = "/delete-schedule")
        public String delete(@RequestParam("id") int id) {
        	schedulesService.delete(id);
        	return "xoá thành công";
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @GetMapping(value="/get-all-schedule")
        public List<scheduleEntity> getAll(@RequestParam("courseGroupId") int cGID) {
           
            return schedulesService.getAll(cGID);
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @GetMapping(value="/get-one")
        public scheduleEntity getone(@RequestParam("id") int id) {
           
            return schedulesService.getone(id);
        }
}