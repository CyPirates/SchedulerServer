package com.example.schedulerserver.domain.user.service;


import com.example.schedulerserver.domain.user.entity.SiteUser;
import com.example.schedulerserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public SiteUser create(String userid, String name, String password){
        SiteUser user = new SiteUser();
        user.setUserid(userid);
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }

    public Boolean isExistUser(String userid){
        return this.userRepository.findByUserid(userid).isPresent();
    }



}
