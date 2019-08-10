package edu.xidian.boot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

	@GetMapping("/{id}")
	public ModelAndView getStu(@PathVariable int id, Model model) {
		Student student = stuService.getStu(id);
		model.addAttribute("stu", student);
		log.debug("stu is {}", student);
		ModelAndView modelAndView = new ModelAndView("hello");
		return modelAndView;
	}

	@GetMapping("/all")
	public ModelAndView getStuAll() {
		List<Student> list = stuService.getStuAll();
		ModelAndView modelAndView = new ModelAndView("hello2");
		modelAndView.addObject("stuList", list);
		return modelAndView;
	}

	@GetMapping("/update")
	public void updateStuById() {
		Student student = new Student();
		student.setId(6);
		student.setSchAddress("南京");
		String time = "1993-10-01";
		try {
			student.setBirth(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(time).getTime()));
		} catch (ParseException e) {
			log.error("解析时间出错！");
			e.printStackTrace();
		}
		log.debug("stu is {}", student);
		stuService.updateStuById(student);
	}

	@GetMapping("/insert")
	public void insert() {
		Student student = new Student();
		student.setId(6);
		student.setName("赵四");
		stuService.insert(student);
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
}
