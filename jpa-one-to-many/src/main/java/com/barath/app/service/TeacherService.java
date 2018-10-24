package com.barath.app.service;

import com.barath.app.entity.Student;
import com.barath.app.entity.Teacher;
import com.barath.app.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher saveTeacher(Teacher teacher){
        return this.teacherRepository.save(teacher);
    }

    public List<Teacher> saveTeachers(List<Teacher> teachers){
        return this.teacherRepository.saveAll(teachers);
    }

    public List<Teacher> getTeachers(){
        return this.teacherRepository.findAll();
    }


    @PostConstruct
    public void init(){

        Student student1 = new Student(1L,"stud1");
        Student student2 = new Student(2L,"stud2");
        Teacher teacher = new Teacher(1L,"teacher1", Arrays.asList(student1,student2));
        this.saveTeacher(teacher);
        this.teacherRepository.findAll().forEach( teacher1 -> {
            System.out.println("teacher "+teacher1);
        });

    }


}
