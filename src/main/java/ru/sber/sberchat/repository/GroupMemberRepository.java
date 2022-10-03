package ru.sber.sberchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.sberchat.model.Group;
import ru.sber.sberchat.model.GroupMember;
import ru.sber.sberchat.model.User;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    GroupMember findFirstByOrderById();
    List<GroupMember> findGroupMembersByGroup(Group group);
}
