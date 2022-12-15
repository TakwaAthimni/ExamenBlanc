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
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProject")
    private int projectId;
    private String table ;
    private String description;
    @ManyToMany (mappedBy="projects", cascade = CascadeType.PERSIST)
    private List<User> users;
    @OneToMany(mappedBy="project", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Sprint> sprints;


}
