package com.sangeeth.hta.commons.models.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author dtsangeeth
 * @created 19 / 02 / 2021
 * @project lp-hta-cloud-common-models
 */
@Entity
@Table(name = "user")
@NoArgsConstructor
@Data
public class UserObj {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userEmail;
    private String userNIC;
    private String userPassword;


    public UserObj(String userName, String userEmail, String userNIC, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNIC = userNIC;
        this.userPassword = userPassword;
    }
}
