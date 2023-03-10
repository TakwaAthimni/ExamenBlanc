package com.example.takwaath.Repository;

import com.example.takwaath.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findByFNameAndIname(String fName, String iName);

}
