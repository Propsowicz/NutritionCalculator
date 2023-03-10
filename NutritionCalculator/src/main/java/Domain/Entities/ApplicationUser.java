package Domain.Entities;

import Application.ValidationExceptionHandler.ValidationExceptionMessages;
import Domain.Entities.Base.DomainEventsData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
(
    name = "ApplicationUser",
    uniqueConstraints = @UniqueConstraint(columnNames = "Email")
)
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

    private void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    private void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationUser that = (ApplicationUser) o;
        return Email.equals(that.Email) && Password.equals(that.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Email, Password);
    }
}
