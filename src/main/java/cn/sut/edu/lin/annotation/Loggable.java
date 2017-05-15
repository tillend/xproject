package cn.sut.edu.lin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.stu.edu.lin.model.log.DataAccessType;

/**
 * 
 * ClassName: Loggable <br/>
 * Function: Loggable注解 <br/>
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Loggable {

	/**
	 * Name of the logType in which the logging takes place.
	 * <p>
	 * May be used to determine the target cache (or caches), matching the
	 * qualifier value (or the bean name(s)) of (a) specific bean definition.
	 */
	DataAccessType value() default DataAccessType.HTTP;
}