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
import com.viet.entity.userEntity;
import com.viet.services.IuserService;
import com.viet.services.coursesGroupService;
import com.viet.services.impl.userService;

@RestController

public class userApi {

		@Autowired
		private IuserService userService;
        @CrossOrigin(origins = "http://127.0.0.1:5555")
        @PostMapping(value="/check-login")
        public String getAll(@RequestBody userEntity model) {
        		String a = userService.getAll(model);
                return a;
                
        }
        

}