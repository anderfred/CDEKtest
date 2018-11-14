package com.anderfred.cdekTest.service;

import com.anderfred.cdekTest.entity.Entity;
import com.anderfred.cdekTest.repository.TestDataRepostitory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;


import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class TestDataServiceImpl implements TestDataService {
    private TestDataRepostitory testDataRepostitory;
    final DataSource datasource;
    Logger logger = LoggerFactory.getLogger(TestDataServiceImpl.class);

    @Autowired
    public TestDataServiceImpl(TestDataRepostitory testDataRepostitory, DataSource datasource) {
        this.testDataRepostitory = testDataRepostitory;
        this.datasource = datasource;
    }

    @Override
    public Iterable<Entity> findAll() {
        logger.info("all data: {}", testDataRepostitory.findAll());
        return testDataRepostitory.findAll();
    }

    @Override
    public <S extends Entity> S save(S s) {
        logger.info("save {}",s);
        return testDataRepostitory.save(s);
    }

    @Override
    public void deleteById(Integer integer) {
        logger.info("delete:{}",integer);
        testDataRepostitory.deleteById(integer);
    }

    @Override
    public Optional<Entity> findById(Integer integer) {
        logger.info("findById:{}",integer);
        return testDataRepostitory.findById(integer);
    }

    @Override
    public void populateDB() throws SQLException {
        final Connection connection = datasource.getConnection();
        try {
            ScriptUtils.executeSqlScript(connection, new EncodedResource(new ClassPathResource("schema.sql"), StandardCharsets.UTF_8));
            ScriptUtils.executeSqlScript(connection, new EncodedResource(new ClassPathResource("data.sql"), StandardCharsets.UTF_8));
        } finally {
            connection.close();
        }
    }
}
