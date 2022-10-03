package ru.sber.sberchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import ru.sber.sberchat.model.Group;
import ru.sber.sberchat.model.GroupMember;
import ru.sber.sberchat.model.User;
import ru.sber.sberchat.repository.GroupMemberRepository;
import ru.sber.sberchat.repository.GroupRepository;
import ru.sber.sberchat.repository.UserRepository;
import ru.sber.sberchat.service.GroupMemberService;
import ru.sber.sberchat.service.GroupService;
import ru.sber.sberchat.service.UserService;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    GroupMemberRepository groupMemberRepository;
    @Autowired
    UserService userService;
    @Autowired
    GroupService groupService;
    @Autowired
    GroupMemberService groupMemberService;

    @Value("${params.users}")
    int usersCount;

    @Bean
    public void run() {
        for (int i = 0; i < usersCount; i++) {
            UC1_generateUsers();
        }
        UC2_generateGroupForEveryUser();
        UC3_generateGroupMembersForGroup();
    }


    public void UC1_generateUsers() {
        userRepository.save(userService.createUser());
    }

    public void UC2_generateGroupForEveryUser() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            groupRepository.save(groupService.createGroup(user));
        }
    }

    public void UC3_generateGroupMembersForGroup() {
        List<User> users = userRepository.findAll();
        List<Group> groups = groupRepository.findAll();
        for (Group group : groups) {
            for (User user : users) {
                GroupMember groupMember = groupMemberService.createGroupMember(user, group);
                groupMemberRepository.save(groupMember);
            }
        }

    }
}
