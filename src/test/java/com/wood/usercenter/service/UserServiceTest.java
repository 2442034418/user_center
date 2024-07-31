package com.wood.usercenter.service;

import com.wood.usercenter.mapper.UserMapper;
import com.wood.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 用户服务测试
 *
 * @author wood
 */
@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("mafeifei");
        user.setUserAccount("4444");
        user.setAvatarUrl("https://img1.baidu.com/it/u=2064141728,1887086141&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=800");
        user.setGender(0);
        user.setUserPassword("1234");
        user.setPhone("18728182997");
        user.setEmail("dahdi@qq.com");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "zhuzhupi";
        String userPassword = "";
        String checkPassword = "1234678";
        String planetCode = "222";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "zhu";
        userPassword = "12345678";
        checkPassword = "12345678";
        planetCode = "222";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "zhuzhupi";
        userPassword = "123456";
        checkPassword = "123456";
        planetCode = "222";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "zhuzhupi-+";
        userPassword = "12345678";
        checkPassword = "12345678";
        planetCode = "222";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "zhuzhupi";
        userPassword = "12345678";
        checkPassword = "123456789";
        planetCode = "222";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "zhuzhupi";
        userPassword = "12345678";
        checkPassword = "12345678";
        planetCode = "111";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "feifeiyu";
        userPassword = "12345678";
        checkPassword = "12345678";
        planetCode = "222";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

//        userAccount = "zhuzhupi";
//        userPassword = "12345678";
//        checkPassword = "12345678";
//        planetCode = "222";
//        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
//        Assertions.assertEquals(-1, result);
    }
}