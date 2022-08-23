package com.recipe.ben.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipe.ben.entity.Category;

@Repository
public interface DAOcategory extends JpaRepository<Category, Long>{
	
	public Category findById(@Param("id") Integer id);

}
