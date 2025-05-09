package com.example.service;

import com.example.model.Identifiable;
import com.example.repository.GenericRepository;
import org.springframework.transaction.annotation.Transactional;

public class GenericService<T extends Identifiable> {

    private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T > repository) {
        this.repository = repository;
    }
    @Transactional
    public T save(String id, T dto) {
        try {
            dto.setId(id);
            return repository.save(dto);
        } catch (Exception e) {
            throw new RuntimeException("Không thể lưu DTO: " + e.getMessage(), e);
        }
    }

    public T findById(String id) {
        return repository.findById(id);
    }
}