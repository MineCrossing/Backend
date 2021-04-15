package xyz.minecrossing.backend.database.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A simple annotation to specify a fields SQL column name
 *
 * @author Matthew Dodds W18020972
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColName {
	String col() default "";
}