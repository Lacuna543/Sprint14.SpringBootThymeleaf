package com.softserve.edu.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@ToString(exclude = {"sprints", "users"})
@Entity
public class Marathon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy="marathon", cascade = CascadeType.ALL)
    private Set<Sprint> sprints = new LinkedHashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(
            name="marathon_user", joinColumns=@JoinColumn(name="marathon_id"),
            inverseJoinColumns=@JoinColumn(name="user_id")
    )
    private Set<User> users = new LinkedHashSet<>();

//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private Set<User> trainees = new LinkedHashSet<>();

   }
