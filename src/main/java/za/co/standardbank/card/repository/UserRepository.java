package za.co.standardbank.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.standardbank.card.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
