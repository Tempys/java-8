package lesson1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You have two classes: Employee (name: String, salary: Long) and Department (name: String, code: String, employees: List<Employee>). Both classes have getters for all fields with the corresponding names (getName(), getSalary(), getEmployees() and so on).

 Write a method using Stream API that calculates the general number of employees with salary >= threshold for all departments whose code starts with string "111-" (without ""). Perhaps, flatMap method can help you to implement it.

 Classes Employee and Department will be available during testing. You can define your own classes for local testing.

 Important. Use the given template for your method. Pay attention to type of an argument and the returned value. Please, use only Stream API, no cycles.

 Examples: there are 2 departments (in JSON notation) below and ﻿threshold = 20 000. The result is 1 (because there is only one suitable employee).

 [
 {
 "name": "dep-1",
 "code": "111-1",
 "employees": [
 {
 "name": "William",
 "salary": 20000
 },
 {
 "name": "Sophia",
 "salary": 10000
 }
 ]
 },
 {
 "name": "dep-2",
 "code": "222-1",
 "employees": [
 {
 "name": "John",
 "salary": 50000
 }
 ]
 }
 ]﻿﻿
 */
public class Task23 {
    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold is lower edge of salary
     *
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {

       return departments.stream()
                         .filter(i -> i.getCode().startsWith("111-"))
                         .map(Department::getEmployees)
                         .flatMap(Collection::stream)
                         .filter(i -> i.getSalary() >= 20000)
                         .count();


    }

    public static long calcNumberOfEmployees2(List<Department> departments, long threshold) {

        return departments.stream()
                .filter(i -> i.getCode().startsWith("111-"))
                .flatMap(i -> i.getEmployees().stream())
                .filter(i -> i.getSalary() >= 20_000)
                .count();


    }



    public static void main(String[] args) {

         Department department = new Department("111-sds","111-sds",Arrays.asList(new Employee("1",20_000L),new Employee("1",10000L)));
        Department department1 = new Department("111-sds","222-1",Arrays.asList(new Employee("John",50_000L)));
        Department department3 = new Department("111-sds","111-sds",Arrays.asList(new Employee("1",20_000L),new Employee("1",10000L),new Employee("3",30000L)));

        System.out.println(calcNumberOfEmployees2(Arrays.asList(department,department1,department3),20_000L));
    }

}




class Employee{

    private String name;
    private Long salary;

    public Employee(String name, Long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }
}

class Department{
 private String name;
 private String code;
 private List<Employee> employees;

    public Department(String name, String code, List<Employee> employees) {
        this.name = name;
        this.code = code;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}