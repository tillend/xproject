package cn.stu.edu.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.stu.edu.lin.dao.AnchorMapper;
import cn.stu.edu.lin.dao.PresentMapper;
import cn.stu.edu.lin.dao.UserIntegralMapper;
import cn.stu.edu.lin.dao.UserPresentMapper;
import cn.stu.edu.lin.model.Anchor;
import cn.stu.edu.lin.model.Present;
import cn.stu.edu.lin.model.PresentSendModel;
import cn.stu.edu.lin.model.UserIntegral;
import cn.stu.edu.lin.model.UserPresent;
import cn.stu.edu.lin.service.PresentService;

@Service
public class PresentServiceImpl implements PresentService {

	@Autowired
	private PresentMapper presentDao;

	@Autowired
	private UserPresentMapper userPresentDao;

	@Autowired
	private AnchorMapper anchorDao;

	@Autowired
	private UserIntegralMapper userIntegralDao;

	@Override
	public Present getPresent(int presentId) {
		return presentDao.selectByPrimaryKey(presentId);
	}

	@Override
	@Transactional
	public int sendPresent(PresentSendModel model) {
		// 入参设置
		Integer presentId = Integer.parseInt(model.getPresentId());
		Integer anchorId = Integer.parseInt(model.getAnchorId());
		Integer userId = Integer.parseInt(model.getUserId());
		int amount = Integer.parseInt(model.getAmount());

		// 获取礼物详情
		Present present = presentDao.selectByPrimaryKey(presentId);

		// 计算增加的积分
		Double integral = Double.parseDouble(present.getIntegral());
		Double point = integral * amount;

		/* 用户减少礼物数量 */
		UserPresent userPresent = userPresentDao.selectUserIntegral(userId, presentId);
		int ownAmount = userPresent.getAmount();
		if (ownAmount == 0 || ownAmount < amount) {
			return 0;
		}

		UserPresent updateUserPresent = new UserPresent();
		updateUserPresent.setId(userPresent.getId());
		updateUserPresent.setPresentid(userPresent.getPresentid());
		updateUserPresent.setUserid(userPresent.getUserid());
		updateUserPresent.setAmount(ownAmount - amount);

		/* 用户增加积分 */
		UserIntegral userIntegral = userIntegralDao.selectByPrimaryKey(userId);
		// 增加后的积分
		Double userPoint = point + Double.parseDouble(userIntegral.getIntegral());
		UserIntegral updateUser = new UserIntegral();
		updateUser.setIntegral(userPoint.toString());
		userIntegralDao.updateByPrimaryKeySelective(updateUser);

		/* 主播增加礼物积分 */
		Anchor anchor = anchorDao.selectByPrimaryKey(anchorId);
		// 增加后的积分
		Double anchorPoint = point + Double.parseDouble(anchor.getIntegral());

		Anchor updateAnchor = new Anchor();
		updateAnchor.setAnchorid(anchorId);
		updateAnchor.setIntegral(anchorPoint.toString());
		// anchor.setLevel(level);
		anchorDao.updateByPrimaryKeySelective(updateAnchor);

		return 1;
	}

}
