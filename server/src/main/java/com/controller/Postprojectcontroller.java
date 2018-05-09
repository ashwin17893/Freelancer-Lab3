package com.controller;

import com.entity.User;
import com.service.UserService;
import com.service.Projectservice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import javax.servlet.http.HttpSession;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class PostprojectController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService projectService;

    @PostMapping(path="/postproject",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> postNewProject (@RequestBody Project project) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        String received = project.getTitle();

        project.settitle(reciebed);
        projectService.postproject(project);

        PostService.createProject(String.valueOf(project.getId()), "./uploads/", -1);
        System.out.println("project posted");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }



    @GetMapping(path="/allProjects",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<User> getAllprojects() {
        // This returns a JSON with the users
        return projectService.getAllProjects();
    }

