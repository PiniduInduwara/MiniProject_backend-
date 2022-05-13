package com.MIniProject.service;

import com.MIniProject.create.AssignmentCreate;
import com.MIniProject.model.Assignment;
import com.MIniProject.repository.MiniProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AssignmentServiceTest {

    private AssignmentService assignmentService;
    private Assignment assignment;

    @Mock
    private MiniProjectRepository miniProjectRepository;


    @BeforeEach
    void setUp(){
        assignmentService = new AssignmentService(miniProjectRepository);

        assignment = new Assignment();
        assignment.setId("test_Id");
        assignment.setAsgTitle("test_title");
        assignment.setInstrName("test_Iname");
        assignment.setStdName("test_Sname");
        assignment.setStatus("test_status");
    }

    @Test
    void addAssignmentTest(){
        assignment = new Assignment();
        assignment.setId("AF4561");
        assignment.setAsgTitle("Application Framework");
        assignment.setInstrName("Perera");
        assignment.setStdName("Mahinda");
        assignment.setStatus("half");

        doReturn(assignment).when(miniProjectRepository).save(any(Assignment.class));
        assertEquals(assignment, assignmentService.addAssignment(assignment));
    }

    @Test
    void getAssignmentsByIdTest(){
       doReturn(Optional.of(assignment)).when(miniProjectRepository).findById("Test_Id");
       assertEquals(assignment, assignmentService.getAssignmentsById("Test_Id"));
    }

    @Test
    void getAllAssignmentTest(){
        doReturn(Arrays.asList(assignment)).when(miniProjectRepository).findAll();
        assertEquals(Arrays.asList(assignment), assignmentService.getAllAssignments());
    }

    @Test
    void changeAssignmentWhenPresentTest(){
        assignment = new Assignment();
        assignment.setId("AF4561");
        assignment.setAsgTitle("Application Framework");
        assignment.setInstrName("Perera");
        assignment.setStdName("Mahinda");
        assignment.setStatus("half");

        doReturn(assignment).when(miniProjectRepository).save(any(Assignment.class));
        assertEquals(assignment, assignmentService.addAssignment(assignment));

        doReturn(Optional.ofNullable(assignment)).when(miniProjectRepository).findById("Test_Id");
        assertEquals(assignment, assignmentService.changeAssignment(assignment, "Test_Id"));
    }

    @Test
    void changeAssignmentWhenNotPresentTest(){
        assignment = new Assignment();
        assignment.setId("AF4561");
        assignment.setAsgTitle("Application Framework");
        assignment.setInstrName("Perera");
        assignment.setStdName("Mahinda");
        assignment.setStatus("half");

        doReturn(Optional.ofNullable(null)).when(miniProjectRepository).findById("Test_Id");
        assertEquals(null, assignmentService.changeAssignment(assignment, "Test_Id"));
    }



    @Test
    void changeStatusWhenPresentTest(){
        assignment = new Assignment();
        assignment.setStatus("half");

        doReturn(assignment).when(miniProjectRepository).save(any(Assignment.class));
        doReturn(Optional.ofNullable(assignment)).when(miniProjectRepository).findById("Test_Id");
        assertEquals(assignment, assignmentService.changeStatus(assignment, "Test_Id"));
    }

    @Test
    void changeStatusWhenNoTPresentTest(){
        assignment = new Assignment();
        assignment.setStatus("half");

        doReturn(Optional.ofNullable(null)).when(miniProjectRepository).findById("Test_Id");
        assertEquals(null, assignmentService.changeStatus(assignment, "Test_Id"));
    }

//    @Test
//    void deleteAssignmentTest(){
//        doReturn(Optional.ofNullable(null)).when(miniProjectRepository).findById(any(String.class));
//        assertEquals(null, assignmentService.deleteAssignment("Test_Id"));
//    }

    @Test
    public void deleteTest(){
        assignment = new Assignment();
        assignment.setId("AF4561");
        assignment.setAsgTitle("Application Framework");
        assignment.setInstrName("Perera");
        assignment.setStdName("Mahinda");
        assignment.setStatus("half");

        assignmentService.deleteAssignment(assignment.getId());
        verify(miniProjectRepository, times(1)).deleteById(assignment.getId());


    }

}
