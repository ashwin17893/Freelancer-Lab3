package com.controller;

import com.entity.User;
import com.service.ProfileService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping(path="/getProfile",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getprofile(@RequestBody Integer user, HttpSession session)
    {

        return new ResponseEntity(profileService.getProfile(user),HttpStatus.OK);
    }

    @PostMapping(path="/editProfile",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> editProfile(@RequestBody User user) {

        profileService.editProfile(user);
        return new ResponseEntity(null,HttpStatus.CREATED);
    }
}
