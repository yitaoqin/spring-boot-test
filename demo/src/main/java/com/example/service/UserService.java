package com.example.service;

import com.example.domain.Authority;
import com.example.domain.Role;
import com.example.domain.UserEntity;
import com.example.domain.Users;
import com.example.jpa.UserEntityJpa;
import com.example.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    UserEntityJpa jpa;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity users = jpa.findByUsernameCaseInsensitive(username);
        if (users == null) {
            throw new UsernameNotFoundException("未查询到用户信息:" + username);
        }
        List<GrantedAuthority> auths=new ArrayList<>();
        Set<Authority> roleList=users.getAuthoritySet();
        for (Authority role:roleList){
            System.out.println(role.getName());
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(users.getUsername(),users.getPassword(),auths);
    }

}
