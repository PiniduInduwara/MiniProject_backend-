package com.MIniProject.repository;


import com.MIniProject.model.Assignment;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositoryTest {

    @Autowired
    private MiniProjectRepository miniProjectRepository;

    @Autowired
    MongoTemplate mongoTemplate;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void addAssignmentTest(){

        Assignment assignment = Assignment.builder()
                .id("QA4327")
                .asgTitle("Quality Assurance")
                .instrName("Perera")
                .stdName("kasun")
                .status("finished")
                .build();

        miniProjectRepository.save(assignment);

        assertThat(assignment.getId());

    }

    @Test
    @Order(2)
    public void getAssignmentTest(){

        Assignment assignment = miniProjectRepository.findById("QA4327").get();

        assertThat(assignment.getId()).isEqualTo("QA4327");

    }
}
