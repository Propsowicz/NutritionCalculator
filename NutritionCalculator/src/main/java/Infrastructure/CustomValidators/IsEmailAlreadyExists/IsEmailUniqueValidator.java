package Infrastructure.CustomValidators.IsEmailAlreadyExists;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsEmailUniqueValidator implements ConstraintValidator<IsEmailUnique, String> {
    @Override
    public void initialize(IsEmailUnique constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == "tomek") {
            return true;
        }
        return false;
    }
}
