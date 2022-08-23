package com.recipe.ben.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.recipe.ben.dao.DAOcategory;
import com.recipe.ben.dao.DAOingredient;
import com.recipe.ben.dao.DAOmeasurements;
import com.recipe.ben.dao.DAOrecipe;
import com.recipe.ben.dao.DAOuser;
import com.recipe.ben.entity.Category;
import com.recipe.ben.entity.Difficulty;
import com.recipe.ben.entity.Ingredient;
import com.recipe.ben.entity.Measurements;
import com.recipe.ben.entity.Recipe;
import com.recipe.ben.entity.User;
import com.recipe.ben.form.CreateRecipeForm;


@Controller
public class CreateRecipeController {
	//@Autowired
	//private S3 s3;
	
	@Autowired
	private DAOuser DAOuser;
	
	@Autowired
	private DAOrecipe DAOrecipe;
	
	@Autowired
	private DAOingredient DAOingredient;
	
	@Autowired
	private DAOmeasurements DAOmeasurements;
	
	@Autowired
	private DAOcategory DAOcategory;
	
	
	@RequestMapping(value = "/createRecipe", method = RequestMethod.GET)
    public ModelAndView createRecipePage() {
        ModelAndView result = new ModelAndView("recipe/createRecipe");
        result.addObject("form", new CreateRecipeForm());
        result.addObject("difficulty", Difficulty.values());
        return result;
    }

	@RequestMapping(value = "/createRecipe", method = RequestMethod.POST)
	public ModelAndView createRecipeSumit( @Valid CreateRecipeForm form, BindingResult bindingResult) throws Exception {
		ModelAndView result = new ModelAndView("login/userPortal");

	
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
			
			return result;
		} 
		
		
		User user = new User();
		Recipe recipe = new Recipe();
		Ingredient ingredient = new Ingredient();
		Measurements measurements = new Measurements();
		Category category = new Category();
		
		
		//user.setEmail(form.getEmail());
		recipe.setRecipeDescription(form.getRecipeDescription());
		recipe.setPrepTime(form.getPrepTime());
		recipe.setCookTime(form.getCookTime());
		recipe.setServings(form.getServings());
		recipe.setDirections(form.getDirections());
		recipe.setDifficulty(form.getDifficulty());
		
		
		ingredient.setIngredientDescription(form.getIngredientDescription());
		ingredient.setAmount(form.getAmount());
		ingredient.setRecipe(recipe);
		//ingredient.setUom(uom);
		
		measurements.setMeasureDescription(form.getMeasureDescription());
		
		category.setDescription(form.getDescription());
		Set<Category> categories = new HashSet<Category>();
		categories.add(category);
		recipe.setCategories(categories);
		
		Set<Ingredient> ingredients = new HashSet<Ingredient>();
		ingredients.add(ingredient);
		recipe.setIngredient(ingredients);
		
		DAOrecipe.save(recipe);
		DAOingredient.save(ingredient);
		DAOmeasurements.save(measurements);
		DAOcategory.save(category);
		user = DAOuser.findByEmail(getUserEmail());
		user.getRecipes().add(recipe);
		DAOuser.save(user);

		// goto the next page

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
