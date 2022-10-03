package ru.sber.sberchat.service;

import org.springframework.stereotype.Service;
import ru.sber.sberchat.model.Group;
import ru.sber.sberchat.model.User;
import ru.sber.sberchat.utils.RandomTypesEnum;

import java.sql.Timestamp;
import java.util.Date;

import static ru.sber.sberchat.utils.StringUtils.generateString;

@Service
public class GroupService {
    public Group createGroup(User user) {
        Group group = new Group();
        group.setUser(user);
        group.setTitle(generateString(RandomTypesEnum.LETTERS, 20));
        Timestamp date = new Timestamp(new Date().getTime());
        group.setCreated_at(date);
        return group;
    }
}
