package com.MIniProject.service;

import com.MIniProject.exception.ApiRequestException;
import com.MIniProject.model.Assignment;
import com.MIniProject.repository.MiniProjectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return miniProjectRepository.save(assignment);
    }

    public Assignment changeAssignment(Assignment assignment, String id){

        assignment.setAsgTitle(assignment.getAsgTitle());
        assignment.setInstrName(assignment.getInstrName());
        assignment.setStdName(assignment.getStdName());

        Optional<Assignment> currentAssignment = miniProjectRepository.findById(id);

        if(currentAssignment.isPresent()){
            Assignment updateAssignment = currentAssignment.get();
            if(assignment.getAsgTitle() !=null ){
                updateAssignment.setAsgTitle(assignment.getAsgTitle());
            }
            if(assignment.getInstrName() !=null){
                updateAssignment.setInstrName(assignment.getInstrName());
            }
            if(assignment.getStdName() !=null){
                updateAssignment.setStdName(assignment.getStdName());
            }

//            if(assignment.getAsgTitle() !=null || assignment.getInstrName() !=null || assignment.getStdName() !=null)
//            {
//                updateAssignment.setAsgTitle(assignment.getAsgTitle());
//                updateAssignment.setInstrName(assignment.getInstrName());
//                updateAssignment.setStdName(assignment.getStdName());
//            }
            return miniProjectRepository.save(updateAssignment);

        }else {
            throw new ApiRequestException("Assignment Cannot Found");
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
