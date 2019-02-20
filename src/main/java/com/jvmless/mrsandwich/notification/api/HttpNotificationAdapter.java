package com.jvmless.mrsandwich.notification.api;

import com.jvmless.mrsandwich.message.MessageNotFoundException;
import com.jvmless.mrsandwich.notification.NotificationId;
import com.jvmless.mrsandwich.notification.application.NotifyClients;
import com.jvmless.mrsandwich.notification.application.NotifyClientsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/notification")
public class HttpNotificationAdapter {

    @Autowired
    NotifyClientsHandler handler;

    @RequestMapping(path = "/send", method = RequestMethod.POST)
    public NotificationId notifyClient(@RequestBody NotifyClients notifyClients){
        handler.handle(notifyClients);
        return notifyClients.getNotificationId();
    }

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<Object> conflict() {
        return ResponseEntity.badRequest().body("Cannot find message with given id");
    }

}
