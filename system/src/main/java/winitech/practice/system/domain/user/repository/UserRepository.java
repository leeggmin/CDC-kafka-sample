package winitech.practice.system.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import winitech.practice.system.domain.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
