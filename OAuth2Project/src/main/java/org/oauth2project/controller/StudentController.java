package org.oauth2project.controller;


import org.oauth2project.Model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> studentList=new ArrayList<>(List.of(new Student(1,"Harshal"),new Student(2,"Yash")));

    @GetMapping("/get-allstudent")
    public ResponseEntity<List> getAllStudents(){
        return new ResponseEntity<List>(studentList, HttpStatus.OK);
    }




}
