package com.glassofwater.gow.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users_table")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private Integer rate;

    @OneToMany
    private List<Trip> trips;
}
