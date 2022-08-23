package com.recipe.ben.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.recipe.ben.dao.DAOuser;
import com.recipe.ben.entity.User;
import com.recipe.ben.form.CreateUserForm;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequestMapping("/")
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DAOuser DAOuser;
	
	public LoginController() {
		System.out.println("PostConstruct Reference to UserDAO = " + DAOuser);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("PostConstruct Reference to UserDAO = " + DAOuser);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public ModelAndView createUserPage() {
		logger.info("Enter: createUserPage()");
		ModelAndView result = new ModelAndView("login/createUser");
		result.addObject("form", new CreateUserForm());
		
		logger.info("Exit: createUserPage()");
		return result;
	}

	//@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST, value = "/createUser")
	
	
	public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) throws Exception {
		logger.info("Enter: createUserSubmit()");
		ModelAndView result = new ModelAndView("login/createUser");

		// form validation
		result.addObject("form", form);

		System.out.println(form);

		if (bindingResult.hasErrors()) {

			List<String> errors = new ArrayList<String>();

			for (FieldError error : bindingResult.getFieldErrors()) {
				System.out.println(error.getField() + " = " + error.getDefaultMessage());
				errors.add(error.getDefaultMessage());
			}

			result.addObject("errorFields", bindingResult.getFieldErrors());
			result.addObject("errors", errors);
			logger.trace("createUserSubmit() - ERROR: Binding Errors");
			return result;
		}

		// business logic
		User user = new User();

		//User existingUser = userDao.findById(1).get();
		//userDao.delete(user);
		Optional<User> optionalUser = Optional.ofNullable(DAOuser.findByEmail(form.getEmail()));
		User tempUser = null;
		if (optionalUser.isPresent()) {
			result.addObject("errorFields", bindingResult.getFieldErrors());
			result.addObject("errors", "EMAIL ALREADY IN USE");

			logger.trace("createUserSubmit() - ERROR: Email Already In Use");
			return result;
		}


		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		user.setFullName(form.getFullName());

		DAOuser.save(user);

		// goto the next page
		logger.info("Exit: createUserSubmit()");
		return result;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		logger.info("Enter: login()");
		ModelAndView result = new ModelAndView("login/login");
		
		logger.info("Exit: login()");
		return result;
	}
	
	@RequestMapping(value = "/login/login")
	public ModelAndView login2() {
		logger.info("Enter: login2()");
		ModelAndView result = new ModelAndView("login/login");

		if(!checkTargetServer("/login/login")){
			result.addObject("Error", "Error");
		}


		logger.info("Exit: login2()");
		return result;
	}

	private boolean checkTargetServer(String url) {
		System.out.println("In checkTargetServer");

		boolean ret = false;
		if (url == null) {

			return false;
		}

		HttpURLConnection conn = null;

		try {

			conn = (HttpURLConnection) (new URL(url)).openConnection();

			conn.setRequestMethod("HEAD");

			System.out.println("response code = " + conn.getResponseCode());
			if (conn.getResponseCode() == 200) {
				ret = true;
			}

		} catch (Exception e) {
			return ret;
		} finally {
			if (conn != null) {
				try { conn.disconnect(); } catch (Exception e) { }
			}
		}

		System.out.println("Leaving checkTargetServer");
		return ret;
	}

 //
}
