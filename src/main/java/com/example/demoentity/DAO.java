package com.example.demoentity;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T get(Integer Id);
    List<T> get();
    public T save(T t);
    public T update(T t);
    public T delete(T t);
}
