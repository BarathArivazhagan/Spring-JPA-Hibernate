package com.barath.app.service;

import com.barath.app.entity.Student;
import com.barath.app.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){

        return this.studentRepository.save(student);
    }

    public List<Student> saveStudents(List<Student> students){

        return this.studentRepository.saveAll(students);
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }
}
