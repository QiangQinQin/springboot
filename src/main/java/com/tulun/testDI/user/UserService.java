package com.tulun.testDI.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author QiangQin
 * * @date 2023/1/7
 */
@Service
public class UserService {
    /*
    Description:

Field user in com.tulun.testDI.user.UserService required a single bean, but 2 were found:
	 user1、user2


Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
     */
    @Autowired
    private  IUser user;

}
