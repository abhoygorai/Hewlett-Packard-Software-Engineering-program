package com.example.hp.employee;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {
    private static Employees employees = new Employees();

//    static {
//        Employee employee1 = new Employee("1", "First1", "Last1", "Email1", "Title1");
//        Employee employee2 = new Employee("2", "First2", "Last2", "Email2", "Title2");
//        Employee employee3 = new Employee("3", "First3", "Last3", "Email3", "Title3");
//
//        employees.getEmployeeList().add(employee1);
//        employees.getEmployeeList().add(employee2);
//        employees.getEmployeeList().add(employee3);
//    }

    public Employees getAllEmployees(){
        return employees;
    }

    public void addEmployee(Employee employee){
        employees.addEmployeeInList(employee);
    }
}
