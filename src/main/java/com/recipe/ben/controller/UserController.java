package com.recipe.ben.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recipe.ben.dao.DAOuser;
import com.recipe.ben.entity.Recipe;
import com.recipe.ben.entity.User;

@Controller
public class UserController {

	@Autowired
	private DAOuser DAOuser;
	
	
//	@RequestMapping(value = "/login/userPortal", method = RequestMethod.GET)
//	public ModelAndView userPortal1() {
//		ModelAndView response = new ModelAndView();
//		response.setViewName("/login/userPortal");
//		return response;
//	}
	@RequestMapping(value = "/login/userPortal")
	public ModelAndView userPortal() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login/userPortal");

		User user = DAOuser.findByEmail(getUserEmail());
		System.out.println( + user.getRecipes().size());
		Set<Recipe> recipes = user.getRecipes();

		response.addObject("recipe", recipes);
		response.addObject("user", user);

		return response;
	}




	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView result = new ModelAndView("redirect:/home");
		return result;
	}
	
	public String getUserEmail() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails)principal).getUsername();
			return username;
		} else {
			String username = principal.toString();
			return "";
		}
	}
}
