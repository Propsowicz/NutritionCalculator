package Application.CustomValidators.IsApplicationUserExists;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsApplicationUserExistsValidator.class)
@Documented
public @interface IsApplicationUserExists {
    String message() default "Must exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
