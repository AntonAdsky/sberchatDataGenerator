package ru.sber.sberchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.sberchat.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findFirstByOrderById();
}
