package cn.stu.edu.lin.service;

import cn.stu.edu.lin.model.Present;
import cn.stu.edu.lin.model.PresentSendModel;

public interface PresentService {

	public Present getPresent(int presentId);

	public int sendPresent(PresentSendModel model);

}
