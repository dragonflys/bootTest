package edu.xidian.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.xidian.boot.model.Person;

@Mapper
public interface PersonMapper {
	@Select("SELECT * FROM person WHERE id = #{id}")
	Person getPerById(int id);

	@Select("SELECT * FROM person")
	List<Person> getPerAll();

	void updatePerById(Person Person);

	void insert(Person Person);

}
