package Presentation.Controllers.ApplicationUser.Request;

public class ApplicationUserRequest {
    public String Email;

    public String Password;

    public ApplicationUserRequest() {
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
