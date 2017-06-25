package com.microblog.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Log4J2ExampleTest {
	@Test
	public void performSomeTask() throws Exception {
		Log4J2Example example = new Log4J2Example();
		example.performSomeTask();
	}
}