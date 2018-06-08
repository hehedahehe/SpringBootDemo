package com.cesuokanc.druid;

import com.cesuokanc.druid.mapper.UserMapper;
import com.cesuokanc.druid.mdo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new User("aa", 12, new Date()));
		userMapper.insert(new User("bb", 14, new Date()));
		userMapper.insert(new User("cc", 411, new Date()));
		Assert.assertEquals(3, userMapper.findAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = userMapper.findAll();
		System.out.println(users.toString());
	}

	@Test
	public void testUpdate() throws Exception {
		User user = userMapper.findById(3);
		System.out.println(user.toString());
	}

}
