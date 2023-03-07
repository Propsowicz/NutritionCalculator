package Application.CustomValidators.IsEmailAlreadyExists;

import Application.Queries.User.IsUserEmailUnique.IIsUserEmailUnique;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsEmailUniqueValidator implements ConstraintValidator<IsEmailUnique, String> {

    @Inject
    IIsUserEmailUnique isUserEmailUnique;

    @Override
    public void initialize(IsEmailUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isUserEmailUnique.Handle(value);
    }
}
