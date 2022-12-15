package com.example.takwaath.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private int id;
    private String email;
    private String pwd;
    private String fName;
    private String lName;
    private Role role;
    @ManyToMany
    @JsonIgnore
    private List<Project> projects;
    @OneToMany
    @JsonIgnore
    private List<Project> projectS;





}
