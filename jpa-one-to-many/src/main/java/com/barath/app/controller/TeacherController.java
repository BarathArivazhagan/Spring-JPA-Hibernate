package com.barath.app.controller;


import com.barath.app.entity.Student;
import com.barath.app.entity.Teacher;
import com.barath.app.service.StudentService;
import com.barath.app.service.TeacherService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/teachers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> findAllgetTeachers(){
        return this.teacherService.getTeachers();
    }
}
