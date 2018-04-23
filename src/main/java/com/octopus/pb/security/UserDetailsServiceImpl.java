package com.octopus.pb.security;


import com.octopus.pb.entity.security.RoleApp;
import com.octopus.pb.entity.security.UserApp;
import com.octopus.pb.enums.RoleType;
import com.octopus.pb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp userApp = userRepository.findByUsername(username);

        if (userApp == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(userApp.getUsername(), userApp.getPassword(), getAuthorities(userApp.getRoleAppSet()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<RoleApp> roles) {

        return getGrantedAuthorities(roles);
    }

    private List<GrantedAuthority> getGrantedAuthorities(Collection<RoleApp> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleApp role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }
    
}
