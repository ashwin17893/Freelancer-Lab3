package com.repository;

import com.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface Bidrepository extends CrudRepository<Project, Long> {
    List<User> findById(String projectId);
    User findById(int projId);
    List<User> findById(String projname);
}