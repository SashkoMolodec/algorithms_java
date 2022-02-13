package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {

    // Vector is a thread-safe array list

        List<Employee> employeeList = new Vector<>();

        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

    }
}
