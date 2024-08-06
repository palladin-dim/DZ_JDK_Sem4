package org.example.DZ4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static Employee2 employee;
    public static EmployeesActions employeesActions;


    public static void main(String[] args) {

        List<Employee2> employees = createEmployee();


        // 1. поиск по стажу
        System.out.println(findEmployeesByCriterion(employees, new ExperienceCriterion(5)));
        // 2. поиск номера по имени
        System.out.println(findEmployeesByPhoneNumber(employees, "Masha"));
        System.out.println(findEmployeesByCriterion(employees, new PhoneNumberCriterion("811115")));
        // 3. поиск по табельному номеру
        System.out.println(findEmployeesByCriterion(employees, new PersonnelNumberCriterion(10)));
        // 4. добвление сотрудника
        System.out.println(addEmployee(employees, new Employee2(1, "1111", "Dasha", 4)));

    }


    public static List<Employee2> createEmployee() {
        Employee2 employee1 = new Employee2(1, "811115", "Petya", 1);
        Employee2 employee2 = new Employee2(2, "812345", "Sasha", 9);
        Employee2 employee3 = new Employee2(3, "811115", "Vasya", 5);
        Employee2 employee4 = new Employee2(8, "811155", "Kolya", 2);
        Employee2 employee5 = new Employee2(10, "811145", "Masha", 5);
        Employee2 employee6 = new Employee2(10, "855555", "Masha", 5);
        List<Employee2> employees = new ArrayList<>();

        Collections.addAll(employees, employee1, employee2, employee3, employee4, employee5, employee6);

        return employees;
    }

    public static List<Employee2> findEmployeesByCriterion(List<Employee2> employees, EmployeeCriterion criterion) {
        EmployeesActions employeesActions = new EmployeesActions();
        return employeesActions.employeeActions(employees, criterion);
    }

    public static List<Employee2> addEmployee(List<Employee2> employees, Employee2 employee) {
        employees.add(employee);
        return employees;
    }

    public static List<String> findEmployeesByPhoneNumber(List<Employee2> employees, String name) {
        List<String> phoneNumbers = new ArrayList<>();
        for (Employee2 employee : employees) {
            if (employee.getName().equals(name)) {
                phoneNumbers.add(employee.getPhoneNumber());
            }
        }
        return phoneNumbers;
    }

}

