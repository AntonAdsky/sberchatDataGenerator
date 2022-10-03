package ru.sber.sberchat.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "group_members")
public class GroupMember {
    @EmbeddedId
    GroupMemberKey id = new GroupMemberKey();

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    Group group;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "invited_at")
    private Timestamp invitedAt;
    @Column(name = "is_admin")
    private boolean isAdmin;

}
