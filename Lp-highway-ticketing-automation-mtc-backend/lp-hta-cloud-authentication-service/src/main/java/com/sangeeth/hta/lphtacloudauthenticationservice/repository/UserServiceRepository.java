package com.sangeeth.hta.lphtacloudauthenticationservice.repository;

import com.sangeeth.hta.commons.models.user.UserObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaSystemException;

/**
 * @author dtsangeeth
 * @created 19 / 02 / 2021
 * @project lp-hta-cloud-authentication-service
 */
public interface UserServiceRepository extends JpaRepository<UserObj, Integer> {

    UserObj getUserByUserId(int userId);
    UserObj getUserByUserName(String userName);
    UserObj getUserByUserEmail(String userEmail);
    UserObj save(UserObj user) throws JpaSystemException;
}
