package com.jvmless.mrsandwich.message.api;

import com.jvmless.mrsandwich.message.MessageFacade;
import com.jvmless.mrsandwich.message.MessageId;
import com.jvmless.mrsandwich.message.MessageRepository;
import com.jvmless.mrsandwich.message.dto.MessageView;
import com.jvmless.mrsandwich.notification.VendorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/message")
public class HttpMessageAdapter {

    @Autowired
    MessageFacade messageFacade;
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public MessageId createMessage(@RequestBody CreateMessage createMessage) {
        messageFacade.addNewMessage(createMessage);
        String id = createMessage.getMessageId();
        return MessageId.of(id);
    }

    @RequestMapping(path = "/all/{vendorId}", method = RequestMethod.GET)
    public List<MessageView> getAllMessages(@PathVariable(name = "vendorId") String vendorId) {
        return messageRepository.findAll(VendorId.of(vendorId))
                .stream()
                .map(x ->
                        new MessageView(
                                x.getMessageId().getId(),
                                x.getMessageBody(),
                                x.getAdded(),
                                x.getMessageStatus().name()
                        )).collect(Collectors.toList());
    }

}
