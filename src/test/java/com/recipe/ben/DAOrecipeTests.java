package com.recipe.ben;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.recipe.ben.dao.DAOrecipe;
import com.recipe.ben.entity.Recipe;

import java.util.List;
import java.util.Optional;

public class DAOrecipeTests {

    @Test
    void contextLoads() {

        DAOrecipe daOrecipe = new DAOrecipe() {
            @Override
            public Recipe findById(Integer id) {
                return null;
            }

            @Override
            public List<Recipe> findAll() {
                return null;
            }

            @Override
            public List<Recipe> findByDescription(String recipe) {
                return null;
            }

            @Override
            public void removeRecipeById(int id) {

            }

            @Override
            public List<Recipe> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Recipe> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Recipe> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Recipe> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Recipe> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Recipe> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Recipe getOne(Long aLong) {
                return null;
            }

            @Override
            public Recipe getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Recipe> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Recipe> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Recipe> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Recipe> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Recipe> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Recipe entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Recipe> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Recipe> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Recipe> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Recipe> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Recipe> boolean exists(Example<S> example) {
                return false;
            }
        };
    }
}
