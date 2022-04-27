package com.MIniProject.service;

import com.MIniProject.model.Assignment;
import com.MIniProject.repository.MiniProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    MiniProjectRepository miniProjectRepository;

    public List<Assignment> getAllAssignments(){
        List<Assignment> assignments = new ArrayList<Assignment>();
        miniProjectRepository.findAll().forEach(assigments1 -> assignments.add(assigments1));
        return assignments;
    }

    public Assignment getAssignmentsById{
        return miniProjectRepository.findById().get();
    }

    public Assignment addAssignment(){


    }
}
