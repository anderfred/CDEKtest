package com.anderfred.cdekTest.repository;

import com.anderfred.cdekTest.entity.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDataRepostitory extends CrudRepository<Entity, Integer> {
}
