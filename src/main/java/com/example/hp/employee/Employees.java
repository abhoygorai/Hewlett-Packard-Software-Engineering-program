package com.example.hp.employee;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    List<Employee>  employeeList;

    public List<Employee> getEmployeeList(){
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }

        return this.employeeList;
    }

    public void setEmployeeList(List<Employee> list){
        this.employeeList = list;
    }

    public void addEmployeeInList(Employee e){
        this.employeeList.add(e);
    }
}