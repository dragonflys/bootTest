package edu.xidian.boot.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Student implements Serializable {
	private static final long serialVersionUID = -8581120389973521772L;
	private Integer id;
	private String name;
	private Integer age;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private String schAddress;

	public Student() {
		super();
	}

	public Student(Integer id, String name, Integer age, Date birth, String schAddress) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.schAddress = schAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getSchAddress() {
		return schAddress;
	}

	public void setSchAddress(String schAddress) {
		this.schAddress = schAddress;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + ", schAddress="
				+ schAddress + "]";
	}

}
