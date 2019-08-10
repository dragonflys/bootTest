package edu.xidian.boot.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.xidian.boot.Enum.Gender;
import edu.xidian.boot.Enum.StuStatus;
import edu.xidian.boot.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuMapperTest {
	@Autowired
	private StuMapper mapper;

	@Test
	public void testGetStu() {
		Student stu = mapper.getStu(6);
		System.out.println(stu);
	}

	@Test
	public void testGetStuAll() {
		List<Student> stuAll = mapper.getStuAll();
		for (Student student : stuAll) {
			System.out.println(student);
			System.out.println(student.getGender());
		}

	}

	@Test
	public void testUpdateStuById() {
		Student stu = new Student(6, null, 18, null, "南京", Gender.WOMAN, StuStatus.ONLINE);
		mapper.updateStuById(stu);
	}

	@Test
	public void testInsert() {
//		Student stu = new Student(null, "王", 22, null, "南京", Gender.MAN);
//		mapper.insert(stu);
	}

}
