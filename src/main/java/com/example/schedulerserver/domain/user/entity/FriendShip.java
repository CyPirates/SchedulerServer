package com.example.schedulerserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FriendShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_user_id")
    private SiteUser siteUser;

    private String userId;
    private String friendId;

    private FriendShipStatus status;

    private boolean isForm;

    @Setter
    private Long counterpartId;

    public void acceptFriendshipRequest() {
        status = FriendShipStatus.ACCEPT;
    }
}
