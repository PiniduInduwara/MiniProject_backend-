package com.MIniProject.service;

import com.MIniProject.create.AssignmentCreate;
import com.MIniProject.model.Assignment;
import com.MIniProject.repository.MiniProjectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
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

    public Assignment addAssignment(Assignment assignment){
//        Assignment newassignment = new Assignment();
//
//        newassignment.setId(assignmentCreate.getcId());
//        newassignment.setAsgTitle(assignmentCreate.getcAsgTitle());
//        newassignment.setInstrName(assignmentCreate.getcInstrName());
//        newassignment.setStdName(assignmentCreate.getcStdName());
//        newassignment.setStatus(assignmentCreate.getcStatus());
//        newassignment.setDeadline(assignmentCreate.getcDeadline());
//        newassignment.setAsgUploadedAt(assignmentCreate.getcAsgUploadedAt());
//        newassignment.setLastUpdatedAt(assignmentCreate.getcLastUpdatedAt());

        return miniProjectRepository.save(assignment);
    }

    public Assignment changeAssignment(AssignmentCreate assignmentCreate, String id){
        Assignment newassignment = new Assignment();

        newassignment.setAsgTitle(assignmentCreate.getcAsgTitle());
        newassignment.setInstrName(assignmentCreate.getcInstrName());
        newassignment.setStdName(assignmentCreate.getcStdName());
        newassignment.setDeadline(assignmentCreate.getcDeadline());

        Optional<Assignment> currentAssignment = miniProjectRepository.findById(id);

        if(currentAssignment.isPresent()){
            Assignment updateAssignment = currentAssignment.get();
            updateAssignment.setLastUpdatedAt(new Date());
            if(newassignment.getAsgTitle() !=null){
                updateAssignment.setAsgTitle(newassignment.getAsgTitle());
            }
            if(newassignment.getInstrName() !=null){
                updateAssignment.setInstrName(newassignment.getInstrName());
            }
            if(newassignment.getStdName() !=null){
                updateAssignment.setStdName(newassignment.getStdName());
            }
            if(newassignment.getDeadline() !=null){
                updateAssignment.setDeadline(newassignment.getDeadline());
            }

            return miniProjectRepository.save(updateAssignment);

        }else {
            log.info("Assignment can not found");
            return null;
        }


    }

    public Assignment changeStatus(Assignment asg,  String id){
        Optional<Assignment> assignment = miniProjectRepository.findById(id);
        if(assignment.isPresent()){
            Assignment updatedAssignment = assignment.get();
            updatedAssignment.setStatus(asg.getStatus());
            return miniProjectRepository.save(updatedAssignment);
        }else {
            log.info("Assignment can not found");
            return null;
        }
    }

    public Assignment deleteAssignment(String id){
        miniProjectRepository.deleteById(id);
        return null;
    }




}
