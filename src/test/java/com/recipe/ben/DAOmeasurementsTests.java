package com.recipe.ben;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.recipe.ben.dao.DAOmeasurements;
import com.recipe.ben.entity.Measurements;

import java.util.List;
import java.util.Optional;

public class DAOmeasurementsTests {

    @Test
    void contextLoads() {

        DAOmeasurements daOmeasurements = new DAOmeasurements() {
            @Override
            public Measurements findById(Integer id) {
                return null;
            }

            @Override
            public List<Measurements> findAll() {
                return null;
            }

            @Override
            public List<Measurements> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Measurements> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Measurements> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Measurements> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Measurements> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Measurements> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Measurements getOne(Long aLong) {
                return null;
            }

            @Override
            public Measurements getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Measurements> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Measurements> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Measurements> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Measurements> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Measurements> findById(Long aLong) {
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
            public void delete(Measurements entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Measurements> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Measurements> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Measurements> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Measurements> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Measurements> boolean exists(Example<S> example) {
                return false;
            }
        };

    }
}
