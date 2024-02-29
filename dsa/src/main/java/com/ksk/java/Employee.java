package com.ksk.java;


public class Employee {

    private String name;
    private int empId;
    private long salary;

    public Employee(String name, int empId, long salary) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", empId=" + empId +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
