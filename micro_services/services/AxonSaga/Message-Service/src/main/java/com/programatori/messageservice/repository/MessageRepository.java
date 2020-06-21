package com.programatori.messageservice.repository;

import com.programatori.messageservice.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< Updated upstream
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByRequestId(Long requestId);
=======
public interface MessageRepository extends JpaRepository<Message, Long> {

>>>>>>> Stashed changes
}
