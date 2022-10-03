package ru.sber.sberchat.service;

import org.springframework.stereotype.Service;
import ru.sber.sberchat.model.Group;
import ru.sber.sberchat.model.GroupMember;
import ru.sber.sberchat.model.User;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class GroupMemberService {
    public GroupMember createGroupMember(User user, Group group) {
        GroupMember groupMember = new GroupMember();
        groupMember.setAdmin(true);
        Timestamp date = new Timestamp(new Date().getTime());
        groupMember.setInvitedAt(date);
        groupMember.setGroup(group);
        groupMember.setUser(user);
        return groupMember;
    }
}
