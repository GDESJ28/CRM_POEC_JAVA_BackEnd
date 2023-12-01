package com.Certif.SlackLike;

import com.Certif.SlackLike.model.User;
import com.Certif.SlackLike.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void testAddUser(){

        User user = new User("Jean Claude","Dusse","JCD",0);
        userRepository.save(user);
    }

}
