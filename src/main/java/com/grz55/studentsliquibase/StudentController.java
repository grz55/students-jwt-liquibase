package com.grz55.studentsliquibase;

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
    public Optional<Student> getStudentById(@PathVariable long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Optional<Student> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        return studentService.findById(id)
                .map(element -> {
                    element.setName(student.getName());
                    element.setYearOfBirth(student.getYearOfBirth());
                    return studentService.save(element);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        if (studentService.findById(id).isPresent()) {
            studentService.deleteStudent(id);
        }
    }

}
