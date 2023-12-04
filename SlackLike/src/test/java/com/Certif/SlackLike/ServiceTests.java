package com.Certif.SlackLike;

import com.Certif.SlackLike.model.Channel;
import com.Certif.SlackLike.model.Message;
import com.Certif.SlackLike.model.User;
import com.Certif.SlackLike.repository.ChannelRepository;
import com.Certif.SlackLike.repository.MessageRepository;
import com.Certif.SlackLike.repository.UserRepository;
import com.Certif.SlackLike.service.ChannelService;
import com.Certif.SlackLike.service.MessageService;
import com.Certif.SlackLike.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class ServiceTests {

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Autowired
    ChannelService channelService;

    @Test
    void testCreateUser() {

        User user = new User("Alain", "Delon", "BORSALINO", 1);
        userService.createUser(user);


    }

    @Test
    void  testCreateChannel(){

        Channel channel = new Channel("Canal2",LocalDateTime.now(),1);
        channelService.createChannel(channel);

    }

    @Test
    void testCreateMessage(){
        Optional<User> users1 = userService.getUserById(3);
        Optional<Channel> channel1 = channelService.getChannelById(2);

        if ( channel1.isPresent() && users1.isPresent() ){
           User util1 = users1.get()  ;
            Channel canal1 = channel1.get();
            Message message = new Message("test message", LocalDateTime.now(),util1,canal1,1);
            messageService.createMessage(message);
        }



    }


}
