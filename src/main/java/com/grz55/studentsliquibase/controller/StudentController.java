package com.grz55.studentsliquibase.controller;

import com.grz55.studentsliquibase.exception.StudentNotFoundException;
import com.grz55.studentsliquibase.model.Student;
import com.grz55.studentsliquibase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        return studentService.findById(id)
                .map(element -> {
                    element.setName(student.getName());
                    element.setYearOfBirth(student.getYearOfBirth());
                    return studentService.save(element);
                })
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        if (studentService.findById(id).isPresent()) {
            studentService.deleteStudent(id);
        } else {
            throw new StudentNotFoundException(id);
        }
    }
}
