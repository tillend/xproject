package cn.stu.edu.lin.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.common.RespCode;
import cn.stu.edu.lin.service.IUserService;
import cn.stu.edu.lin.util.ServletUtils;
import cn.sut.edu.lin.annotation.IgnoreLogin;

@RestController
@RequestMapping("/")
public class LoginController extends AbstractController {

	@Autowired
	private IUserService userService;

	@IgnoreLogin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Resp> userLogin(HttpServletResponse response) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			// TODO check user
			String userId = "1";

			ServletUtils.setCookie(request, response, "userId", userId);

			responseEntity = Resp.createSuccess(null);
		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "login.fail", "登录失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Resp> userLogout(HttpServletResponse response) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			ServletUtils.deleteCookie(request, response, "userId");

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "system.error", "系统错误");
		}

		return responseEntity;
	}

}