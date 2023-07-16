package work.home.home_work_2_12.services;

import org.springframework.stereotype.Service;
import work.home.home_work_2_12.Employee;
import work.home.home_work_2_12.interfaces.EmployeeService;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees = new HashMap<>();

    public Map<String, Employee> getEmployees() {
        return employees;
    }


    public String addEmployee(String lastName, String firstName, int salary, String department) {

        validateNames(lastName, firstName);


        Employee employee = new Employee(lastName, firstName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new RuntimeException("Этот сотрудник уже есть в базе");
        }
        employees.put(employee.getFullName(), employee);
        return employee.toString();
    }

    public String removeEmployee(String lastName, String firstName) {
        validateNames(lastName, firstName);
        String fullName = lastName + " " + firstName;
        if (!employees.containsKey(fullName)) {
            throw new RuntimeException("Данного сотрудника нет в базе");
        }
        employees.remove(fullName);
        return fullName;
    }

    public String findEmployee(String lastName, String firstName) {
        validateNames(lastName, firstName);
        String fullName = lastName + " " + firstName;
        if (!employees.containsKey(fullName)) {
            throw new RuntimeException("Данного сотрудника нет в базе");
        }
        return employees.get(fullName).toString();
    }

    private void validateNames(String lastName, String firstName){
        if (!(StringUtils.isAlpha(lastName) && (StringUtils.isAlpha(firstName)))) {
            throw new RuntimeException("Неправильные символы в именах");
        }
    }
}