package com.controller;

import com.entity.User;
import com.service.UserService;
import org.json.JSONObject;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import org.w3c.dom.html.HTMLParagraphElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/operations")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(path="/signup",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        String password = user.getPassword();
        String Pass = userService.generateHash(password);
        user.setPassword(Pass);
        userService.addUser(user);
        System.out.println("user is "+user.getId());
        fileService.createFile(String.valueOf(user.getId()), "./uploads/", -1);
        System.out.println("Saved");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }





    @PostMapping(path="/signin",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);



        List<User> userList = userService.login(jsonObject.getString("username"),userService.generateHash(jsonObject.getString("password")));



        session.setAttribute("name",jsonObject.getString("username"));
        if(userList.size()>0)
            session.setAttribute("id",userList.get(0).getId());
        return new ResponseEntity(userService.login(jsonObject.getString("username"),userService.generateHash(jsonObject.getString("password"))),HttpStatus.OK);
    }

    @PostMapping(value = "/signout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {

        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }
}