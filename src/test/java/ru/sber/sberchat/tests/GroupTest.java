package ru.sber.sberchat.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sber.sberchat.repository.GroupRepository;

@SpringBootTest
public class GroupTest {
    @Autowired
    GroupRepository groupRepository;

    @Value("${params.groups}")
    int groupCount;

    @Test
    public void CheckGroupCounts() {
        assert groupRepository.count() == groupCount;
    }
}
