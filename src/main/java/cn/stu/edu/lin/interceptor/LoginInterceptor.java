package cn.stu.edu.lin.interceptor;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;

import cn.stu.edu.lin.common.Resp;
import cn.stu.edu.lin.common.RespCode;
import cn.stu.edu.lin.util.ServletUtils;

/**
 * 登录认证的拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter implements BeanPostProcessor {

	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	private AnnotationProcessor annotationProcessor;

	public LoginInterceptor() {
		this.annotationProcessor = new AnnotationProcessor();
	}

	/**
	 * Handler执行之前调用这个方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的URL
		String uri = request.getRequestURI();
		// System.out.println(uri);

		if (!(handler instanceof HandlerMethod)) {
			// log.warn("Handler is not HandlerMethod type, URI = {} , handler =
			// {}", uri,
			// handler == null ? "null" : handler.getClass());
			return true;
		}

		HandlerMethod method = (HandlerMethod) handler;

		// Controller 方法标注有 @IgnoreLogin
		if (isIgnoreLoginMethod(method)) {
			// log.debug("IgnoreLogin, uri = {}", uri);
			return true;
		}

		// 登录请求过滤
		if (uri.contains("/login")) {
			return true;
		}

		boolean isLogin = checkLogin(request);

		if (isLogin) {
			return true;
		}

		// 未登录
		reject(response);

		return false;
	}

	// 校检登录态
	private boolean checkLogin(HttpServletRequest request) {
		// 获取Cookie
		Cookie[] cookies = request.getCookies();
		String userId = ServletUtils.getCookieValue(cookies, "uid");

		return StringUtils.isNotEmpty(userId);
	}

	// 用户未登录,拒绝访问
	public void reject(HttpServletResponse response) {
		try {
			response.getWriter().write(getAccessDenied(RespCode.ACCESS_DENIED, "not.login", "用户未登录"));
		} catch (IOException e) {
			// log.error("Write accessDenied JSON cause error", e);
		}
	}

	public String getAccessDenied(RespCode code, String subCode, String subMsg) {
		ResponseEntity<Resp> resp = Resp.createError(code, subCode, subMsg);
		return JSON.toJSONString(resp.getBody());
	}

	private boolean isIgnoreLoginMethod(HandlerMethod method) {
		return annotationProcessor.isIgnoreLogin(method.getMethod());
	}

	private boolean isMultipartMethod(HandlerMethod method) {
		return annotationProcessor.isMartipart(method.getMethod());
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		annotationProcessor.processAuthSessionAnnotation(bean);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		return bean;
	}
}
