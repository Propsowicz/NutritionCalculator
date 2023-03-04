package Application.Commands.ApplicationUser.Create;

public interface ICreateApplicationUser {
    String Handle(String email, String password);
}
