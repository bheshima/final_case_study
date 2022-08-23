package com.recipe.ben;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.recipe.ben.dao.DAOingredient;
import com.recipe.ben.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public class DAOingredientTests {

    @Test
    void contextLoads() {

        DAOingredient daOingredient = new DAOingredient() {
            @Override
            public Ingredient findById(Integer id) {
                return null;
            }

            @Override
            public List<Ingredient> findAll() {
                return null;
            }

            @Override
            public List<Ingredient> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Ingredient> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Ingredient> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Ingredient> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Ingredient> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Ingredient> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Ingredient getOne(Long aLong) {
                return null;
            }

            @Override
            public Ingredient getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Ingredient> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Ingredient> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Ingredient> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Ingredient> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Ingredient> findById(Long aLong) {
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
            public void delete(Ingredient entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Ingredient> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Ingredient> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Ingredient> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Ingredient> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Ingredient> boolean exists(Example<S> example) {
                return false;
            }
        };
    }
}
