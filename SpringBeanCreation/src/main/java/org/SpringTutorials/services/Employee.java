package org.SpringTutorials.services;

public class Employee {
    String id;
    String name;

    int salary;
    int age;


    public Employee(String id, String name, int salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String getId() {
        return id;
    }
}
