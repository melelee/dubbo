package com.melelee.dubbo.consumer.service;

import com.melelee.dubbo.common.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by melelee
 * @date 2020/3/13 16:27
 */
@Slf4j
@RestController
public class TestService {
    @Reference(
            //多版本
            version = "1.0.0",
            //启动检查
            check = true,
            //本地存根
            stub = "com.melelee.dubbo.consumer.service",
            //服务降级
            mock = "fail:return+null",
            //集群容错failover/failfast/failsafe/failback/forking/broadcast
            cluster = "failover"
    )
    private UserService userService;

    @GetMapping(value = "user")
    public String test(@RequestParam String user) {
        return userService.saveUser(user);
    }

    public TestService() {
        System.out.println(TestService.log);
    }
}
