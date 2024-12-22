package com.example.FilmBuffs.service;

import com.example.FilmBuffs.Utils.AuthoritiesListProvider;
import com.example.FilmBuffs.Utils.Constants;
import com.example.FilmBuffs.dao.UserRepository;
import com.example.FilmBuffs.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Configuration
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User save(String userType, User user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        String authorities = AuthoritiesListProvider.getAuthorities(userType);

        try{
            if(authorities.equals(Constants.INVALID_USER)) {
                return new User();
            }

            user.setPassword(encryptedPassword);
            user.setAuthorities(authorities);

            return userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
