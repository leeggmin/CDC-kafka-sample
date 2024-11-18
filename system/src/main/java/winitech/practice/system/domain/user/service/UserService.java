package winitech.practice.system.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import winitech.practice.system.domain.user.domain.User;
import winitech.practice.system.domain.user.dto.UserReq;
import winitech.practice.system.domain.user.repository.UserRepository;
import winitech.practice.system.global.kafka.KafkaProducer;

import java.util.Objects;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@DynamicUpdate
public class UserService {

    private final UserRepository userRepository;
    private final KafkaProducer kafkaProducer;

    @Transactional
    public void generate(UserReq userReq) {
        User user = userRepository.save(userReq.toEntity());
        kafkaProducer.createUser(user);
    }

    @Transactional
    public void update(long id, UserReq userReq) {
        User user = findById(id);
        user.update(
            Objects.nonNull(userReq.getName()) ? userReq.getName() : user.getName(),
            Objects.nonNull(userReq.getPhone()) ? userReq.getPhone() : user.getPhone(),
                (user.getAge() != userReq.getAge()) && (userReq.getAge() != 0) ? userReq.getAge() : user.getAge()
        );
        kafkaProducer.updateUser(user);
    }

    @Transactional
    public void delete(long id) {
        User user = findById(id);
        userRepository.delete(user);
        kafkaProducer.deleteUser(user);
    }

    private User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
