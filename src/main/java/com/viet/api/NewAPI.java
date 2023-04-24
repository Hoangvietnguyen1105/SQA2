package com.viet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import com.viet.entity.courseEntity;
import com.viet.entity.coursesGroupEntity;
import com.viet.services.coursesGroupService;

@RestController

public class NewAPI {

		@Autowired
		private coursesGroupService newService;
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @PostMapping(value="/create-coursesGroup")
        public String createNew(@RequestBody NewDTO model) {
        		
                return newService.save(model);
                
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @PutMapping(value = "/update-coursesGroup")        
        public String updateNew(@RequestBody NewDTO model) {
        	
        	return newService.update(model);
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @DeleteMapping(value = "/delete-coursesGroup")
        public void deleteNew(@RequestParam("id") int id) {
        	newService.delete(id);
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @GetMapping(value="/get-all-coursesGroup")
        public List<coursesGroupEntity> getAll(@RequestParam("courseCode") String courseCode) {
            List<coursesGroupEntity> coursesG = newService.getCG(courseCode);
            return coursesG;
        }

}