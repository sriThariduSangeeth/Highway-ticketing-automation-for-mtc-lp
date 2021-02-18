package com.sangeeth.hta.lphtacloudauthenticationservice.services;


import com.sangeeth.hta.commons.models.user.User;
import com.sangeeth.hta.lphtacloudauthenticationservice.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dtsangeeth
 * @created 19 / 02 / 2021
 * @project lp-hta-cloud-authentication-service
 */
@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserServiceRepository userServiceRepository;


    @Override
    public User getUserById(int userId) throws JpaSystemException {
        return userServiceRepository.getUserByUserId(userId);
    }

//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        return userServiceRepository.getUserByUserName(name);
//    }
}
