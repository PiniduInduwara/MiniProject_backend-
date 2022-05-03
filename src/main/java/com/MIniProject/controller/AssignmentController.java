package com.MIniProject.controller;

import com.MIniProject.create.AssignmentCreate;
import com.MIniProject.model.Assignment;
import com.MIniProject.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @GetMapping("/assignment")
    public List<Assignment> getAllAssignments(){
        return assignmentService.getAllAssignments();
    }

    @PostMapping("/assignment/{assignmentId}")
    public Assignment getAssignmentsById(@PathVariable("/assignemnt/{assignmentId}") String id){
        return assignmentService.getAssignmentsById(id);
    }

    @PostMapping("/assignment")
    public Assignment addAssignment(@RequestBody Assignment assignment){
        return assignmentService.addAssignment(assignment);
    }

    @PutMapping("/status/{assignmentId}")
    public Assignment changeStatus(@PathVariable("assignmentId") String id, @RequestBody Assignment assignment){
        return assignmentService.changeStatus(assignment, id);
    }

    @PutMapping("/assignment/{assignmentId}")
    public Assignment changeAssignment(@PathVariable("assignmentId")String id, @RequestBody AssignmentCreate assignmentCreate){
        return assignmentService.changeAssignment(assignmentCreate, id);
    }

    @DeleteMapping("/assignment/{assignmentId}")
    public Assignment deleteAssignment(@PathVariable("assignmentId") String id){
        return assignmentService.deleteAssignment(id);
    }
}
