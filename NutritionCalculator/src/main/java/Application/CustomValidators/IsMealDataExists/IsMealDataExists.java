package Application.CustomValidators.IsMealDataExists;

import Application.CustomValidators.IsEmailAlreadyExists.IsEmailUniqueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsMealDataExistsValidator.class)
@Documented
public @interface IsMealDataExists {
    String message() default "Must exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
