package Domain.Entities;

import Application.ValidationExceptionHandler.ValidationExceptionMessages;
import Domain.Entities.Base.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table
(
    name = "ApplicationUser",
    uniqueConstraints = @UniqueConstraint(columnNames = "Email")
)
public class ApplicationUser extends EntityId {
    @Column(length = 50, nullable = false)
    @Email(message = ValidationExceptionMessages.EMAIL_TYPE)
    public String Email;

    @Column(length = 64, nullable = false)
    @Length(min = 64, max = 64)
    public String Password;

    public ApplicationUser() {
    }

    public ApplicationUser Create(
            String email,
            String password
    )
    {
        var user = new ApplicationUser();
        user.setId(CreateId());
        user.setEmail(email);
        user.setPassword(password);

        return user;
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
