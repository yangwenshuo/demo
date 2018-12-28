package com.stt.service.impl;

import com.stt.mapper.UserMapper;
import com.stt.model.User;
import com.stt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;  //这里虽然会报错但是无所谓的

    @Override
    @Transactional
    public int insert(User record) {

        userMapper.insert(record);


        return 0;
    }

    @Override
    @Async
    public void testAsyn(){


        for (int i = 0;i<10;i++){

            logger.info("我是小弟啊");
        }
    }
}
