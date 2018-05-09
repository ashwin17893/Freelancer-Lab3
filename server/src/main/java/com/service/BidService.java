package com.service;

import com.entity.Bids;
import com.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {
    @Autowired
    private BidRepository bidRepository;

    public Iterable<Bids> getAllBids(){
        return bidRepository.findAll();
    }

    public void addBid(Project project, integer bid){
        BidRepository.save(bid);
    }

    public List<Bids> Project(String proj_name){
        return ProjectRepository.findByprojID(Proj_title);
    }
}