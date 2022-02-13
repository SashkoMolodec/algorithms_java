package lists;

import java.util.ArrayList;
import java.util.List;

public class ArrayLists {

    public static void main(String[] args) {

        // create a backing array at length 10 if we don't specify capacity in the constructor
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        // constant time
        System.out.println(employeeList.get(1));

        // constant time
        employeeList.set(1, new Employee("John", "Adams", 4568));

        // linear time
        employeeList.add(3, new Employee("John", "Doe", 4567));

        Object[] employeesArray = employeeList.toArray(new Employee[employeeList.size()]);

        // employeeList.forEach(System.out::println);
    }

}
