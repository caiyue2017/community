package com.whynotyue.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTests {
    private Logger logger = LoggerFactory.getLogger(LoggerTests.class);

    @Test
    public void test() {
        System.out.println(logger.getName());

        logger.debug("debug string");
        logger.info("info string");
        logger.warn("warn string");
        logger.error("error string");
    }
}
