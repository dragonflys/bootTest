package edu.xidian.boot.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.xidian.boot.Enum.Marital;
import edu.xidian.boot.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonMapperTest {
	@Autowired
	private PersonMapper mapper;

	@Test
	public void testGetPerById() {
		Person person = mapper.getPerById(6);
		System.out.println(person);
	}

	@Test
	public void testGetPerAll() {
		List<Person> perAll = mapper.getPerAll();
		for (Person person : perAll) {
			System.out.println(person);
		}
	}

	@Test
	public void testUpdatePerById() {
		Person person = new Person(5, "曹雪芹", 222, null, "金陵", true, Marital.ENGAGED);
		mapper.updatePerById(person);
	}

	@Test
	public void testInsert() {
		Person person = new Person(6, "林黛玉", 26, null, "扬州", false, Marital.ENGAGED);
		person.setId(null);
		mapper.insert(person);
	}

}
