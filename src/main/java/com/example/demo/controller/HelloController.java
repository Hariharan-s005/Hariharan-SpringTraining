package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.UserService;
import com.example.demo.dto.*;
import com.example.demo.service.*;
@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Method to return UserService object 'userService'
	 * @return userService 
	 */
	public UserService getUserService() {
		return userService;
	}
	
	/**
	 *   Method to set UserService object 'userService'
	 * @param userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	/**
	 * Prints hello world on the console when the URL Path "hello1" is requested
	 */
	@GetMapping("hello1")
	public void sayHello()
	{
		System.out.println("Hello world");
	}
	
	
	
	/**
	 * Prints Hello2 on the console when the URL Path "hello2" is requested  and  displays string Welcome when URL path is requested
	 * @return String 'Welcome'
	 */
	@GetMapping("hello2")
	public String sayHello2()
	{
		System.out.println("Hello2 is called");
		return "Welcome";
	}
	
	
	
	/**
	 * Displays message on the URL path "hello3"
	 * @return ResponseEntity with status ok and status message
	 */
	@GetMapping("hello3")
	public ResponseEntity<String> sayHello3()
	{
		return ResponseEntity.ok("Hi!! and Welcome to MVC");
	}
	
	
	
	/**
	 * Displays mykey, hello and hello2 values on the URL path "hello4"
	 @return ModelAndview object 'modelAndView'
	 */
	@GetMapping("hello4")
	public ModelAndView sayHello4()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mykey", "Welcome to Spring mvc3 from injected object...");
		modelAndView.addObject("hello", "Sirius");
		modelAndView.setViewName("Welcome1");
		return modelAndView;
	}
	
	
	
	
	/**
	 *  Displays mykey, hello and hello2 values on the URL path "hello5" and uses viewName "Welcome1"
	 * @param ModelAndview object 'modelAndView'
	 * @return ModelAndview object 'modelAndView'
	 */
	@GetMapping("hello5")
	public ModelAndView sayHello5(ModelAndView modelAndView)
	{
		modelAndView.addObject("mykey", "Welcome to Spring mvc4 from injected object...");
		modelAndView.setViewName("Welcome1");
		return modelAndView;
	}
	
	
	
	/**
	 * Displays mykey, hello and hello2 values on the URL path "hello6" and uses viewName "Welcome1". Also uses HttpSession"
	 * @param ModelAndview object 'modelAndView'
	 * @param HttpServletRequest object 'request'
	 * @return ModelAndview object 'modelAndView'
	 */
	@GetMapping("hello6")
	public ModelAndView sayHello6(ModelAndView modelAndView,HttpServletRequest request)
	{
		modelAndView.addObject("mykey","welcome to spring from SayHello6....");
		modelAndView.setViewName("Welcome1");
		HttpSession session = request.getSession();
		request.setAttribute("hello", "Hello World from request 6 Object");
		session.setAttribute("hello2", "Hello from session object");
		return modelAndView;
	}
	
	
	
	
	/**
	 * Displays mykey, hello and hello2 values on the URL path "repeat" and uses viewName "Welcome1"."hello" attribute value is set from request 7 object
	 * @param ModelAndview object 'modelAndView'
	 * @param HttpServletRequest object 'request'
	 * @return ModelAndview object 'modelAndView'
	 */
	@GetMapping("repeat")
	public ModelAndView sayHello7(ModelAndView modelAndView,HttpServletRequest request)
	{
		modelAndView.addObject("mykey","welcome to spring from Repeat....");
		modelAndView.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return modelAndView;
	}
	
	
	
	
	/**
	 * Displays mykey, hello and hello2 values on the URL path "hello7" and uses viewName "Welcome1"."mykey" value is set from the pathVariable provided by the user."hello" attribute value is set from request 7 object
	 * @param  String 'name'
	 * @param ModelAndview object 'modelAndView'
	 * @param HttpServletRequest object 'request'
	 * @return ModelAndview object 'modelAndView'
	 */
	@GetMapping("hello7/{name}")
	public ModelAndView sayHello8(@PathVariable String name,ModelAndView modelAndView,HttpServletRequest request) {
		modelAndView.addObject("mykey",name);
		modelAndView.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 7 Object");
		return modelAndView;
	}
	
	

	
	/**
	 * Displays mykey, hello and hello2 values on the URL path "hello7" and uses viewName "Welcome1"."mykey" value is set from the RequestParam provided by the user."hello" attribute value is set from request 8 object
	 * @param  String name
	 * @param ModelAndview object 'modelAndView'
	 * @param HttpServletRequest object 'request'
	 * @return ModelAndview object 'modelAndView'
	 */
	@GetMapping("hello8")
	public ModelAndView sayHello9(@RequestParam("uname") String name,ModelAndView modelAndView,HttpServletRequest request) {
		modelAndView.addObject("mykey",name);
		modelAndView.setViewName("Welcome1");
		request.setAttribute("hello", "Hello World from request 8 Object");
		return modelAndView;
	}
	
	
	
	
	/**
	 * Updates user data when the URL path hello9 is requested
	 * @return ResponseEntity with status ok and status message
	 */
	@GetMapping("hello9")
	public ResponseEntity<User> sayHello11()
	{
		User user= new User();
		getUserService().updateUser(user,100,"Hari");
		return ResponseEntity.ok(user);
	}
	
	
	
	
	/**
	 * Uses @RequestBody which converts HttpRequest body onto a Java object and updates user values
	 * @param User object 'user'
	 * @return  ResponseEntity with status ok and status message
	 */
	@PostMapping("hello10")
	public ResponseEntity<User> sayHello12(@RequestBody User user)
	{
		getUserService().updateUser(user,1000000,"Hariharan");
		return ResponseEntity.ok(user);
	}
	
	
	
	/**
	 * Uses @RequestBody to map request data to request handler method and return a JSON response
	 * @param User object 'user'
	 * @return User object 'user'
	 */
	@PostMapping("hello11")
	public User sayHello13(@RequestBody User user)
	{
		getUserService().updateUser(user,500,"Hariharan S");
		return user;
	}
}
