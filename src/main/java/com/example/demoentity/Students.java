package com.example.demoentity;

import javax.persistence.*;

@Entity
@Table(name = "Students")
public class Students {

    @Id @GeneratedValue
    @Column(name = "StudentId")
    private Integer StudentId;

    @Column(name = "StudentName")
    private String StudentName;

    @ManyToOne
    @JoinColumn(name = "ClassId")
    private Classes classes;

    public Integer getStudentId() {
        return StudentId;
    }

    public void setStudentId(Integer studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
