package edu.xidian.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.xidian.boot.model.Student;
import edu.xidian.boot.service.StuService;

@Controller
public class HelloController {

	@Autowired
	StuService stuService;

	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("hello/{id}")
	public String sayHello(@PathVariable int id, Model model) {
		Student student = stuService.getStu(id);
		model.addAttribute("stu", student);
		logger.debug("stu is {}", student);
		return "hello";
	}

}
