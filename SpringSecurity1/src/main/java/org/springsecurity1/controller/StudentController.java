package org.springsecurity1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springsecurity1.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    List<Student> studentList =new ArrayList<>(List.of(new Student(1,"Harshal"),new Student(2,"Yash"),new Student(3,"PK")));


    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody  Student student){
        studentList.add(student);
        return new ResponseEntity<String>("Student with id :"+ student.getId()+" added Successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/getallstudents")
    public ResponseEntity<List> getAllStudents(){
        return new ResponseEntity<List>(studentList,HttpStatus.OK);
    }

    @GetMapping("get-session-id")
    public ResponseEntity<String> getSessionId(HttpServletRequest http){
        return ResponseEntity.ok("Session id: => "+http.getSession().getId());
    }

}
