package com.coder.es_house.entity;

import com.coder.es_house.ApplicationTests;
import com.coder.es_house.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:apple
 * @date: 2019/2/5
 * @time: 上午2:40
 */
public class UserRepositoryTest extends ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne(){
        User user = userRepository.findOne(1L);
        Assert.assertEquals("zhaojx",user.getName());
    }
}
