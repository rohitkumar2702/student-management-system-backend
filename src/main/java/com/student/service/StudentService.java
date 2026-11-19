package com.student.service;

import com.student.dto.request.StudentRequest;
import com.student.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    // Create a new student
    StudentResponse createStudent(StudentRequest request);

    // Get all students
    List<StudentResponse> getAllStudents();

    // Get student by ID
    StudentResponse getStudentById(Long id);

    // Update student details
    StudentResponse updateStudent(Long id, StudentRequest request);

    // Delete student by ID
    void deleteStudent(Long id);


}
