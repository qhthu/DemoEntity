package com.example.demoentity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Classes")
public class Classes {

    @Id @GeneratedValue
    @Column(name = "ClassId")
    private Integer ClassId;

    @Column(name = "ClassName")
    private String ClassName;

    @OneToMany(mappedBy = "classes", fetch = FetchType.LAZY)
    private Set<Students> listStudent = new HashSet<>();

    public Integer getClassId() {
        return ClassId;
    }

    public void setClassId(Integer classId) {
        ClassId = classId;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public Set<Students> getListStudent() {
        return listStudent;
    }

    public void setListStudent(Set<Students> listStudent) {
        this.listStudent = listStudent;
    }
}
