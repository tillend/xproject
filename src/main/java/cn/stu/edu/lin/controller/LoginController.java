package cn.stu.edu.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.common.RespCode;
import cn.stu.edu.lin.service.IUserService;
import cn.sut.edu.lin.annotation.IgnoreLogin;

@RestController
@RequestMapping("/")
public class LoginController {

	@Autowired
	private IUserService userService;

	@IgnoreLogin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Resp> userLogin() {
		ResponseEntity<Resp> responseEntity = null;

		try {
			// TODO check user
			responseEntity = Resp.createSuccess(null);
		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "login.fail", "登录失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Resp> userLogout() {
		ResponseEntity<Resp> responseEntity = null;

		try {
			// TODO LoginContext注销
		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "system.error", "系统错误");
		}

		return responseEntity;
	}

}