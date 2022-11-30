package com.tulun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



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
            // 直接使用  sl4j的log对象 ，实际上会转成log4j2日志进行输出。
            String out = "test1111";
            log.info("idass:{}", out); //占位符
            log.error("idass:{}", out);
            log.warn("idass:{}", out);
        }


//        import java.util.logging.Logger;
//    @Test
//    public void testLogger() throws Exception {
//    // 使用java的logger类
//         String name = testLog.class.getName();
//         Logger log = Logger.getLogger(name);// <= (2)
//        log.info("hello  logger");
//    }


    @Test
    public void testLog4j() throws Exception {
        Logger logger = LogManager.getLogger(this.getClass());
        logger.error("Something else is wrong here");
        logger.info("Something else is wrong here");
        logger.warn("Something else is wrong here");

    }


}
