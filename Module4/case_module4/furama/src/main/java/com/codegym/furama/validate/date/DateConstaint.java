package com.codegym.furama.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateConstaint {
    String message() default "The date of birth must be in the past";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
