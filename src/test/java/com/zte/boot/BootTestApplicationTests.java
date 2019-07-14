package com.zte.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootTestApplicationTests {
	
	Logger logger = LoggerFactory.getLogger(BootTestApplicationTests.class);

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testLogger() {
		logger.trace("trace*****");
		logger.debug("debug***");
		logger.info("info******");
		logger.warn("warn******");
		logger.error("error*****");
	}

}
