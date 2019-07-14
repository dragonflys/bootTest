package edu.xidian.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.xidian.boot.dao.StuMapper;
import edu.xidian.boot.model.Student;

@Service
public class StuService implements IStuService {

	@Autowired
	StuMapper stuMapper;

	@Override
	public Student getStu(int id) {
		return stuMapper.getStu(id);
	}

}
