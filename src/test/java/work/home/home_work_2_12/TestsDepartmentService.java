package work.home.home_work_2_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import work.home.home_work_2_12.interfaces.DepartmentService;
import work.home.home_work_2_12.interfaces.EmployeeService;
import work.home.home_work_2_12.services.DepartmentServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestsDepartmentService {

    private DepartmentService departmentService;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        departmentService = new DepartmentServiceImpl(employeeService);
    }

    @Test
    public void TestGetEmployeesByDepartment() {

        assertNotNull(employeeService);

        Employee employee = new Employee("Шевчук", "Артём",
                90000, "Java");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Шевчук Артём ", employee);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        List<Employee> expected = new ArrayList<>();
        expected.add(employee);

        List<Employee> actual = departmentService.getEmployeesByDepartment("Java");

        assertEquals(expected, actual);
    }

    @Test
    public void TestSumSalaryByDepartment() {
        assertNotNull(employeeService);

        Employee employee1 = new Employee("Шевчук", "Артём",
                90000, "Java");
        Employee employee2 = new Employee("Бодров", "Сергей",
                60000, "Java");
        Employee employee3 = new Employee("Безруков", "Александр",
                50000, "Java3");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Шевчук Артём", employee1);
        employees.put("Бодров Сергей", employee2);
        employees.put("Безруков Александр", employee3);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        int expected = 200000;

        int actual = departmentService.sumSalaryByDepartment("Java");

        assertEquals(expected, actual);

    }

    @Test
    public void TestMaxSalaryByDepartment() {
        assertNotNull(employeeService);

        Employee employee1 = new Employee("Шевчук", "Артём",
                90000, "Java");
        Employee employee2 = new Employee("Бодров", "Сергей",
                60000, "Java");
        Employee employee3 = new Employee("Безруков", "Александр",
                50000, "Java3");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Шевчук Артём", employee1);
        employees.put("Бодров Сергей", employee2);
        employees.put("Безруков Александр", employee3);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        int expected = 90000;

        int actual = departmentService.maxSalaryByDepartment("Java");

        assertEquals(expected, actual);

    }

    @Test
    public void minSalaryByDepartmentTest() {
        assertNotNull(employeeService);

        Employee employee1 = new Employee("Шевчук", "Артём",
                90000, "Java");
        Employee employee2 = new Employee("Бодров", "Сергей",
                60000, "Java");
        Employee employee3 = new Employee("Безруков", "Александр",
                50000, "Java3");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Шевчук Артём", employee1);
        employees.put("Бодров Сергей", employee2);
        employees.put("Безруков Александр", employee3);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        int expected = 50000;

        int actual = departmentService.minSalaryByDepartment("Java");

        assertEquals(expected, actual);

    }

    @Test
    public void TestGetEmployeesByDepartments() {

        Employee employee1 = new Employee("Шевчук", "Артём",
                90000, "Java");
        Employee employee2 = new Employee("Бодров", "Сергей",
                60000, "Java");
        Employee employee3 = new Employee("Безруков", "Александр",
                50000, "Java3");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Шевчук Артём", employee1);
        employees.put("Бодров Сергей", employee2);
        employees.put("Безруков Александр", employee3);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        Map<String, List<Employee>> expected = new HashMap<>();
        expected.put("Java", Arrays.asList(employee1, employee2));
        expected.put("Java3", Arrays.asList(employee3));

        Map<String, List<Employee>> actual = departmentService.getEmployeesByDepartments();

        assertEquals(expected.keySet(), actual.keySet());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get("Java").get(0), actual.get("Java").get(1));
    }
}