package cn.stu.edu.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.stu.edu.lin.dao.AnchorMapper;
import cn.stu.edu.lin.model.Anchor;
import cn.stu.edu.lin.service.AnchorService;

@Service
public class AnchorServiceImpl implements AnchorService {

	@Autowired
	private AnchorMapper anchorDao;

	@Override
	public Anchor getAnchor(int anchorId) {
		return anchorDao.selectByPrimaryKey(anchorId);
	}

	@Override
	public int insertAnchor(Anchor anchor) {
		return anchorDao.insertSelective(anchor);
	}

}
