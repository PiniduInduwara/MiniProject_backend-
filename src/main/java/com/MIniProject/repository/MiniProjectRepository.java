package com.MIniProject.repository;

import com.MIniProject.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MiniProjectRepository extends MongoRepository<Assignment, String> {

    @Query
    Optional<Assignment> findById(String Id);
}
