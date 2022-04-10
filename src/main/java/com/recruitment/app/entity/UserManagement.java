package com.recruitment.app.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="User_Role_Management")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userId;

    private String emailId;

    private String userName;

    private String userRole;

    private String dmMailId;

    private String customers;

    private String managerEmailId;

    private String region;

    private String password;

    private String isFirstLogIn;
}
