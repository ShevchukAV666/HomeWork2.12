package work.home.home_work_2_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import work.home.home_work_2_12.interfaces.EmployeeService;
import work.home.home_work_2_12.services.EmployeeServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestsEmployeeService {

    EmployeeService employeeBookService;

    @BeforeEach
    public void setUp() {
        employeeBookService = new EmployeeServiceImpl();
    }

    @Test
    public void TestAddEmployee() {
        Employee employee = new Employee("Шевчук", "Артём",
                90000, "Java");

        Map<String, Employee> expected = new HashMap<>();
        expected.put("Шевчук Артём", employee);

        employeeBookService.addEmployee("Шевчук", "Артём",
                90000, "Java");

        Map<String, Employee> actual = employeeBookService.getEmployees();

        assertEquals(expected, actual);
    }

    @Test
    public void TestRemoveEmployee() {
        Employee employee1 = new Employee("Шевчук", "Артём",
                90000, "Java");

        Employee employee2 = new Employee("Бодров", "Сергей",
                60000, "Java2");

        Map<String, Employee> expected = new HashMap<>();
        expected.put("Шевчук Артём", employee1);

        employeeBookService.addEmployee("Шевчук", "Артём",
                90000, "Java");

        employeeBookService.addEmployee("Бодров", "Сергей",
                60000, "Java2");

        employeeBookService.removeEmployee("Бодров", "Сергей");

        Map<String, Employee> actual = employeeBookService.getEmployees();

        assertEquals(expected, actual);
    }

    @Test
    public void TestFindEmployee() {

        String expected = "Фамилия: Шевчук, имя: Артём, зарплата: 90000, отдел: Java";

        employeeBookService.addEmployee("Шевчук", "Артём",
                90000, "Java");

        String actual = employeeBookService.findEmployee("Шевчук", "Артём");

        assertEquals(expected, actual);
    }
}