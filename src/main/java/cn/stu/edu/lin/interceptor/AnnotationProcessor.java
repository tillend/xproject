package cn.stu.edu.lin.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import cn.sut.edu.lin.annotation.IgnoreLogin;
import cn.sut.edu.lin.annotation.Multipart;

@SuppressWarnings("unchecked")
public class AnnotationProcessor {

	private static final Logger log = LoggerFactory.getLogger(AnnotationProcessor.class);

	private static String[] NAMES = { "org.springframework.web.bind.annotation.RestController",
			"org.springframework.stereotype.Controller" };

	private static final List<Class<? extends Annotation>> CONTROLLER_ANNOTATIONS = new ArrayList<>(NAMES.length);

	private final Map<Method, AuthSessionAnnotation> annotations;

	static {
		for (String name : NAMES) {
			try {
				Class<?> clazz = Class.forName(name);
				if (Annotation.class.isAssignableFrom(clazz)) {
					CONTROLLER_ANNOTATIONS.add((Class<? extends Annotation>) clazz);
					log.info("Controller annotation class: {}", clazz);
				}
			} catch (ClassNotFoundException e) {
				// ignore
			}
		}
	}

	public AnnotationProcessor() {
		this.annotations = new ConcurrentHashMap<Method, AuthSessionAnnotation>();
	}

	public void processAuthSessionAnnotation(Object bean) {

		if (!isController(bean.getClass())) {
			return;
		}

		Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());

		for (Method method : methods) {

			AuthSessionAnnotation annotation = createAuthSessionAnnotation(method);
			if (annotation == null) {
				continue;
			}

			annotations.put(method, annotation);

			log.info("Method: {}, Annotations: {}", method.toString(), annotation);
		}
	}

	public boolean isIgnoreLogin(Method method) {
		AuthSessionAnnotation annotation = annotations.get(method);
		if (annotation == null) {
			return false;
		}
		return annotation.isIgnoreLogin();
	}

	public boolean isMartipart(Method method) {
		AuthSessionAnnotation annotation = annotations.get(method);
		if (annotation == null) {
			return false;
		}
		return annotation.isMultipart();
	}

	private AuthSessionAnnotation createAuthSessionAnnotation(Method method) {

		IgnoreLogin ignoreLogin = AnnotationUtils.getAnnotation(method, IgnoreLogin.class);
		Multipart multipart = AnnotationUtils.getAnnotation(method, Multipart.class);

		if (hasNotNull(ignoreLogin, multipart)) {
			return new AuthSessionAnnotation(ignoreLogin, multipart);
		}

		return null;
	}

	private boolean hasNotNull(Object... objects) {
		for (Object object : objects) {
			if (object != null) {
				return true;
			}
		}
		return false;
	}

	private boolean isController(Class<?> beanClass) {

		for (Class<? extends Annotation> annotationClass : CONTROLLER_ANNOTATIONS) {

			Object controller = AnnotationUtils.findAnnotation(beanClass, annotationClass);

			if (controller != null) {
				return true;
			}
		}

		return false;
	}
}
