package cn.stu.edu.lin.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.common.RespCode;
import cn.stu.edu.lin.model.Room;
import cn.stu.edu.lin.model.User;
import cn.stu.edu.lin.model.UserIntegral;
import cn.stu.edu.lin.model.UserStar;
import cn.stu.edu.lin.service.RoomService;
import cn.stu.edu.lin.service.UserIntegralService;
import cn.stu.edu.lin.service.UserService;
import cn.stu.edu.lin.service.UserStarService;
import cn.stu.edu.lin.vo.RoomMsg;
import cn.stu.edu.lin.vo.req.StarReqVO;
import cn.stu.edu.lin.vo.req.UpdateUserInfoReqVO;
import cn.stu.edu.lin.vo.resp.CommonRespVO;
import cn.stu.edu.lin.vo.resp.UserAllInfoRespVO;
import cn.stu.edu.lin.vo.resp.UserBasicInfoRespVO;
import cn.stu.edu.lin.vo.resp.UserIntegralInfoRespVO;
import cn.stu.edu.lin.vo.resp.UserStarInfoRespVO;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserStarService userStarService;

	@Autowired
	private UserIntegralService userIntegralService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private Mapper beanMapper;

	@RequestMapping(value = "/getUserBasicInfo", method = RequestMethod.GET)
	public ResponseEntity<Resp> getUserBasicInfo() {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int userId = getUserId();
			User user = userService.getUserById(userId);

			// 设置返回参数
			UserBasicInfoRespVO vo = beanMapper.map(user, UserBasicInfoRespVO.class);

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.1000", "获取用户信息失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/getUserStarInfo", method = RequestMethod.GET)
	public ResponseEntity<Resp> getUserStarInfo() {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int userId = getUserId();
			List<UserStar> roomList = userStarService.getUserAllStar(userId);

			List<RoomMsg> roomMsgs = new ArrayList<>();
			for (UserStar userStar : roomList) {
				RoomMsg roomMsg = new RoomMsg();

				int roomNum = userStar.getRoomnum();
				Room room = roomService.getRoom(roomNum);

				roomMsg = beanMapper.map(room, RoomMsg.class);

				roomMsgs.add(roomMsg);
			}

			// 设置返回参数
			UserStarInfoRespVO vo = new UserStarInfoRespVO();
			vo.setRoomList(roomMsgs);

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.1000", "处理失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/getUserPointInfo", method = RequestMethod.GET)
	public ResponseEntity<Resp> getUserPointInfo() {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int userId = getUserId();
			UserIntegral userIntegral = userIntegralService.getUserIntegral(userId);

			// 设置返回参数
			UserIntegralInfoRespVO vo = beanMapper.map(userIntegral, UserIntegralInfoRespVO.class);

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.1000", "处理失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/getUserAllInfo", method = RequestMethod.GET)
	public ResponseEntity<Resp> getUserAllInfo() {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int userId = getUserId();
			User user = userService.getUserById(userId);
			UserIntegral userIntegral = userIntegralService.getUserIntegral(userId);
			List<UserStar> roomList = userStarService.getUserAllStar(userId);

			// 设置返回参数
			UserAllInfoRespVO vo = new UserAllInfoRespVO();
			vo = beanMapper.map(user, UserAllInfoRespVO.class);
			vo = beanMapper.map(userIntegral, UserAllInfoRespVO.class);

			List<RoomMsg> roomMsgs = new ArrayList<>();
			for (UserStar userStar : roomList) {
				RoomMsg roomMsg = new RoomMsg();

				int roomNum = userStar.getRoomnum();
				Room room = roomService.getRoom(roomNum);

				roomMsg = beanMapper.map(room, RoomMsg.class);

				roomMsgs.add(roomMsg);
			}
			vo.setRoomList(roomMsgs);

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.1000", "处理失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	public ResponseEntity<Resp> updateUserInfo(@RequestBody UpdateUserInfoReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int userId = getUserId();

			User user = beanMapper.map(reqVO, User.class);
			user.setUserid(userId);
			int result = userService.updateUserInfo(user);

			// 设置返回参数
			CommonRespVO vo = new CommonRespVO();
			vo.setResult(result);

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.1000", "处理失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/star", method = RequestMethod.POST)
	public ResponseEntity<Resp> star(@RequestBody StarReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int userId = getUserId();

			UserStar userStar = beanMapper.map(reqVO, UserStar.class);
			userStar.setUserid(userId);
			int result = userStarService.updateUserStar(userStar);

			// 设置返回参数
			CommonRespVO vo = new CommonRespVO();
			vo.setResult(result);

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.1000", "处理失败");
		}

		return responseEntity;
	}
}