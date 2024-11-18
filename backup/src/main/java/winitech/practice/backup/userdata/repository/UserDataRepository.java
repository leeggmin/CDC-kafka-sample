package winitech.practice.backup.userdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import winitech.practice.backup.userdata.domain.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
}
