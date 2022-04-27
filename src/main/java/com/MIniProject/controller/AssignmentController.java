package com.MIniProject.controller;

import com.MIniProject.create.AssignmentCreate;
import com.MIniProject.model.Assignment;
import com.MIniProject.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    public Assignment addAssignment(@RequestBody AssignmentCreate assignmentCreate){
        return assignmentService.addAssignment(assignmentCreate);
    }
}
