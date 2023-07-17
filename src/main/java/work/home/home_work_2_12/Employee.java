package work.home.home_work_2_12;

import org.springframework.util.StringUtils;

import java.util.Objects;

public class Employee {

    private String lastName;
    private String firstName;
    private int salary;
    private String department;


    public Employee(String lastName, String firstName, int salary, String department) {
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Фамилия: " + this.lastName +
                ", имя: " + this.firstName +
                ", зарплата: " + this.salary +
                ", отдел: " + this.department;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) && Objects.equals(department, employee.department);
    }
    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, salary, department);
    }
}

