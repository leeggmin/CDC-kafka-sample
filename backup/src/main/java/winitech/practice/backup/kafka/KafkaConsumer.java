package winitech.practice.backup.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import winitech.practice.backup.userdata.domain.UserData;
import winitech.practice.backup.userdata.service.UserDataService;

@Log4j2
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final UserDataService userDataService;

    @KafkaListener(topics = "${message.topic.create}", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void createConsume(@Payload UserData userData) {
        log.info("출근 createUser 수행예정! data >> " + userData.toString());
        userDataService.save(userData);
        log.info("퇴근 createUser 수행완료!");
    }

    @KafkaListener(topics = "${message.topic.update}", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void updateConsume(@Payload UserData userData) {
        log.info("출근 updateUser 수행예정! data >> " + userData.toString());
        userDataService.update(userData);
        log.info("퇴근 updateUser 수행완료!");
    }

    @KafkaListener(topics = "${message.topic.delete}", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void deleteConsume(@Payload UserData userData) {
        log.info("출근 deleteUser 수행예정! data >> " + userData.toString());
        userDataService.delete(userData);
        log.info("퇴근 deleteUser 수행완료!");
    }
}
