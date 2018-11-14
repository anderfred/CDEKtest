package com.anderfred.cdekTest.service;

import com.anderfred.cdekTest.entity.Entity;

import java.sql.SQLException;
import java.util.Optional;

public interface TestDataService {

    Iterable<Entity> findAll();

    <S extends Entity> S save(S s);

    void deleteById(Integer integer);

    Optional<Entity> findById(Integer integer);

    void populateDB() throws SQLException;
}
