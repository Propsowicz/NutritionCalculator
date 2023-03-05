package Application.Commands.ApplicationUser.Create;

public interface ICreateApplicationUserCommand {
    String Handle(String email, String password);
}
