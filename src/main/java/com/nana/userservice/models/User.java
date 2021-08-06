package com.nana.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import javax.persistence.Id;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy=AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();


}
