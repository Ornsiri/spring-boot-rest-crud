package com.ornsiri.demo.rest;

import com.ornsiri.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // Endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Ornsiri","K"));
        students.add(new Student("Black", "BBC"));
        students.add(new Student("John","Doe"));

        return students;
    }
}
