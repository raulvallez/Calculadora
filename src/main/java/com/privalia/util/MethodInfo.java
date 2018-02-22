package com.privalia.util;

//Las anotaciones de mi anotación
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
	String author() default "Pepe";
	String date();
	int revision() default 1;
	String comments();
}
