package org.springboottutorials.app;

import org.springboottutorials.schema.model.Employee;

import java.util.List;

public interface ICompany {

    List<Employee> getEmployeeList();
}
