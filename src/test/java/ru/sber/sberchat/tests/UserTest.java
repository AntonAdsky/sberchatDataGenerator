package ru.sber.sberchat.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sber.sberchat.repository.UserRepository;

@SpringBootTest
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Value("${params.users}")
    int usersCount;

    @Test
    public void CheckUserCounts() {
        assert userRepository.count() == usersCount;
    }
}
