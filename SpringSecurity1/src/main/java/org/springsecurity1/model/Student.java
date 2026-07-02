package org.springsecurity1.model;

public class Student {

    private Integer id;
    private String name;


    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(){}

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
