package com.MIniProject.service;

import com.MIniProject.create.AssignmentCreate;
import com.MIniProject.model.Assignment;
import com.MIniProject.repository.MiniProjectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentService {

    @Autowired
    MiniProjectRepository miniProjectRepository;

    public List<Assignment> getAllAssignments(){
        List<Assignment> assignments = new ArrayList<Assignment>();
        miniProjectRepository.findAll().forEach(assigments1 -> assignments.add(assigments1));
        return assignments;
    }

    public Assignment getAssignmentsById(String id){
        return miniProjectRepository.findById(id).get();
    }

    public Assignment addAssignment(AssignmentCreate assignmentCreate){
        Assignment newassignment = new Assignment();
        newassignment.setId(assignmentCreate.getcId());
        newassignment.setAsgTitle(assignmentCreate.getcAsgTitle());
        newassignment.setInstrName(assignmentCreate.getcInstrName());
        newassignment.setStdName(assignmentCreate.getcStdName());
        newassignment.setStatus(assignmentCreate.getcStatus());
        newassignment.setDeadline(assignmentCreate.getcDeadline());
        newassignment.setAsgUploadedAt(assignmentCreate.getcAsgUploadedAt());
        newassignment.setLastUpdatedAt(assignmentCreate.getcLastUpdatedAt());

        return miniProjectRepository.save(newassignment);

    }


}
