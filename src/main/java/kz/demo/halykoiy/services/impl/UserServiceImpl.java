package kz.demo.halykoiy.services.impl;


import kz.demo.halykoiy.entities.Role;
import kz.demo.halykoiy.entities.User;
import kz.demo.halykoiy.repos.UserRepository;
import kz.demo.halykoiy.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByPhone(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Transactional
    public void setRole(User user, Role role) {
        user.setRole(role);
        userRepository.save(user);
    }

    @Transactional
    public void setLocation(User user, Double latitude, Double longitude) {
        user.setLatitude(latitude);
        user.setLongitude(longitude);
        userRepository.save(user);
    }

    public User getUserByPhone(String phone){
        return userRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}