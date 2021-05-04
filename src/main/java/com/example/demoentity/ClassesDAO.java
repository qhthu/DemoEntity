package com.example.demoentity;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ClassesDAO implements DAO<Classes>{

    @PersistenceContext
    static EntityManager em;

    @Override
    public Classes get(Integer Id) {
        return em.find(Classes.class, Id);
    }

    @Override
    public List<Classes> get() {
        return em.createQuery("FROM Classes ").getResultList();
    }

    @Override
    public Classes save(Classes classes) {

        em.persist(classes);

        return classes;
    }

    @Override
    public Classes update(Classes classes) {
        em.merge(classes);
        return classes;
    }

    @Override
    public Classes delete(Classes classes) {

        if(em.contains(classes)){
            em.remove(classes);
        }
        return classes;
    }
}
