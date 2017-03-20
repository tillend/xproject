package cn.stu.edu.lin.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.common.RespCode;

@ControllerAdvice
public class RestBaseExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(RestBaseExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public Object baseExceptionHandle(Exception ex) {
		logger.error("uncaught Exception:", ex);
		return null;
	}

	@ExceptionHandler(BindException.class)
	public Object baseExceptionHandle(BindException ex) {
		logger.error("uncaught BindException:", ex);
		// 如果不是注解校验
		if (ex.getFieldError().isBindingFailure()) {
			return Resp.createError(RespCode.PARAM_ERR, ex.getFieldError().getField(), ex.getFieldError().getField());

			// 如果是注解校验
		} else {
			return Resp.createError(RespCode.PARAM_ERR, ex.getFieldError().getField(),
					ex.getFieldError().getDefaultMessage());
		}

	}
}
