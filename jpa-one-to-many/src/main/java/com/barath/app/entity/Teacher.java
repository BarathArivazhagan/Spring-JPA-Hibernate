package com.barath.app.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="TEACHER")
public class Teacher {

    @Id
    @Column(name="TEACHER_ID")
    private Long teacherId;

    @Column(name="TEACHER_NAME")
    private String teacherName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Student> students;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher(Long teacherId, String teacherName, List<Student> students) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.students = students;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", students=" + students +
                '}';
    }
}
