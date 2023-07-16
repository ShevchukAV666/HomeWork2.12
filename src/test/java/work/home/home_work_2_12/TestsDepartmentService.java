package work.home.home_work_2_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import work.home.home_work_2_12.interfaces.EmployeeService;
import work.home.home_work_2_12.services.DepartmentServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestsDepartmentService {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetEmployeesByDepartment() {
        assertNotNull(employeeService);
        String department = "IT";
        List<Employee> expectedEmployees = Arrays.asList(
                new Employee("Smith", "John", 50000, "IT"),
                new Employee("Doe", "Jane", 60000, "IT")
        );

        when(employeeService.getEmployees()).thenReturn(createMockEmployeeData());
        when(employeeService.getEmployees().values()).thenReturn(expectedEmployees);

        List<Employee> employees = departmentService.getEmployeesByDepartment(department);

        assertNotNull(employees);
        assertEquals(2, employees.size());
        assertTrue(employees.stream().allMatch(e -> e.getDepartment().equals(department)));

        verify(employeeService, times(1)).getEmployees();
    }

    @Test
    public void testMockSumSalaryByDepartment() {
        assertNotNull(employeeService);
        String department = "HR";
        int expectedSumSalary = 150000;

        when(employeeService.getEmployees()).thenReturn(createMockEmployeeData());
        when(employeeService.getEmployees().values()).thenReturn(Arrays.asList(
                new Employee("Smith", "John", 50000, "IT"),
                new Employee("Doe", "Jane", 60000, "HR"),
                new Employee("Johnson", "Alex", 40000, "HR")
        ));

        int sumSalary = departmentService.sumSalaryByDepartment(department);

        assertEquals(expectedSumSalary, sumSalary);

        verify(employeeService, times(1)).getEmployees();
    }

    private Map<String, Employee> createMockEmployeeData() {
        Map<String, Employee> employees = new HashMap<>();
        employees.put("Smith John", new Employee("Smith", "John", 50000, "IT"));
        employees.put("Doe Jane", new Employee("Doe", "Jane", 60000, "HR"));
        employees.put("Johnson Alex", new Employee("Johnson", "Alex", 40000, "HR"));
        return employees;
    }

    @Test
    public void testSumSalaryByDepartment() {

        String department = "HR";
        int expectedSumSalary = 150000;

        int sumSalary = departmentService.sumSalaryByDepartment(department);

        assertEquals(expectedSumSalary, sumSalary);
    }


}
