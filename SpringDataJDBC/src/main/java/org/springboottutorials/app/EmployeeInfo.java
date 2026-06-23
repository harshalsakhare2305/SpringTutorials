package org.springboottutorials.app;

import org.springboottutorials.schema.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class EmployeeInfo {

    @Autowired
    private JdbcTemplate template;
    private String sql="Insert into empInfo(id,name,city,age) VALUES(?,?,?,?)";

    EmployeeInfo(){

    }

    public void input(Employee e){

        template.update(sql,e.getId(),e.getName(),e.getCity(),e.getAge());
        System.out.println("Data Inserted");
    }



}
