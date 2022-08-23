package com.recipe.ben.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipe.ben.entity.Recipe;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface DAOrecipe extends JpaRepository<Recipe, Long> {

	public Recipe findById(@Param("id") Integer id);

	@Override
	List<Recipe> findAll();

	@Query(value = "select * from recipe.recipe_details r where lower(r.recp_name) like lower(concat('%', :recp_name,'%'))", nativeQuery = true)
    public List<Recipe> findByDescription(@Param("recp_name")String recipe);
	
	
	
	public void removeRecipeById(int id);

}
