package ru.sber.sberchat.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity(name = "groups")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User user;
    private String title;
    private Timestamp created_at;

    @OneToMany(mappedBy = "group")
    private Set<GroupMember> groupMember;
}
