package com.viet.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.viet.dto.NewDTO;
import com.viet.services.courseService;
import com.viet.services.coursesGroupService;

@RestController

public class NewAPI {

		@Autowired
		private coursesGroupService newService;
        @PostMapping(value="/create-coursesGroup")
        public NewDTO createNew(@RequestBody NewDTO model) {

                return newService.save(model);

        }
        @PutMapping(value = "/create-coursesGroup/{id}")
        
        public NewDTO updateNew(@RequestBody NewDTO model,@PathVariable("id") int id) {
        	 model.setId(id);
        	return newService.update(model);
        }
        
        @DeleteMapping(value = "/delete-coursesGroup")
        public void deleteNew(@RequestBody int id) {
        	newService.delete(id);
        }

}