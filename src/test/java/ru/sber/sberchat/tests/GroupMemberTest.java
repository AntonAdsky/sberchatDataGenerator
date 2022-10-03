package ru.sber.sberchat.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sber.sberchat.model.GroupMember;
import ru.sber.sberchat.repository.GroupMemberRepository;
import ru.sber.sberchat.repository.GroupRepository;

import java.util.List;

@SpringBootTest
public class GroupMemberTest {
    @Autowired
    GroupMemberRepository groupMemberRepository;
    @Autowired
    GroupRepository groupRepository;

    @Value("${params.groupsMembers}")
    long groupMemberCount;

    @Test
    public void CheckGroupCounts() {
        assert groupMemberRepository.count() == Math.pow(groupMemberCount, 2);
    }

    @Test
    public void CheckUserCountInOneGroup() {
        assert groupMemberRepository.findGroupMembersByGroup(
                groupRepository.findFirstByOrderById()
        ).size() == groupMemberCount;

    }
}
