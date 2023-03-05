package Presentation.Controllers.ApplicationUser.Request;

import Application.ValidationExceptionHandler.ValidationExceptionMessages;
import Infrastructure.CustomValidators.IsEmailAlreadyExists.IsEmailUnique;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class ApplicationUserCreateRequest {
    @NotNull(message = ValidationExceptionMessages.NOT_NULL)
    @Email(message = ValidationExceptionMessages.EMAIL_TYPE)
    @Length(max = 50, message = ValidationExceptionMessages.STRING_LENGTH_MAX_50)
    @IsEmailUnique
    public String Email;

    @NotNull(message = ValidationExceptionMessages.NOT_NULL)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,}$",
            message = ValidationExceptionMessages.PASSWORD_TYPE)
    @Length(max = 50, message = ValidationExceptionMessages.STRING_LENGTH_MAX_50)
    public String Password;

    public ApplicationUserCreateRequest() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
