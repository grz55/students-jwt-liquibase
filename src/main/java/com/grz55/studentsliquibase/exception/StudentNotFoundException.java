package com.grz55.studentsliquibase.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(long id) {
        super("Student id = " + id + " not found");
    }
}
