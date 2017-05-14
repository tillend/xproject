package cn.stu.edu.lin.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.common.RespCode;
import cn.stu.edu.lin.model.Present;
import cn.stu.edu.lin.model.PresentSendModel;
import cn.stu.edu.lin.service.PresentService;
import cn.stu.edu.lin.vo.req.PresentBuyReqVO;
import cn.stu.edu.lin.vo.req.PresentSentReqVO;
import cn.stu.edu.lin.vo.resp.CommonRespVO;
import cn.stu.edu.lin.vo.resp.PresentBuyRespVO;

@RestController
@RequestMapping("/present")
public class PresentController extends AbstractController {

	@Autowired
	private PresentService presentService;

	@Autowired
	private DozerBeanMapper beanMapper;

	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public ResponseEntity<Resp> buy(PresentBuyReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			String presentId = reqVO.getPresentId();

			Present present = presentService.getPresent(Integer.parseInt(presentId));

			PresentBuyRespVO vo = new PresentBuyRespVO();
			vo.setPrice(present.getPrice());

			responseEntity = Resp.createSuccess(vo);
		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "服务失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/sent", method = RequestMethod.GET)
	public ResponseEntity<Resp> sent(PresentSentReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			PresentSendModel model = beanMapper.map(reqVO, PresentSendModel.class);
			model.setUserId(String.valueOf(getUserId()));

			int result = presentService.sendPresent(model);

			CommonRespVO vo = new CommonRespVO();
			if (result == 1) {
				vo.setResult(result);
				responseEntity = Resp.createSuccess(vo);
			} else {
				responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "赠送失败");
			}

		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "服务失败");
		}

		return responseEntity;
	}

}