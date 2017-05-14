package cn.stu.edu.lin.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.common.RespCode;
import cn.stu.edu.lin.model.User;
import cn.stu.edu.lin.service.UserService;
import cn.stu.edu.lin.vo.req.RegisterReqVO;
import cn.stu.edu.lin.vo.req.ResetPasswordReqVO;
import cn.stu.edu.lin.vo.resp.CommonRespVO;
import cn.sut.edu.lin.annotation.IgnoreLogin;

@RestController
@RequestMapping("/user")
public class PassController extends AbstractController {

	@Autowired
	private UserService userService;

	@Autowired
	private Mapper beanMapper;

	@IgnoreLogin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Resp> register(@RequestBody RegisterReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			String password = reqVO.getPassword();
			String password2 = reqVO.getPassword2();

			if (!password.equals(password2)) {
				return Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "两次密码不一致");
			}

			User user = new User();
			user.setUsername(reqVO.getUserName());
			user.setPassword(reqVO.getPassword());
			int result = userService.insertUser(user);

			CommonRespVO vo = new CommonRespVO();
			vo.setResult(result);

			responseEntity = Resp.createSuccess(vo);
		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "服务失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ResponseEntity<Resp> userLogout(@RequestBody ResetPasswordReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			String oldpassword = reqVO.getOldpassword();

			int userId = getUserId();
			User user = userService.getUserById(userId);
			if (!oldpassword.equals(user.getPassword())) {
				return Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "密码错误");
			}

			// 校检两次输入的密码
			String password = reqVO.getNewpassword();
			String password2 = reqVO.getNewpassword2();

			if (!password.equals(password2)) {
				return Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "两次密码不一致");
			}

			User record = new User();
			user.setPassword(reqVO.getNewpassword());

			int result = userService.insertUser(record);

			CommonRespVO vo = new CommonRespVO();
			vo.setResult(result);

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "system.error", "系统错误");
		}

		return responseEntity;
	}

}