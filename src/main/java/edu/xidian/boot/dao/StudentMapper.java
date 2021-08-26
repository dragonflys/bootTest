package edu.xidian.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import edu.xidian.boot.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getStuById(int id);

    @Select("SELECT * FROM student")
    List<Student> getPerAll();

    void updatePerById(Student student);

    void insert(Student student);

    @Delete("delete from student where id = #{id}")
    void deleteById(Integer id);

}
