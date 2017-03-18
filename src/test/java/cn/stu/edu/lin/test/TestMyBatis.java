package cn.stu.edu.lin.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import cn.stu.edu.lin.model.User;
import cn.stu.edu.lin.service.IUserService;

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);

	@Autowired
	private IUserService userService;

	@Test
	public void test1() {
		if (userService == null) {
			System.out.println("aaa");
		}

		User user = userService.getUserById(1);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
}
