package cn.sut.edu.lin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.servlet.http.HttpServletRequest;

/**
 * 表示该方法处理的是 multipart/form-data 请求
 *
 * <p>
 * 加了该注解，在 Spring MVC 拦截器中不再会去判断 {@link HttpServletRequest} 必须是
 * {@link DisableSessionHttpServletRequest} 类型
 *
 * @author gaobaowen
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Inherited
public @interface Multipart {
}
