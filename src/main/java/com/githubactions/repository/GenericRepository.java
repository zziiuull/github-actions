package com.githubactions.repository;

import java.util.List;

public interface GenericRepository<K, V>{
    V create(V v);
    V find(K k);
    List<V> findAll();
    void update(V v);
    void delete(K k);
}
