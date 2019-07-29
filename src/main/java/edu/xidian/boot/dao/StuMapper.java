package edu.xidian.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.xidian.boot.model.Student;

@Mapper
public interface StuMapper {
	@Select("select * from Student where id = #{id}")
	Student getStu(int id);

	@Select("select * from Student")
	List<Student> getStuAll();

	void updateStuById(Student student);

	void insert(Student student);

}
