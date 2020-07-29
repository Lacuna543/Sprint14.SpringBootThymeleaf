package com.softserve.edu.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
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
    @OneToMany(mappedBy = "marathon", cascade = CascadeType.REMOVE)
    private List<Sprint> sprints = new LinkedList<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "marathon_user", joinColumns = @JoinColumn(name = "marathon_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users = new LinkedList<>();

  /*  @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<User> trainees = new LinkedList<>();
*/

}
