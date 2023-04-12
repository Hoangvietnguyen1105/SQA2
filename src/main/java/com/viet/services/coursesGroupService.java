package com.viet.services;

import com.viet.dto.NewDTO;

public interface coursesGroupService {
	NewDTO	save(NewDTO	newDTO);
	NewDTO	update(NewDTO newDTO);
	void delete(int id);
}
	