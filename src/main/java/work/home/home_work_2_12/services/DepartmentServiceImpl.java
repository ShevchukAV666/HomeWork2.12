package work.home.home_work_2_12.services;

import org.springframework.stereotype.Service;
import work.home.home_work_2_12.Employee;
import work.home.home_work_2_12.exceptions.AbsentDepartmentException;
import work.home.home_work_2_12.exceptions.BlankDepartmentException;
import work.home.home_work_2_12.interfaces.DepartmentService;
import work.home.home_work_2_12.interfaces.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployeesByDepartment(String department){

        throwExceptions(department);

        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .collect(Collectors.toList());
    }

    public int sumSalaryByDepartment(String department){

        throwExceptions(department);

        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .map(employee -> employee.getSalary())
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public int maxSalaryByDepartment(String department){

        throwExceptions(department);

        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .map(employee -> employee.getSalary())
                .max(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Сотрудник с максимальной зарплатой не найден"));
    }

    public int minSalaryByDepartment(String department){

        throwExceptions(department);

        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .map(employee -> employee.getSalary())
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Сотрудник с минимальной зарплатой не найден"));
    }

    public Map<String, List<Employee>> getEmployeesByDepartments(){

        Map<String, List<Employee>> employeesByDepartments = new HashMap<>();

        List<String> departments = getDepartments();
        for (String dep : departments) {
            List<Employee> empls = employeeService.getEmployees().values().stream()
                    .filter(e -> e.getDepartment().contains(dep))
                    .collect(Collectors.toList());
            employeesByDepartments.put(dep, empls);
        }
        return employeesByDepartments;
    }

    private List<String> getDepartments(){
        return employeeService.getEmployees().values().stream()
                .map(employee -> employee.getDepartment())
                .distinct()
                .collect(Collectors.toList());
    }

    private void throwExceptions(String department){
        if (department.isBlank()){
            throw new BlankDepartmentException("Отдел пустой");
        }
        if (!getDepartments().contains(department)){
            throw new AbsentDepartmentException("Отдел отсутствует");
        }
    }

}
