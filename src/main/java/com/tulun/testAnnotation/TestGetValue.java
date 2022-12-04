package com.tulun.testAnnotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author QiangQin
 * * @date 2022/12/3
 */
@Component   //一定要有
@Data
public class TestGetValue {
    @Value("${test.key}")
    private String testKey;


    public String getTestKey() {
        return testKey;
    }

    public void setTestKey(String testKey) {
        this.testKey = testKey;
    }
}
