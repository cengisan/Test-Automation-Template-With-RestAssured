package reports.Link;


import java.lang.annotation.*;
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Repeatable(Links.class)
public @interface Link {

    String value() default "";

    String name() default "Test Link";

    String url() default "";

}
