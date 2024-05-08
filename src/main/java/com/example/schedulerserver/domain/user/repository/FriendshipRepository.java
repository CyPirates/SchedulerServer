package com.example.schedulerserver.domain.user.repository;

import com.example.schedulerserver.domain.user.entity.FriendShip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<FriendShip,Long> {
    Optional<FriendShip> findByUserId(String userid);
}
