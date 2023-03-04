package Infrastructure.CustomValidators.IsEmailAlreadyExists;

import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
    ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsEmailUnique {
    String message() default "must be a valid language display name.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
