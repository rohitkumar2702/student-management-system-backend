package com.student.service.impl;


import com.student.dto.request.StudentRequest;
import com.student.dto.response.StudentResponse;
import com.student.entity.Student;
import com.student.exception.StudentNotFoundException;
import com.student.mapper.StudentMapper;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

//    public StudentServiceImpl(StudentRepository studentRepository,StudentMapper studentMapper){
//        this.studentRepository=studentRepository;
//        this.studentMapper=studentMapper;
//    }
    @Override
    public StudentResponse createStudent(StudentRequest request) {

        Student rohit=studentMapper.toEntity(request);
        Student savedStudent=studentRepository.save(rohit);
        return studentMapper.toResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
      return studentRepository.findAll()
               .stream()
               .map(studentMapper::toResponse)
               .toList();

    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student rohit=studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student not found with id: "+id));
        return studentMapper.toResponse(rohit);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student rohit=studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found with id: "+id));
        rohit.setName(request.getName());
        rohit.setEmail(request.getEmail());
        rohit.setAge(request.getAge());
        rohit.setDepartment(request.getDepartment());
        Student updateStudent=studentRepository.save(rohit);
        return studentMapper.toResponse(updateStudent);
    }

    @Override
    public void deleteStudent(Long id) {
       Student student=studentRepository.findById(id)
                .orElseThrow(()->
                        new StudentNotFoundException("Student not found with id: "+id));
        studentRepository.delete(student);
    }
}
