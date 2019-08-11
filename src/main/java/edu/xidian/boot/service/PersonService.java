package edu.xidian.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.boot.dao.PersonMapper;
import edu.xidian.boot.model.Person;

@Service
@Transactional
public class PersonService {

	@Autowired
	PersonMapper mapper;

	public Person getStu(int id) {
		return mapper.getPerById(id);
	}

	public List<Person> getPerAll() {
		return mapper.getPerAll();
	}

	public void updatePerById(Person Person) {
		mapper.updatePerById(Person);
	}

	public void insert(Person Person) {
		mapper.insert(Person);
	}

}
