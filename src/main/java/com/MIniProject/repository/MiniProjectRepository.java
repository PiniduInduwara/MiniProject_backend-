package com.MIniProject.repository;

import com.MIniProject.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniProjectRepository extends MongoRepository<Assignment, String> {
}
