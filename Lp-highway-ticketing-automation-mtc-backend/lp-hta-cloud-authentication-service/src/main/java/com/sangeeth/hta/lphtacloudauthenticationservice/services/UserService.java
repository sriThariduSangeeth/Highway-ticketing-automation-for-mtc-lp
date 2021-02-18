package com.sangeeth.hta.lphtacloudauthenticationservice.services;

import com.sangeeth.hta.commons.models.user.User;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

/**
 * @author dtsangeeth
 * @created 19 / 02 / 2021
 * @project lp-hta-cloud-authentication-service
 */
@Service
public interface UserService {

    User getUserById(int userId) throws JpaSystemException;
}
