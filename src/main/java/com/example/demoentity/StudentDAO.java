package com.example.demoentity;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDAO implements DAO<Students>{

    @PersistenceContext
    static EntityManager em;

    @Override
    public Students get(Integer Id) {
        return em.find(Students.class, Id);
    }

    @Override
    public List<Students> get() {
        return em.createQuery("FROM Students ").getResultList();
    }

    @Override
    public Students save(Students students) {

        em.persist(students);

        return students;
    }

    @Override
    public Students update(Students students) {
        em.merge(students);
        return students;
    }

    @Override
    public Students delete(Students students) {

        if(em.contains(students)){
            em.remove(students);
        }
        return students;
    }
}
