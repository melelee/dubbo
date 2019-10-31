package com.melelee.dubbo.provider.service.impl;

import com.melelee.dubbo.common.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Override
	public void saveUser(String user) {
		log.info("provider save user {}", user);
	}
}
