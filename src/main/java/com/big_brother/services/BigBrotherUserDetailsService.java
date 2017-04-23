package com.big_brother.services;

import com.big_brother.dao.GenericDAO;
import com.big_brother.dao.SystemUserDAO;
import com.big_brother.models.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denysburlakov on 23.04.17.
 */
@Service
@Transactional
public class BigBrotherUserDetailsService implements UserDetailsService {

    @Autowired
    private SystemUserDAO dao;
    //
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        SystemUser user = dao.getSystemUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "No user found with username: "+ login);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return  new org.springframework.security.core.userdetails.User
                (user.getLogin(),
                        user.getPassword(), enabled, accountNonExpired,
                        credentialsNonExpired, accountNonLocked,
                        authorities);
    }
}