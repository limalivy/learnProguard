package io.lim.keeps;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

@Retention(CLASS)
@Target({TYPE,METHOD,FIELD})
public @interface Keeps {
    Attribute attribute() default Attribute.NAME;
    Extend extend() default  Extend.NONE;
}
