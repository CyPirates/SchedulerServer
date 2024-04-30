package com.example.schedulerserver.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FriendShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private SiteUser siteUser;

    private String userId;
    private String friendId;

    private FriendShipStatus status;

    private boolean isForm;

    @Setter
    private Long couterpartId;

    public void acceptFriendshipRequest(){
        status = FriendShipStatus.ACCEPT;

}
