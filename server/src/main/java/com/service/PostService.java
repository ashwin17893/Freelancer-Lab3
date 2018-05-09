package com.service;

import com.entity.ProjectData;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository PostRepository;

    public Iterable<projects> getAllProjects(){
        return ProjectRepository.findAll();
    }

    public void addProject(Proect project){
        PostRepository.save(project);
    }


}