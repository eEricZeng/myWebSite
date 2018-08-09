package site.zengguang.home.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import site.zengguang.home.data.User;

public class IUserServiceTest extends SpringTestCase {

    @Autowired  
    private IUserService userService; 

    @Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(1);  
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }  

}
