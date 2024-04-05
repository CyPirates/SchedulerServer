package com.example.schedulerserver.domain.user;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public SiteUser create(String user_id, String name, String password){
        SiteUser user = new SiteUser();
        user.setUser_id(user_id);
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
}
