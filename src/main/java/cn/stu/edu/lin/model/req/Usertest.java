package cn.stu.edu.lin.model.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Usertest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2784455520022937629L;
	@NotNull(message = "id不能为空")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
