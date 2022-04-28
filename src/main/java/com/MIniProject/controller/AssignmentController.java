package com.MIniProject.controller;

import com.MIniProject.create.AssignmentCreate;
import com.MIniProject.model.Assignment;
import com.MIniProject.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @PostMapping("/")
    public Assignment addAssignment(@RequestBody AssignmentCreate assignmentCreate){
        return assignmentService.addAssignment(assignmentCreate);
    }

    @PutMapping("/assignment/{assignmentId}")
    public Assignment changeStatus(@PathVariable("assignmentId") String id, @RequestBody Assignment assignment){
        return assignmentService.changeStatus(assignment, id);
    }

    @DeleteMapping("/assignment/{assignmentId}")
    public Assignment deleteAssignment(@PathVariable("assignmentId") String id){
        return assignmentService.deleteAssignment(id);
    }
}
