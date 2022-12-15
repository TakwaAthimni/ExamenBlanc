package com.example.takwaath.Repository;

import com.example.takwaath.Entities.Sprint;
import com.example.takwaath.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepo extends JpaRepository<Sprint,Integer> {
}
