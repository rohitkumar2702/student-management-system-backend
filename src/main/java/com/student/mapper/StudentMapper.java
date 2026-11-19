package com.student.mapper;

import com.student.dto.request.StudentRequest;
import com.student.dto.response.StudentResponse;
import com.student.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    // Convert StudentRequest into Student Entity
    public Student toEntity(StudentRequest request){

        return Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .department(request.getDepartment())
                .build();
    }
    // Convert Student Entity into StudentResponse
    public StudentResponse toResponse(Student student){
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .department(student.getDepartment())
                .build();
    }
}
