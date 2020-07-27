package com.Alex.onlinecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
;import java.sql.Date;

@Entity
@Table
@Data
@NoArgsConstructor
public class PendingUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String activationCode;
    private Date expireDate;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

}
