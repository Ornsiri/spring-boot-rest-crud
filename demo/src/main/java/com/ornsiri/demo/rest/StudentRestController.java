package com.ornsiri.demo.rest;

import com.ornsiri.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    // Endpoint for "/students" - return a list of students
    List<Student> students;

    // Defines @PostConstruction to load the student data only once!
    @PostConstruct
    public void loadStudents(){
        students = new ArrayList<>();

        students.add(new Student("Ornsiri","K"));
        students.add(new Student("Black", "BBC"));
        students.add(new Student("John","Doe"));

    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }


}
