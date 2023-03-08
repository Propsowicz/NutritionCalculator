package Application.CustomValidators.IsApplicationUserExists;

import Application.Queries.User.IsApplicationUserExists.IIsApplicationUserExists;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsApplicationUserExistsValidator implements ConstraintValidator<IsApplicationUserExists, String> {

    @Inject
    IIsApplicationUserExists isApplicationUserExists;

    @Override
    public void initialize(IsApplicationUserExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isApplicationUserExists.Handle(value);
    }
}
