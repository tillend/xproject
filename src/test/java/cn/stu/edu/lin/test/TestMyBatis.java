package cn.stu.edu.lin.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.stu.edu.lin.model.User;
import cn.stu.edu.lin.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);

	@Autowired
	private UserService userService;

	@Test
	public void test1() {

		try {
			User user = userService.getUserById(1);
			logger.info(JSON.toJSONString(user));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}
}
