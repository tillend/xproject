package cn.stu.edu.lin.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.common.RespCode;
import cn.stu.edu.lin.model.User;
import cn.stu.edu.lin.service.UserService;
import cn.stu.edu.lin.util.ServletUtils;
import cn.stu.edu.lin.vo.req.LoginReqVO;
import cn.stu.edu.lin.vo.resp.LoginRespVO;
import cn.stu.edu.lin.vo.resp.LogoutRespVO;
import cn.sut.edu.lin.annotation.IgnoreLogin;

@RestController
@RequestMapping("/")
public class LoginController extends AbstractController {

	@Autowired
	private UserService userService;

	@IgnoreLogin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Resp> userLogin(HttpServletResponse response, LoginReqVO userVO) {
		ResponseEntity<Resp> responseEntity = null;
		LoginRespVO respVO = new LoginRespVO();

		try {
			// 校检用户
			int userId = userVO.getUserId();
			String password = userVO.getPassword();
			boolean result = userService.checkUser(userId, password);

			if (result) {
				ServletUtils.setCookie(request, response, "uid", String.valueOf(userId));

				respVO.setResult("1");

				// 若是主播,设置aid的cookie
				User user = userService.getUserById(userId);
				Integer anchorId = user.getAnchorid();
				if (null != anchorId && !anchorId.equals(0)) {
					ServletUtils.setCookie(request, response, "aid", String.valueOf(anchorId));
				}

			} else {
				respVO.setResult("0");
			}

			responseEntity = Resp.createSuccess(respVO);
		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "login.fail", "登录失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Resp> userLogout(HttpServletResponse response) {
		ResponseEntity<Resp> responseEntity = null;
		LogoutRespVO respVO = new LogoutRespVO();

		try {
			ServletUtils.deleteCookie(request, response, "uid");

			respVO.setResult("1");

			responseEntity = Resp.createSuccess(respVO);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "system.error", "系统错误");
		}

		return responseEntity;
	}

}