package com.ksk.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtil {

    public static List<Employee> getData(){

        List<Employee> employeeList = new ArrayList<>();
        Employee employe1 =new Employee("Tom",12345,50000);
        Employee employe2 =new Employee("Scot",12346,60000);
        Employee employe3 =new Employee("John",12347,70000);
        Employee employe4 =new Employee("Alex",12348,80000);
        employeeList.add(employe1);
        employeeList.add(employe2);
        employeeList.add(employe3);
        employeeList.add(employe4);
        return employeeList;
    }

    public static Map<Employee,Integer> getDataMap(){

        Map<Employee,Integer> employeeList = new HashMap<>();
        Employee employe1 =new Employee("Tom",12345,50000);
        Employee employe2 =new Employee("Scot",12346,60000);
        Employee employe3 =new Employee("John",12347,70000);
        Employee employe4 =new Employee("Alex",12348,80000);
        employeeList.put(employe1,20);
        employeeList.put(employe2,30);
        employeeList.put(employe3,40);
        employeeList.put(employe4,50);
        return employeeList;
    }
}
