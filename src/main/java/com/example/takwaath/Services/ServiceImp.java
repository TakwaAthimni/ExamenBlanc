package com.example.takwaath.Services;

import com.example.takwaath.Entities.Project;
import com.example.takwaath.Entities.Role;
import com.example.takwaath.Entities.Sprint;
import com.example.takwaath.Entities.User;
import com.example.takwaath.Repository.ProjectRepo;
import com.example.takwaath.Repository.SprintRepo;
import com.example.takwaath.Repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Getter

public class ServiceImp implements IService{

    UserRepo userRepo;
    ProjectRepo projectRepo;
    SprintRepo sprintRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Project addProject(Project project) {
        Sprint s=new Sprint();
        s.setProject(project);
        Sprint added=sprintRepo.save(s);
        return projectRepo.save(project);
    }

    @Override
    public void assignProjectToScrumMaster(int projectId, String fName, String lName) {
        Project project=projectRepo.findById(projectId).orElse(null);
        List<User> us=userRepo.findByFNameAndIname(fName,lName);
        for (User user:us) {
            if (user.getRole()== Role.SCRUM_MASTER) {
                project.getUsers().add(user);
                projectRepo.save(project);
            }
        }

    }

    @Override
    public void assignProjectToDeveloper(int projectId, int devId) {
        Project project=projectRepo.findById(projectId).orElse(null);
       User user=userRepo.findById(devId).orElse(null);
       if (user.getRole()==Role.DEVELOPER) {
           project.getUsers().add(user);
           projectRepo.save(project);
       }

    }

    @Override
    @Scheduled (cron = "*/30 * * * * *" )
    public void getProjectsCurrentSprints() {
        List<Project> projectList = projectRepo.getProjectSprintCurrent();
        System.out.println("****** Les projets on sprint aujourdhui *************");

        for(Project p : projectList){
            System.out.println(p.toString());
        }
    }

}
