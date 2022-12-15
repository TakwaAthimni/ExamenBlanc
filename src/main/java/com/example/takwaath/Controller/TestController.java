package com.example.takwaath.Controller;

import com.example.takwaath.Entities.Project;
import com.example.takwaath.Entities.User;
import com.example.takwaath.Services.IService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    IService iService;
    @PostMapping("/addUser")
    @ResponseBody
    public User addUser  (@RequestBody User user){
            return iService.addUser(user);
    }
    @PostMapping("/addProject")
    @ResponseBody
    public Project addProject  (@RequestBody Project project){
        return iService.addProject(project);
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return  iService.getAllUsers();
    }
    @PostMapping("/assignProjectToScrumMaster")
    public void assignProjectToScrumMaster(int projectId, String fName, String lName) {
        iService.assignProjectToScrumMaster(projectId, fName, lName);
    }
    @PostMapping("/assignProjectToDeveloper")
    public void assignProjectToDeveloper(int projectId, int devId) {
        iService.assignProjectToDeveloper(projectId, devId);
    }





    }
