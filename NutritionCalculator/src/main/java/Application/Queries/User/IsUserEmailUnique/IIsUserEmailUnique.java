package Application.Queries.User.IsUserEmailUnique;

public interface IIsUserEmailUnique {
    boolean Handle(String email);
}
