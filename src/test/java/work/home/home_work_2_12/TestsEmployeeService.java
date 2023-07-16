package work.home.home_work_2_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import work.home.home_work_2_12.interfaces.EmployeeService;
import work.home.home_work_2_12.services.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class TestsEmployeeService {

    EmployeeService employeeService;

    @BeforeEach
    public void setUp() {

        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void testAddEmployee() {
        String lastName = "Артём";
        String firstName = "Шевчук";
        int salary = 90000;
        String department = "Java";

        String result = employeeService.addEmployee(lastName, firstName, salary, department);

        assertNotNull(result);
        assertEquals("Артём Шевчук", result);

        assertEquals(result, employeeService.findEmployee(lastName, firstName));
    }

    @Test
    public void testRemoveEmployee() {
        String lastName = "Артём";
        String firstName = "Шевчук";

        employeeService.addEmployee(lastName, firstName, 90000, "Java");

        String result = employeeService.removeEmployee(lastName, firstName);

        assertNotNull(result);
        assertEquals("Артём Шевчук", result);

        assertThrows(RuntimeException.class, () -> employeeService.findEmployee(lastName, firstName));
    }

    @Test
    public void testFindEmployee() {
        String lastName = "Артём";
        String firstName = "Шевчук";

        employeeService.addEmployee(lastName, firstName, 90000, "Java");

        String result = employeeService.findEmployee(lastName, firstName);

        assertNotNull(result);
        assertEquals("Артём Шевчук", result);
    }
}