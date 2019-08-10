package edu.xidian.boot.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.xidian.boot.Enum.Gender;
import edu.xidian.boot.Enum.StuStatus;

public class Student implements Serializable {
	private static final long serialVersionUID = -8581120389973521772L;
	private Integer id;
	private String name;
	private Integer age;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private String schAddress;
	private Gender gender;
	private StuStatus status;

	public StuStatus getStatus() {
		return status;
	}

	public void setStatus(StuStatus status) {
		this.status = status;
	}

	public Student() {
		super();
	}

	public Student(Integer id, String name, Integer age, Date birth, String schAddress, Gender gender,
			StuStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.schAddress = schAddress;
		this.gender = gender;
		this.status = status;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", birth=" + birth + ", schAddress="
				+ schAddress + ", gender=" + gender + ", status=" + status + "]";
	}

}
