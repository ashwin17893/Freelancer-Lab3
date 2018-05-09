package com.repository;

import com.entity.ProfileData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface ProfileRepository extends CrudRepository<User, Long> {
    List<User> findByUserid(int user_id);
}