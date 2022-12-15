package com.example.takwaath.Repository;

import com.example.takwaath.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface ProjectRepo extends JpaRepository<Project,Integer> {
    @Query ("SELECT p FROM Project p , Sprint s where  p.projectId = s.project.projectId and s.startDate = current_date ")
    List<Project>  getProjectSprintCurrent();
}
