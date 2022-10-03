package ru.sber.sberchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.sberchat.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByOrderById();
}
