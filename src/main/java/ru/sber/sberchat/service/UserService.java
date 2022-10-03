package ru.sber.sberchat.service;

import org.springframework.stereotype.Service;
import ru.sber.sberchat.model.User;
import ru.sber.sberchat.utils.RandomTypesEnum;

import java.sql.Timestamp;
import java.util.Date;

import static ru.sber.sberchat.utils.StringUtils.generateString;

@Service
public class UserService {

    public User createUser() {
        User user = new User();
        user.setUsername(generateString(RandomTypesEnum.LETTERS, 15));
        user.setName(generateString(RandomTypesEnum.LETTERS, 10));
        Timestamp date = new Timestamp(new Date().getTime());
        user.setCreatedAt(date);
        user.setAboutInfo(generateString(RandomTypesEnum.LETTERS, 20));
        user.setEmail(generateString(RandomTypesEnum.LETTERS, 10) + "@mail.ru");
        return user;
    }
}
