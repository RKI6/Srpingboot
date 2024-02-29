package day_5_2.ex_2.model;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    @Id
    private int employeeld;
    @Value("sam")
private String employeeName ;
private String employeeEmail ;
private double salary  ;
private int  department;
public Employee(int employeeld, String employeeName, String employeeEmail, double salary, int department) {
    this.employeeld = employeeld;
    this.employeeName = employeeName;
    this.employeeEmail = employeeEmail;
    this.salary = salary;
    this.department = department;
}
public Employee() {
}
public int getEmployeeld() {
    return employeeld;
}
public void setEmployeeld(int employeeld) {
    this.employeeld = employeeld;
}
public String getEmployeeName() {
    return employeeName;
}
public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
}
public String getEmployeeEmail() {
    return employeeEmail;
}
public void setEmployeeEmail(String employeeEmail) {
    this.employeeEmail = employeeEmail;
}
public double getSalary() {
    return salary;
}
public void setSalary(double salary) {
    this.salary = salary;
}
public int getDepartment() {
    return department;
}
public void setDepartment(int department) {
    this.department = department;
}

}
