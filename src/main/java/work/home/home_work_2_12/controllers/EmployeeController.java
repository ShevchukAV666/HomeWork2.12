package work.home.home_work_2_12.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.home.home_work_2_12.interfaces.EmployeeService;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("lastName") String lastName,
                              @RequestParam ("firstName") String firstName,
                              @RequestParam ("salary") int salary,
                              @RequestParam ("department") String department){
            return employeeService.addEmployee(lastName, firstName, salary, department);
        }

        @GetMapping(path = "/remove")
        public String removeEmployee(@RequestParam ("lastName") String lastName,
                                     @RequestParam("firstName") String firstName) {
            return employeeService.removeEmployee(lastName, firstName);
        }
        @GetMapping(path = "/find")
        public String findEmployee(@RequestParam ("lastName") String lastName,
                                   @RequestParam ("firstName") String firstName){
            return employeeService.findEmployee(lastName, firstName);
        }
    }

