package com.sangeeth.hta.lphtacloudauthenticationservice.services;


import com.sangeeth.hta.commons.models.user.UserObj;
import com.sangeeth.hta.lphtacloudauthenticationservice.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author dtsangeeth
 * @created 19 / 02 / 2021
 * @project lp-hta-cloud-authentication-service
 */
@Service
public class UserService implements UserDetailsService {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceRepository userServiceRepository;


    public void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserObj user = userServiceRepository.getUserByUserName(username);
        return new User(user.getUserName(),user.getUserPassword(),new ArrayList<>());
    }

    public Object addUser(UserObj requser) {
        return userServiceRepository.save(requser);
    }


//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//        //logic to get the user from the db
//        return new User("admin" , "test" , new ArrayList<>());
//    }
}
