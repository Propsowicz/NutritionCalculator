package Domain.Entities;

import Application.ValidationExceptionHandler.ValidationExceptionMessages;
import Domain.Entities.Base.DomainEventsData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
/*@Table
(
    name = "ApplicationUser",
    uniqueConstraints = @UniqueConstraint(columnNames = "Email")
)*/
public class ApplicationUser extends DomainEventsData {
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

        user.setCreatedOn(LocalDate.now());
        user.setCreatedById(user.getId());

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
