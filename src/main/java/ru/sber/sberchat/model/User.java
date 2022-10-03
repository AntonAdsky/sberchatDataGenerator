package ru.sber.sberchat.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    @Column(unique = true)
    private String name;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "about_info")
    private String aboutInfo;
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Group group;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<GroupMember> groupMember;
}
