package Application.CustomValidators.IsMealDataExists;

import Application.Queries.MealData.IsMealDataExists.IIsMealDataExists;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsMealDataExistsValidator implements ConstraintValidator<IsMealDataExists, String> {

    @Inject
    IIsMealDataExists isMealDataExists;

    @Override
    public void initialize(IsMealDataExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isMealDataExists.Handle(value);
    }
}
