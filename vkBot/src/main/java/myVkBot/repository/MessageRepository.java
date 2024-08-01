package myVkBot.repository;

import myVkBot.model.MessageDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageDTO ,Long> {
}
