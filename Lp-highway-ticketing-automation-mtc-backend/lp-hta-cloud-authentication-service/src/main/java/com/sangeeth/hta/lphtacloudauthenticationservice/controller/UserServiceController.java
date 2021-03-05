package com.sangeeth.hta.lphtacloudauthenticationservice.controller;

import com.google.gson.Gson;
import com.sangeeth.hta.commons.models.driver.Driver;
import com.sangeeth.hta.commons.models.driver.DriverReqest;
import com.sangeeth.hta.commons.models.user.JwtRequest;
import com.sangeeth.hta.commons.models.user.JwtResponse;
import com.sangeeth.hta.commons.models.user.UserObj;
import com.sangeeth.hta.lphtacloudauthenticationservice.services.UserService;
import com.sangeeth.hta.lphtacloudauthenticationservice.utils.ByteConverter;
import com.sangeeth.hta.lphtacloudauthenticationservice.utils.JWTTokenUtility;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.sangeeth.hta.lphtacloudauthenticationservice.utils.Constants.DRIVER_SERVICE_BASE_URL;

/**
 * @author dtsangeeth
 * @created 19 / 02 / 2021
 * @project lp-hta-cloud-authentication-service
 */
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTTokenUtility jwtTokenUtility;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${"+DRIVER_SERVICE_BASE_URL+"}")
    private String driverBaseurl;


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

    @PostMapping("/counter")
    public ResponseEntity<?> addUser(@RequestBody UserObj requser){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(requser));
        }catch (JpaSystemException jpe){
            log.error("DB insert error" +jpe);
            return ResponseEntity.
                    status(HttpStatus.UNAUTHORIZED).body("Invalid User Object or can not insert new user." );
        }
    }

    @PostMapping("/driver")
    public ResponseEntity<?> addDriver(@RequestParam ("profileImg") MultipartFile driverpro , @RequestParam ("driver") String driverfiles){
        try {
            DriverReqest driverReqest = new Gson().fromJson(driverfiles, DriverReqest.class);
            userService.addUser(new UserObj(driverReqest.getDriverName(),driverReqest.getDriverEmail(),driverReqest.getDriverNIC(),driverReqest.getPassword()));
            ResponseEntity<?> resa = restTemplate.postForEntity(new URI(driverBaseurl+"/driver"),new Driver(driverReqest.getDriverName(),
                    driverReqest.getDriverNIC(),driverReqest.getDriverEmail(),driverReqest.getDriverAddress(),driverReqest.getDriverBloodGroup(),
                    driverReqest.getDriverGender(),driverReqest.getDriverLicenceId(),driverReqest.getPassword(),
                    driverpro.getOriginalFilename(),driverpro.getContentType(), ByteConverter.compressBytes(driverpro.getBytes())),String.class);

            return resa;
        }catch (JpaSystemException jpe){
            log.error("DB insert error" +jpe);
            return ResponseEntity.
                    status(HttpStatus.UNAUTHORIZED).body("Invalid User Object or can not insert new user." );
        }catch (URISyntaxException e) {
            log.error("URL Convert error" +e);
            return ResponseEntity.
                    status(HttpStatus.UNAUTHORIZED).body("Invalid User Object or can not insert new user." );
        } catch (IOException e) {
            log.error("URL Convert error" +e);
            return ResponseEntity.
                    status(HttpStatus.UNAUTHORIZED).body("Invalid User Object or can not insert new user." );
        }
    }
}
