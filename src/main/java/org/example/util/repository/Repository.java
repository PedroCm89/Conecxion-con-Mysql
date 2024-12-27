package org.example.util.repository;

import java.util.List;

public interface Repository <T>{
    List<T> findAll();
    T forId(Long id);
    void save (T t);
    void delete(Long id);


}
