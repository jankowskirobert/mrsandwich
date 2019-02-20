package com.jvmless.mrsandwich.message.api;

import com.jvmless.mrsandwich.message.MessageFacade;
import com.jvmless.mrsandwich.message.MessageId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/message")
public class HttpMessageAdapter {

    @Autowired
    MessageFacade messageFacade;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public MessageId createMessage(@RequestBody CreateMessage createMessage){
        messageFacade.addNewMessage(createMessage);
        String id = createMessage.getMessageId();
        return MessageId.of(id);
    }

}
