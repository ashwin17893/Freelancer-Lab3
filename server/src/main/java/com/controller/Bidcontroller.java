package com.controller;

import com.entity.ProjectData;
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
public class BidController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    @Autowired
    private BidService bidService;

    @PostMapping(path="/bidproject",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> BidProject (@RequestBody Bid bid) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        String project = ProjectData.getTitle();

        Biddata.postbid(project);
        BidService.bidproject(project);

        BidService.bidproject(String.valueOf(project.getId()), "./uploads/", -1);
        System.out.println("bid amount Saved");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }



    @GetMapping(path="/allbids",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<bid> getAllbids() {
        // This returns a JSON with the users
        return BidService.getAllBids();
    }


}
