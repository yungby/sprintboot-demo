package com.example.demo;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.web.dao.UserRepository;
import com.example.demo.web.entity.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	UserRepository userRepository;
	
	@Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
         
        userRepository.save(new User("aa1","aa123456","aa@126.com",  "aa",formattedDate));
        userRepository.save(new User("bb2", "bb123456","bb@126.com","bb", formattedDate));
        userRepository.save(new User("cc3", "cc123456","cc@126.com", "cc", formattedDate));
 
        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb2", "cc@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
	
}
