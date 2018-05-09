package com.repository;

import com.entity.ProjectData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface ProjectRepository extends CrudRepository<User, Long> {
    List<User> findById(int Proj_id);
}