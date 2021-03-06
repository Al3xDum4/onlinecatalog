package com.Alex.onlinecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // start from 1 on each table
    private Integer userId;

    private String username; //nickname
    private String emailAddress;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Role role;

    @OneToOne(mappedBy = "user")
    private PendingUser pendingUser;

}
