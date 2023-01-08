package com.tulun.testDI.user;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author QiangQin
 * * @date 2023/1/7
 */
@Service
//@Primary
@Primary
public class User1 implements IUser{

    @Override
    public void say() {
        System.out.println("User1");
    }
}
