package com.recipe.ben.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.recipe.ben.dao.DAOcategory;
import com.recipe.ben.dao.DAOrecipe;
import com.recipe.ben.dao.DAOuser;
import com.recipe.ben.entity.Category;
import com.recipe.ben.entity.Recipe;
import com.recipe.ben.entity.User;

@Controller
public class RecipeDisplayController {
	
	@Autowired
	private DAOrecipe DAOrecipe;

	@Autowired
	private DAOuser DAOuser;

	@Autowired
	private DAOcategory DAOcategory;

	@RequestMapping(value = "/categoryDisplay", method = RequestMethod.GET)
	public ModelAndView search1() {
		ModelAndView response = new ModelAndView();
		response.setViewName("recipe/categoryDisplayAll");
		List<Category> categories = new ArrayList<Category>();

		categories = DAOcategory.findAll();
		categories.forEach(
				(n)->System.out.println(n.toString())
		);
		response.addObject("categories", categories);
		response.addObject("search", "yes");
		return response;
	}

	@RequestMapping(value = "/recipeDisplay/{id}", method = RequestMethod.GET)
    public ModelAndView Controller(@PathVariable("id") String id) {		
		ModelAndView response = new ModelAndView();
		response.setViewName("recipe/recipeDisplay");
		
		Recipe recipe = DAOrecipe.findById(Integer.parseInt(id));
		response.addObject("recipe", recipe);

		return response;
    }


	@Transactional
	@RequestMapping(value = "/deleteRecipe", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(required = false) int id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("recipe/recipeDisplayAll");

		DAOrecipe.removeRecipeById(id);

		User user = DAOuser.findByEmail(getUserEmail());
		System.out.println( + user.getRecipes().size());
		Set<Recipe> recipes = user.getRecipes();

		response.addObject("recipe", recipes);
		response.addObject("user", user);
		return response;
	}

	@RequestMapping(value = "/recipesDisplayAll")
	public ModelAndView recipesDisplayAll() {
		ModelAndView response = new ModelAndView();
		response.setViewName("recipe/recipeDisplayAll");


		User user = DAOuser.findByEmail(getUserEmail());
		System.out.println( + user.getRecipes().size());
		Set<Recipe> recipes = user.getRecipes();

		response.addObject("recipe", recipes);
		response.addObject("user", user);

		return response;
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
