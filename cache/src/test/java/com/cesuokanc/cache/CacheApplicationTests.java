package com.cesuokanc.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CacheApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void testCaching(){
		String userId = "1";
		log.info("==>first call==>userInfo:{}", userService.getUserById(userId));
		log.info("==>second call==>userInfo:{}", userService.getUserById(userId));
	}

}
