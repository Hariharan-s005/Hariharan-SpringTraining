package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(value = "hello1", method = RequestMethod.GET)
	public void sayHello()
	{
		System.out.println("Hello world");
	}
	@RequestMapping(value = "hello2",method = RequestMethod.GET)
	public String sayHello2()
	{
		System.out.println("Hello2 is called");
		return "Welcome";
	}
	@RequestMapping(value = "hello3",method = RequestMethod.GET)
	public ResponseEntity<String> sayHello3()
	{
		return ResponseEntity.ok("Hi!! and Welcome to MVC");
	}
	@RequestMapping(value = "hello4",method = RequestMethod.GET)
	public ModelAndView sayHello4()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mykey", "Welcome to Spring mvc3 from injected object...");
		modelAndView.addObject("hello", "Sirius");
		modelAndView.setViewName("Welcome1");
		return modelAndView;
	}
	@RequestMapping(value = "hello5",method = RequestMethod.GET)
	public ModelAndView sayHello5(ModelAndView modelAndView)
	{
		modelAndView.addObject("mykey", "Welcome to Spring mvc4 from injected object...");
		modelAndView.setViewName("Welcome1");
		return modelAndView;
	}
	@RequestMapping(value = "hello6",method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView modelAndView,HttpServletRequest request)
	{
		modelAndView.addObject("mykey","welcome to spring from SayHello6....");
		modelAndView.setViewName("Welcome1");
		HttpSession session = request.getSession();
		request.setAttribute("hello", "Hello World from request 6 Object");
		session.setAttribute("hello2", "Hello from session object");
		return modelAndView;
	}
	@RequestMapping(value = "repeat",method = RequestMethod.GET)
	public ModelAndView sayHello7(ModelAndView modelAndView,HttpServletRequest request)
	{
		modelAndView.addObject("mykey","welcome to spring from Repeat....");
		modelAndView.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return modelAndView;
	}
	@RequestMapping(value = "hello7/{name}", method = RequestMethod.GET)
	public ModelAndView sayHello8(@PathVariable String name,ModelAndView modelAndView,HttpServletRequest request) {
		modelAndView.addObject("mykey",name);
		modelAndView.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return modelAndView;
	}
	@RequestMapping(value = "hello8", method = RequestMethod.GET)
	public ModelAndView sayHello9(@RequestParam("uname") String name,ModelAndView modelAndView,HttpServletRequest request) {
		modelAndView.addObject("mykey",name);
		modelAndView.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 8 Object");
		return modelAndView;
	}
	@RequestMapping(value ="hello9",method = RequestMethod.GET)
	public ResponseEntity<User> sayHello11()
	{
		User user= new User();
		user.setUid(100);
		user.setUsername("Hari");
		return ResponseEntity.ok(user);
	}
	@RequestMapping(value="hello10",method = RequestMethod.POST)
	public ResponseEntity<User> sayHello12(@RequestBody User user)
	{
		user.setUid(1000000);
		user.setUsername("Hariharan");
		return ResponseEntity.ok(user);
	}
	@RequestMapping(value="hello11",method = RequestMethod.POST)
	public User sayHello13(@RequestBody User user)
	{
		user.setUid(500);
		user.setUsername("Hariharan S");
		return user;
	}
}
