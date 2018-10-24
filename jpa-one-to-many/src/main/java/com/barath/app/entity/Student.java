package com.barath.app.entity;


import javax.persistence.*;

@Entity
@Table(name="STUDENT")
public class Student {

    @Id
    @Column(name="STUDENT_ID")
    private Long studentId;

    @Column(name="STUDENT_NAME")
    private String studentName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    public Student() {
    }

    public Student(Long studentId, String studentName, Teacher teacher) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.teacher = teacher;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public Student(Long studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
