package lists.linkedlist;

import lists.Employee;

public class LinkedLists {
    public static void main(String[] args) {
        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("John", "Doe", 4567);
        Employee e3 = new Employee("Mary", "Smith", 22);
        Employee e4 = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList linkedList = new EmployeeLinkedList();
        System.out.println(linkedList.isEmpty());

        linkedList.addToFront(e1);
        linkedList.addToFront(e2);
        linkedList.addToFront(e3);
        linkedList.addToFront(e4);

        linkedList.printList();
        System.out.println(linkedList.getSize());

        linkedList.removeFromFront();
        System.out.println(linkedList.getSize());
        linkedList.printList();
    }
}
