package com.example.repository;

public interface GenericRepository<T> {
    T save(T dto);
    T findById(String id);
}