package reports.annotations.Link;


import reports.annotations.Links.Links;

import java.lang.annotation.*;
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Repeatable(Links.class)
public @interface Link {

    String value() default "";
    String name() default "Test Link";
    String url() default "";

}
