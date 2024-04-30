package com.example.schedulerserver.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userid;

    private String name;

    private String password;

    @OneToMany(mappedBy = "siteUser")
    private List<FriendShip> friendshipList = new ArrayList<>();
}
