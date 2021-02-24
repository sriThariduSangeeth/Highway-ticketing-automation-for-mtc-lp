package com.sangeeth.hta.lphtacloudauthenticationservice.controller;

import com.sangeeth.hta.commons.models.user.JwtRequest;
import com.sangeeth.hta.commons.models.user.JwtResponse;
import com.sangeeth.hta.commons.models.user.UserObj;
import com.sangeeth.hta.lphtacloudauthenticationservice.services.UserService;
import com.sangeeth.hta.lphtacloudauthenticationservice.utils.JWTTokenUtility;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author dtsangeeth
 * @created 19 / 02 / 2021
 * @project lp-hta-cloud-authentication-service
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTTokenUtility jwtTokenUtility;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public ResponseEntity<String> home(){
        log.error(passwordEncoder.encode("test123"));
        return ResponseEntity.status(HttpStatus.OK).body(passwordEncoder.encode("test123").toString());
    }

    @GetMapping("/checkToken")
    public String checkToken(@AuthenticationPrincipal Jwt jwt){
        log.error(passwordEncoder.encode("test123"));
        return passwordEncoder.encode("test123").toString();
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
        try {
            userService.authenticate(jwtRequest.getUserName(), jwtRequest.getUserPassword());
        }catch (InternalAuthenticationServiceException e){
            log.error("Internal server error"+ e.getMessage());
            throw new Exception("Internal server error" , e);
        }
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUserName());
        final String token = jwtTokenUtility.generateToken(userDetails);
        return ResponseEntity.status(HttpStatus.OK).body(new JwtResponse(token,userDetails.getUsername(),""));
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserObj requser){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(requser));
        }catch (JpaSystemException jpe){
            log.error("DB insert error" +jpe);
            return ResponseEntity.
                    status(HttpStatus.UNAUTHORIZED).body("Invalid User Object or can not insert new user." );
        }
    }
}
