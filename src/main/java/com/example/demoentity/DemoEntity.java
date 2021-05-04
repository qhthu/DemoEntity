package com.example.demoentity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication

@Service
public class DemoEntity extends StudentDAO{

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Classes");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Classes classes = new Classes();
        classes.setClassId(8);
        classes.setClassName("D18CQCN01-N");

        Classes classes1 = new Classes();
        classes1.setClassId(9);
        classes1.setClassName("D16CQCN01-N");

        ClassesDAO daoc = new ClassesDAO();

        daoc.save(classes);
        daoc.save(classes1);

        List<Classes> list = new ArrayList<>();
        list = daoc.get();
        for (Classes c:list) {
            System.out.println(c.getClassId());
        }

        daoc.delete(classes);
        daoc.update(classes);


        Students student = new Students();
        student.setStudentId(8);
        student.setStudentName("Nguyen Truong An");
        student.setClasses(classes);

        Students student1 = new Students();
        student1.setStudentId(89);
        student1.setStudentName("Nguyen Thanh Truc");
        student1.setClasses(classes1);

        StudentDAO daos = new StudentDAO();
        daos.save(student);
        daos.save(student1);

        List<Students> studentsList = new ArrayList<>();
        studentsList = daos.get();

        for (Students s:studentsList) {
            System.out.println(s.getStudentId());
        }
        daos.update(student);
        daos.delete(student);
    }

}
