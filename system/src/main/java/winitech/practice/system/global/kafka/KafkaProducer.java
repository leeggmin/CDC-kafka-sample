package winitech.practice.system.global.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import winitech.practice.system.domain.user.domain.User;

@Log4j2
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    @Value(value = "${message.topic.create}")
    private String createUserTopic;
    @Value(value = "${message.topic.update}")
    private String updateUserTopic;
    @Value(value = "${message.topic.delete}")
    private String deleteUserTopic;

    private final KafkaTemplate<String, User> userKafkaTemplate;

    public void createUser(User user) {
        log.info(createUserTopic + " >> " + user.toString());
        userKafkaTemplate.send(createUserTopic, user);
    }

    public void updateUser(User user) {
        log.info(updateUserTopic + " >> " + user.toString());
        userKafkaTemplate.send(updateUserTopic, user);
    }

    public void deleteUser(User user) {
        log.info(deleteUserTopic + " >> " + user.toString());
        userKafkaTemplate.send(deleteUserTopic, user);
    }
}
