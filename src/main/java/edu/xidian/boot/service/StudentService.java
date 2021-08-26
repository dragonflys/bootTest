package edu.xidian.boot.service;

import java.util.List;

import edu.xidian.boot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.boot.dao.StudentMapper;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentMapper mapper;

    public Student getStu(int id) {
        return mapper.getStuById(id);
    }

    public List<Student> getPerAll() {
        return mapper.getPerAll();
    }

    public void updatePerById(Student student) {
        mapper.updatePerById(student);
    }

    public void insert(Student student) {
        mapper.insert(student);
    }

    public void delete(Integer id) {
        mapper.deleteById(id);
    }

}
