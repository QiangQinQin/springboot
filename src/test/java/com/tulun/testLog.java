package com.tulun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

/**
 * @author QiangQin
 * * @date 2022/11/19
 */

//@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {"classpath:Application.yml"})
//@SpringBootTest(classes = HelloApplication.class)
@Slf4j
public class testLog {
        @Test
        public void testLog() throws Exception {
            String out = "test1111";
            log.info("idass:{}", out);
            log.error("idass:{}", out);
            log.warn("idass:{}", out);
        }


    @Test
    public void testLogger() throws Exception {
         String name = testLog.class.getName();
         Logger log = Logger.getLogger(name);// <= (2)
        log.info("hello  logger");
    }

}
