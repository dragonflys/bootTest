package edu.xidian.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.boot.dao.StuMapper;
import edu.xidian.boot.model.Student;

@Service
@Transactional
public class StuService {

	@Autowired
	StuMapper stuMapper;

	public Student getStu(int id) {
		return stuMapper.getStu(id);
	}

	public List<Student> getStuAll() {
		return stuMapper.getStuAll();
	}

	public void updateStuById(Student student) {
		stuMapper.updateStuById(student);
	}

	public void insert(Student student) {
		stuMapper.insert(student);
	}

}
