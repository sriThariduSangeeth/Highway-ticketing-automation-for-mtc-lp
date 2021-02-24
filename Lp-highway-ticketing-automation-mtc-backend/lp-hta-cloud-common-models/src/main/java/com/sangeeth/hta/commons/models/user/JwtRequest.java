package com.sangeeth.hta.commons.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dtsangeeth
 * @created 19 / 02 / 2021
 * @project lp-hta-cloud-common-models
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

    private String userName;
    private String userPassword;
}
