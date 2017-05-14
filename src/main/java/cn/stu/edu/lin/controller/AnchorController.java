package cn.stu.edu.lin.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.common.RespCode;
import cn.stu.edu.lin.model.Anchor;
import cn.stu.edu.lin.service.AnchorService;
import cn.stu.edu.lin.vo.req.AnchorRegisterReqVO;
import cn.stu.edu.lin.vo.resp.AnchorInfoRespVO;
import cn.stu.edu.lin.vo.resp.CommonRespVO;

@RestController
@RequestMapping("/anchor")
public class AnchorController extends AbstractController {

	@Autowired
	private AnchorService anchorService;

	@Autowired
	private DozerBeanMapper beanMapper;

	@RequestMapping(value = "/getArchorInfo", method = RequestMethod.GET)
	public ResponseEntity<Resp> getArchorInfo() {
		ResponseEntity<Resp> responseEntity = null;

		try {
			int anchorId = getAnchorId();

			Anchor anchor = anchorService.getAnchor(anchorId);

			AnchorInfoRespVO vo = beanMapper.map(anchor, AnchorInfoRespVO.class);

			responseEntity = Resp.createSuccess(vo);
		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "服务失败");
		}

		return responseEntity;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ResponseEntity<Resp> register(AnchorRegisterReqVO reqVO) {
		ResponseEntity<Resp> responseEntity = null;

		try {
			String anchorName = reqVO.getAnchorName();

			Anchor anchor = new Anchor();
			anchor.setAnchorname(anchorName);
			anchor.setIntegral("0");
			anchor.setLevel("0");

			int result = anchorService.insertAnchor(anchor);

			CommonRespVO vo = new CommonRespVO();
			vo.setResult(result);

			responseEntity = Resp.createSuccess(vo);
		} catch (Exception e) {
			responseEntity = Resp.createError(RespCode.BUSINESS_INVALID, "user.fail", "服务失败");
		}

		return responseEntity;
	}

}