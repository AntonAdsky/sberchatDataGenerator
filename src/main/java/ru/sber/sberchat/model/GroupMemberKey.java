package ru.sber.sberchat.model;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Generated
public class GroupMemberKey implements Serializable {
    @Column(name = "group_id")
    Long groupId;

    @Column(name = "user_id")
    Long userId;
}
