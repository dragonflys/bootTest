package edu.xidian.boot.controller;

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

import edu.xidian.boot.model.Person;
import edu.xidian.boot.service.PersonService;

@RestController
@RequestMapping("/per")
public class HelloController {

	@Autowired
	PersonService perService;

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@GetMapping("/{id}")
	public ModelAndView getPer(@PathVariable int id, Model model) {
		Person person = perService.getStu(id);
		model.addAttribute("stu", person);
		log.debug("stu is {}", person);
		ModelAndView modelAndView = new ModelAndView("hello");
		return modelAndView;
	}

	@GetMapping("/all")
	public ModelAndView getPerAll() {
		List<Person> list = perService.getPerAll();
		ModelAndView modelAndView = new ModelAndView("hello2");
		modelAndView.addObject("stuList", list);
		return modelAndView;
	}

	@GetMapping("/update")
	public void updatePerById() {
//		Person person = new Person(1, "赵四", 30, null, "广州", Gender.MAN, Marital.UNMARRIED);
//		try {
//			person.setBirth(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-03-20").getTime()));
//		} catch (ParseException e) {
//			log.error("解析时间出错！");
//			e.printStackTrace();
//		}
//		log.debug("stu is {}", person);
//		perService.updatePerById(person);
	}

	@GetMapping("/insert")
	public void insert() {
//		Person person = new Person(3, "王五", 22, null, "郑州", Gender.WOMAN, Marital.ENGAGED);
//		person.setId(null);
//		perService.insert(person);
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
