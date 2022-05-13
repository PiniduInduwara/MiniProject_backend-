package com.MIniProject.controller;

import com.MIniProject.model.Assignment;
import com.MIniProject.service.AssignmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AssignmentController.class)
public class AssignmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssignmentService assignmentService;

    @Test
    public void getAssignmentsByIdTest() throws Exception {
        Assignment assignment = new Assignment();
        assignment.setId("AF4561");
        assignment.setAsgTitle("Application Framework");
        assignment.setInstrName("Perera");
        assignment.setStdName("Mahinda");
        assignment.setStatus("half");

        Mockito.when(assignmentService.getAssignmentsById(Mockito.anyString())).thenReturn(assignment);

        String URI = "/assignment/{assignmentId}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String exceptedJson = this.mapToJson(assignment);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(exceptedJson);


    }

    @Test
    public void getAllAssignmentsTest() throws Exception {

        Assignment assignment1 = new Assignment();
        assignment1.setId("AF4561");
        assignment1.setAsgTitle("Application Framework");
        assignment1.setInstrName("Perera");
        assignment1.setStdName("Mahinda");
        assignment1.setStatus("half");

        Assignment assignment2 = new Assignment();
        assignment2.setId("DM5432");
        assignment2.setAsgTitle("Database Management");
        assignment2.setInstrName("Nandasena");
        assignment2.setStdName("Ranil");
        assignment2.setStatus("finished");

        List<Assignment> assignmentList = new ArrayList<>();
        assignmentList.add(assignment1);
        assignmentList.add(assignment2);

        Mockito.when(assignmentService.getAllAssignments()).thenReturn(assignmentList);

        String URI = "/assignment";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(assignmentList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }


    @Test
    public void addAssignmentTest() throws Exception{

        Assignment assignment = new Assignment();
        assignment.setId("AF4561");
        assignment.setAsgTitle("Application Framework");
        assignment.setInstrName("Perera");
        assignment.setStdName("Mahinda");
        assignment.setStatus("half");

        String inputInJson = this.mapToJson(assignment);

        String URI = "/assignment";

        Mockito.when(assignmentService.addAssignment(Mockito.any(Assignment.class))).thenReturn(assignment);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJason = response.getContentAsString();

        assertThat(outputInJason).isEqualTo(inputInJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }



   /*
      Maps an object into a JSON String. Uses a Jackson ObjectMapper
   */

    private String mapToJson(Object object) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }


}
