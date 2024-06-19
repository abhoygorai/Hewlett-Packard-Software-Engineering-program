package com.example.hp;

import com.example.hp.employee.Employee;
import com.example.hp.employee.EmployeeManager;
import com.example.hp.employee.Employees;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

@WebMvcTest
public class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    EmployeeManager manager;

    Employee employee1 = new Employee("1", "First1", "Last1", "Email1", "Title1");
    Employee employee2 = new Employee("2", "First2", "Last2", "Email2", "Title2");
    Employee employee3 = new Employee("3", "First3", "Last3", "Email3", "Title3");


    @Test
    public void getAllRecords_success() throws Exception{
        Employees records = new Employees();
        records.setEmployeeList(List.of(employee1, employee2, employee3));
        Mockito.when(manager.getAllEmployees()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeList", hasSize(3)))
                .andExpect(jsonPath("$.employeeList[2].first_name", is("First3")));
    }

    @Test
    public void createEmployee_success() throws Exception {
        Employee newEmployee = new Employee("4", "NewFirst", "NewLast", "new.email@example.com", "NewTitle");

        // Mock the saveEmployee method to return the new employee when called
        Mockito.doNothing().when(manager).addEmployee(Mockito.any(Employee.class));

        // Create a MockHttpServletRequestBuilder for the POST request
        String employeeJson = mapper.writeValueAsString(newEmployee);
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isOk());

    }

}
