package winitech.practice.backup.userdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import winitech.practice.backup.userdata.domain.UserData;
import winitech.practice.backup.userdata.repository.UserDataRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDataService {

    private final UserDataRepository userDataRepository;

    public void save(UserData userData) {
        userDataRepository.save(userData);
    }

    public void update(UserData userData) {
        userDataRepository.save(userData);
    }

    public void delete(UserData userData) {
        userDataRepository.delete(userData);
    }
}
