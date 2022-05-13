package com.example.springjpaproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class UsersEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_no")
    private Integer userNo;

    @Column(name = "user_id", unique = true)
    private String userId;

    @Column(name = "user_name")
    private String userName;
}
