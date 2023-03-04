package Presentation.Controllers.ApplicationUser.Request;

import Application.ValidationExceptionHandler.ValidationExceptionMessages;
import Infrastructure.CustomValidators.IsEmailAlreadyExists.IsEmailUnique;
import jakarta.validation.constraints.*;

public class ApplicationUserCreateRequest {
    @NotNull(message = ValidationExceptionMessages.NOT_NULL)
    @IsEmailUnique
    public String Email;

    @NotNull(message = ValidationExceptionMessages.NOT_NULL)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,}$",
            message = ValidationExceptionMessages.PASSWORD_TYPE)
    public String Password;

    public ApplicationUserCreateRequest() {
    }
    //@Email(message = ValidationExceptionMessages.EMAIL_TYPE)
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
