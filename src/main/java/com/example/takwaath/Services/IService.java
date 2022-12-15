package com.example.takwaath.Services;

import com.example.takwaath.Entities.Project;
import com.example.takwaath.Entities.User;

import java.util.List;

public interface IService {
    public User addUser(User user);
    public List<User> getAllUsers();

    public Project addProject (Project project);
    public void assignProjectToScrumMaster(int projectId, String fName , String lName);
    public  void assignProjectToDeveloper (int projectId , int devld);

    public void getProjectsCurrentSprints();




}
