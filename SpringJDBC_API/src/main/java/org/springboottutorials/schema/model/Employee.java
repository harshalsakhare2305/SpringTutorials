package org.springboottutorials.schema.model;

public class Employee {

    private Integer id;
    private String name;
    private String city;
    private Integer age;

    public Employee(Integer id, String name, String city, Integer age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public Employee() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
