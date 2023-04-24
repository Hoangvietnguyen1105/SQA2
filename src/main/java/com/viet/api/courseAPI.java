package com.viet.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
 
import com.viet.dto.NewDTO;
import com.viet.dto.courseDTO;
import com.viet.entity.courseEntity;
import com.viet.services.IcourseService;
import com.viet.services.coursesGroupService;

@RestController

public class courseAPI {

		@Autowired
		private IcourseService courseService;
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @PostMapping(value="/create-courses")
        public String create(@RequestBody courseDTO model) {
        		String a = courseService.save(model);
                return a;
                
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @PutMapping(value = "/update-courses")
        public String update(@RequestBody courseDTO model) {
        	 
        	return courseService.update(model);
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @PostMapping(value = "/delete-courses")
        public String delete(@RequestBody courseDTO model) {
        	courseService.delete(model.getId());
        	return "xoá thành công";
        }
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @GetMapping(value="/get-all-courses")
        public List<courseEntity> getAll() {
            List<courseEntity> courses = courseService.getAll();
            return courses;
        }

}