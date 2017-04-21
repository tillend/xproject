package cn.stu.edu.lin.handler;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
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
			// 处理为空的错误
			/**
			 * an object/field-specific code, a field-specific code, a plain
			 * error code. @DefaultMessageCodesResolver.resolveMessageCodes
			 **/
			List<ObjectError> list = ex.getAllErrors();
			if (list != null && list.size() != 0) {
				for (ObjectError objectError : list) {
					String code = objectError.getCode();
					// 可以有多个校验注解，只要有为空的校验不通过就返回参数缺失，三个区别
					if (!StringUtils.isBlank(code) && (code.startsWith("NotBlank") || code.startsWith("NotNull")
							|| code.startsWith("NotEmpty"))) {
						return Resp.createError(RespCode.PARAM_ERR, ex.getFieldError().getField(),
								ex.getFieldError().getField());
					}
				}
			}

			// 处理非空的其它错误
			return Resp.createError(RespCode.PARAM_ERR, ex.getFieldError().getField(), ex.getFieldError().getField());
		}

	}
}
