package com.recipe.ben.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipe.ben.entity.Measurements;

@Repository
public interface DAOmeasurements extends JpaRepository<Measurements, Long>{
	
	public Measurements findById(@Param("id") Integer id);

}