package com.sangeeth.hta.lphtacloudauthenticationservice.repository;

import com.sangeeth.hta.commons.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dtsangeeth
 * @created 19 / 02 / 2021
 * @project lp-hta-cloud-authentication-service
 */
public interface UserServiceRepository extends JpaRepository<User, Integer> {

    User getUserByUserId(int userId);
    User getUserByUserName(String userName);
}
