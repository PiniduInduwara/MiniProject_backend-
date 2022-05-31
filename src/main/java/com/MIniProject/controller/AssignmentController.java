package com.MIniProject.controller;

import com.MIniProject.create.AssignmentCreate;
import com.MIniProject.exception.ApiRequestException;
import com.MIniProject.model.Assignment;
import com.MIniProject.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @GetMapping("/assignment")
    public List<Assignment> getAllAssignments(){
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/assignment/{assignmentId}")
    public Assignment getAssignmentsById(@Valid @PathVariable("assignmentId") String id){
        return assignmentService.getAssignmentsById(id);
    }

    @PostMapping("/assignment")
    public Assignment addAssignment(@Valid @RequestBody Assignment assignment){
        return assignmentService.addAssignment(assignment);
    }

    @PutMapping("/status/{assignmentId}")
    public Assignment changeStatus(@Valid @PathVariable("assignmentId") String id, @RequestBody Assignment assignment){
        return assignmentService.changeStatus(assignment, id);
    }

    @PutMapping("/assignment/{assignmentId}")
    public Assignment changeAssignment(@Valid @PathVariable("assignmentId")String id, @RequestBody Assignment assignment){
        return assignmentService.changeAssignment(assignment, id);
    }

    @DeleteMapping("/assignment/{assignmentId}")
    public Assignment deleteAssignment(@Valid @PathVariable("assignmentId") String id){
        return assignmentService.deleteAssignment(id);
    }
}
