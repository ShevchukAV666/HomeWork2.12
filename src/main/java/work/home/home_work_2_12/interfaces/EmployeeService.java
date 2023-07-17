package work.home.home_work_2_12.interfaces;

import work.home.home_work_2_12.Employee;

import java.util.Map;

public interface EmployeeService {

    String addEmployee(String lastName, String firstName, int salary, String department);

    Map<String, Employee> getEmployees();

    String removeEmployee(String lastName, String firstName);

    String findEmployee(String lastName, String firstName);
}

