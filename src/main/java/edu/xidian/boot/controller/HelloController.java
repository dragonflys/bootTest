package edu.xidian.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.xidian.boot.model.Student;
import edu.xidian.boot.service.StuService;

@RestController
@RequestMapping("/stu")
public class HelloController {

	@Autowired
	StuService stuService;

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/{id}")
	public ModelAndView sayHello(@PathVariable int id, Model model) {
		Student student = stuService.getStu(id);
		model.addAttribute("stu", student);
		log.debug("stu is {}", student);
		ModelAndView modelAndView = new ModelAndView("hello");
		return modelAndView;
	}

	@GetMapping("/login/{name}")
	public String login(@PathVariable String name, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("name", name);
		return "login";
	}

	@GetMapping("/get")
	public Object get(HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession();
		return httpSession.getAttribute("name");
	}

	@GetMapping("/update")
	public void updateStuById() {
		Student student = new Student();
		student.setId(2);
		student.setSchAddress("河南工业大学");
//		student.setName("王彦龙");
//		String time = "1989-10-20";
//		try {
//			student.setBirth(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(time).getTime()));
//		} catch (ParseException e) {
//			log.error("解析时间出错！");
//			e.printStackTrace();
//		}
//		student.setAge(29);
		log.debug("stu is {}", student);
		stuService.updateStuById(student);
	}

	@GetMapping("/insert")
	public void insert() {
		Student student = new Student();
		student.setId(6);
		student.setName("张双丽");
		student.setAge(0);
//		try {
//			student.setBirth(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1990-02-08").getTime()));
//		} catch (ParseException e) {
//			log.error("解析生日时间出错");
//			e.printStackTrace();
//		}
		stuService.insert(student);
	}

}
