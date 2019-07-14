package edu.xidian.boot.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.xidian.boot.model.Student;

@Mapper
public interface StuMapper {
	Student getStu(int id);
}
