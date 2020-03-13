package com.melelee.dubbo.provider.service.impl;

import com.melelee.dubbo.common.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author melelee
 */
@Slf4j
@Service(version = "1.0.0", timeout = 10000, interfaceClass = UserService.class,weight = 1)
public class UserServiceImpl implements UserService {
    @Override
    public String saveUser(String user) {
        log.info("provider save user {}", user);
        return user + "success";
    }
}
