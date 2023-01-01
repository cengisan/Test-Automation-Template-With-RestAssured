package reports.annotations.Links;

import reports.annotations.Link.Link;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Links {

    Link[] value();

}
