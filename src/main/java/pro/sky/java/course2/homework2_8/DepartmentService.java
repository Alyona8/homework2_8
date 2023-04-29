package pro.sky.java.course2.homework2_8;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework2_8.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private List<Employee> staff = new ArrayList<>(List.of(
            new Employee("Марина", "Арбузова", 1, 100_000),
            new Employee("Михаил", "Басманов", 2, 30_000),
            new Employee("Арина", "Волкова", 5, 70_000),
            new Employee("Марат", "Галиуллин", 3, 250_000),
            new Employee("Мария", "Дерябина", 4, 50_000),
            new Employee("Тимофей", "Елистратов", 5, 35_000),
            new Employee("Анна", "Жигалова", 4, 65_000),
            new Employee("Артур", "Зайнуллин", 2, 25_000),
            new Employee("Иван", "Игнатьев", 3, 115_000),
            new Employee("Арина", "Котова", 4, 130_000)
    ));

    public Employee findMaxSalaryInDept(int deptNumber) {
        return staff.stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Сотрудник не найден"));
    }

    public Employee findMinSalaryInDept(int deptNumber) {
        return staff.stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Сотрудник не найден"));
    }

    public List<Employee> getEmployeesOfDept(int deptNumber) {
        return staff.stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .collect(Collectors.toList());
    }

    public List<Employee> getStaffByDept() {
        return staff.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}