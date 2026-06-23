package org.springboottutorials.app;

import org.springboottutorials.schema.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository("dao")
public class CompanyClass implements ICompany {

    @Autowired
     private DataSource dataSource;

    private String sql = "Select * from empInfo";

    @Override
    public List<Employee> getEmployeeList() {

        List<Employee> emp =new ArrayList<>();

        try {

            Connection con = dataSource.getConnection();

            Statement statement =con.createStatement();
            ResultSet set = statement.executeQuery(sql);

            while(set.next()){
                emp.add(new Employee(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4)));
            }




        }catch (Exception e){
            e.printStackTrace();
        }

        return emp;
    }
}
