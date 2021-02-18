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
@Table(name = "User")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userEmail;
    private String userNIC;
    private String userPassword;


}
