package com.server.test;

import com.entity.ProjectData;
import com.entity.User;
import com.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FreelancerTest {

    @Autowired
    UserService userService;
    @Autowired
    FileService fileService;
    @Autowired
    PostService postService;
    @Autowired
    Projectservice projectservice;
    @Autowired
    ProfileService profileService;

    public void setUp(){

    }

    public void tearDown(){

    }

    @Test
    public void Validlogin() {
        List<User> userList = userService.login("ashwin@gmail.com",userService.generateHash("1234"));
        System.out.println(userList);
        if(userList.size()==1){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void UserByEmail() {
        List<User> userList = userService.findByEmail("ashwin@gmail.com");
        System.out.println(userList);
        if(userList.size()==1){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void findUsers()
    {
        Iterable<User> userList = userService.getAllUsers();
        System.out.println(userList);
        if(userList.spliterator().getExactSizeIfKnown()>0)
        {
            assert true;
        }
        else {
            assert false;
        }
    }
    @Test
    public void InvalidUser() {
        List<User> userList = userService.login("wrong.com",userService.generateHash("m"));
        System.out.println(userList);
        if(userList.size()==0){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void MyProfile() {
        User user = profileService.fetchProfile(34);
        System.out.println(user);
        if(user!=null){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void getFileDetails() {
        List<FileDetails> fileDetails = fileService.findByPath("./uploads/33");
        System.out.println(fileDetails);
        if(fileDetails!=null){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void starFile() {
        int result = fileService.changeStarredStatus(1, true);
        System.out.println("result : "+result);
        if(result==1){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void shredFiles() {
        List<ProjectData> sharedDetailsList = postService.findBySharedWith("q@q.com");
        System.out.println("result : "+sharedDetailsList.size());
        if(sharedDetailsList!=null){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void getUserLogs(){
        List<FileOperationLogs> logs = projectservice.findByUserid(33);
        if(logs!=null){
            assert true;
        }
        else {
            assert false;
        }
    }
    @Test
    public void folderCreation() {
        if(fileService.createFile("dropbox","./uploads/1",-1)) {
            assert true;
        }
        else {
            assert false;
        }
    }


}
