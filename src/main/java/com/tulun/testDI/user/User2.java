package com.tulun.testDI.user;

import org.springframework.stereotype.Service;

/**
 * @author QiangQin
 * * @date 2023/1/7
 */
@Service
public class User2 implements IUser{
    @Override
    public void say() {
        System.out.println("User2");
    }
}
