package com.service;

import com.entity.ProfileData;
import com.repository.ProfileRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public void editProfile(User user){

        System.out.println("user id is "+String.valueOf(user.getId()));
        User existingProfile = userRepository.findById(Integer.parseInt(String.valueOf(user.getId())));
        if(existingProfile!=null){
            user.setId(existingProfile.getId());
        }
        profileRepository.save(user);
    }

    public User getProfile(int userid){
        return userRepository.findById(userid);
    }
}