package org.example.DZ4;

import java.util.List;

public interface EmployeeView {
    List<Employee2> employeeActions(List<Employee2> employees, EmployeeCriterion criterion);
}
