package com.cesuokanc.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class ShiroApplicationTests {

	@Test
	public void testMD5(){
        String password = "123456";
        String initUserName = "123132";
	    Md5Hash md5Hash = new Md5Hash(password, initUserName);
        System.out.println(md5Hash.toHex());
    }

}
