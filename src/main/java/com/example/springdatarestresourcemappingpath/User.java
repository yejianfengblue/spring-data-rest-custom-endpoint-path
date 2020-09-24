package com.example.springdatarestresourcemappingpath;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor  // used by hibernate
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    public User(String username) {
        this.username = username;
    }
}
