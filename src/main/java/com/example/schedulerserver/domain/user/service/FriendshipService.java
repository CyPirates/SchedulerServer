package com.example.schedulerserver.domain.user.service;

import com.example.schedulerserver.domain.user.entity.FriendShip;
import com.example.schedulerserver.domain.user.entity.FriendShipStatus;
import com.example.schedulerserver.domain.user.entity.SiteUser;
import com.example.schedulerserver.domain.user.repository.FriendshipRepository;
import com.example.schedulerserver.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipService {
    @Autowired
    private static UserRepository userRepository;
    private static FriendshipRepository friendshipRepository;

    public static void createFriendship(String to) throws Exception{
        String from = SecurityContextHolder.getContext().getAuthentication().getName();

        SiteUser fromUser = userRepository.findByUserid(from).orElseThrow(() -> new Exception("사용자를 찾을 수 없습니다."));
        SiteUser toUser = userRepository.findByUserid(to).orElseThrow(() -> new Exception("사용자를 찾을 수 없습니다."));

        FriendShip friendShipFrom = FriendShip.builder()
                .siteUser(fromUser)
                .userId(from)
                .friendId(to)
                .status(FriendShipStatus.WAITING)
                .isForm(false)
                .build();

        FriendShip friendShipTo = FriendShip.builder()
                .siteUser(toUser)
                .userId(to)
                .friendId(from)
                .status(FriendShipStatus.WAITING)
                .isForm(false)
                .build();

        fromUser.getFriendshipList().add(friendShipTo);
        toUser.getFriendshipList().add(friendShipFrom);
        friendshipRepository.save(friendShipTo);
        friendshipRepository.save(friendShipFrom);

        friendShipTo.setCounterpartId(friendShipFrom.getId());
        friendShipFrom.setCounterpartId(friendShipTo.getId());
    }

    @Transactional
    public ResponseEntity<?> getWaitingFriendList(String name) throws Exception{
        SiteUser users = userRepository.findByUserid(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(()
                -> new Exception("사용자를 찾을 수 없습니다."));
        List<FriendShip> friendshipList = users.getFriendshipList();
        List<WaitingFriendListDto> result = new ArrayList<>();

        for (FriendShip x : friendshipList){
            if (!x.isForm() && x.getStatus() == FriendShipStatus.WAITING){
                SiteUser friend = userRepository.findByUserid(x.getFriendId()).orElseThrow(() -> new Exception("사용자를 찾을 수 없습니다."));
                WaitingFriendListDto dto = WaitingFriendListDto.builder()
                        .friendshipId(x.getId())
                        .friendUserId(friend.getUserid())
                        .friendName(friend.getName())
                        .status(x.getStatus())
                        .build();
                result.add(dto);
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @Data
    @Builder
    static class WaitingFriendListDto{
        private Long friendshipId;
        private String friendUserId;
        private String friendName;
        private FriendShipStatus status;
    }

    public static String approveFriendshipRequest(Long friendShipId) throws Exception{
        FriendShip friendship = friendshipRepository.findByUserId(String.valueOf(friendShipId)).orElseThrow(() -> new Exception("친구요청을 찾을 수 없습니다."));
        FriendShip counterpart = friendshipRepository.findById(friendship.getCounterpartId()).orElseThrow(() -> new Exception("친구요청을 찾을 수 없습니다."));

        friendship.acceptFriendshipRequest();
        counterpart.acceptFriendshipRequest();

        return "친구요청 승인 성공";
    }
}
