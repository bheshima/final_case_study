package com.recipe.ben.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipe.ben.entity.Ingredient;


@Repository
public interface DAOingredient extends JpaRepository<Ingredient, Long> {

	public Ingredient findById(@Param("id") Integer id);

}
