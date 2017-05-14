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
import cn.stu.edu.lin.model.Anchor;
import cn.stu.edu.lin.model.Room;
import cn.stu.edu.lin.service.AnchorService;
import cn.stu.edu.lin.service.RoomService;
import cn.stu.edu.lin.vo.req.NewRoomReqVO;
import cn.stu.edu.lin.vo.req.RoomInfoReqVO;
import cn.stu.edu.lin.vo.req.UpdateRoomInfoReqVO;
import cn.stu.edu.lin.vo.resp.CommonRespVO;
import cn.stu.edu.lin.vo.resp.NewRoomRespVO;
import cn.stu.edu.lin.vo.resp.RoomAllInfoRespVO;
import cn.stu.edu.lin.vo.resp.RoomInfoRespVO;
import cn.sut.edu.lin.annotation.IgnoreLogin;

@RestController
@RequestMapping("/room")
public class RoomController extends AbstractController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private AnchorService anchorService;

	@Autowired
	private Mapper beanMapper;

	@IgnoreLogin
	@RequestMapping(value = "/getRoomInfo", method = RequestMethod.GET)
	public ResponseEntity<Resp> getRoomInfo(@RequestBody RoomInfoReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int roomNum = reqVO.getRoomnum();

			Room room = roomService.getRoom(roomNum);

			RoomInfoRespVO vo = beanMapper.map(room, RoomInfoRespVO.class);

			responseEntity = Resp.createSuccess(vo);
		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "服务失败");
		}

		return responseEntity;
	}

	@IgnoreLogin
	@RequestMapping(value = "/getRoomAllInfo", method = RequestMethod.GET)
	public ResponseEntity<Resp> getRoomAllInfo(@RequestBody RoomInfoReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int roomNum = reqVO.getRoomnum();

			// 获取房间信息
			Room room = roomService.getRoom(roomNum);

			RoomAllInfoRespVO vo = beanMapper.map(room, RoomAllInfoRespVO.class);

			// 获取主播信息
			Anchor anchor = anchorService.getAnchor(room.getAnchorid());

			vo = beanMapper.map(anchor, RoomAllInfoRespVO.class);

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "system.error", "系统错误");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/newRoom", method = RequestMethod.GET)
	public ResponseEntity<Resp> newRoom(NewRoomReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int anchorId = reqVO.getAnchorid();

			// 获取房间信息
			int result = roomService.insertRoom(anchorId);

			Room room = roomService.getRoomByAnchorId(anchorId);

			NewRoomRespVO vo = new NewRoomRespVO();
			vo.setRoomnum(room.getRoomnum());

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "system.error", "系统错误");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/updateRoomInfo", method = RequestMethod.POST)
	public ResponseEntity<Resp> updateRoomInfo(@RequestBody UpdateRoomInfoReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			Room room = beanMapper.map(reqVO, Room.class);
			int result = roomService.updateRoomInfo(room);

			CommonRespVO vo = new CommonRespVO();
			vo.setResult(result);

			responseEntity = Resp.createSuccess(vo);

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "system.error", "系统错误");
		}

		return responseEntity;
	}

}