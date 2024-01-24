package com.idea.pruebas.Service;

import com.idea.pruebas.entity.Message;
import com.idea.pruebas.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public interface MessageService {

    void newMessageCourse (Long courseId, @RequestBody Message message);

    void newMessageYear (Long yearId, @RequestBody Message message);

    void newMessageSchoolLevel (Long schoolLevelId, @RequestBody Message message);

    void newSchoolMessage(Long schoolId, @RequestBody Message message);

    void deleteMessage (Long id);
}
