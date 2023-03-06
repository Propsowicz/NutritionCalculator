package Application.Queries.User.DtoModels;

public class ApplicationUserDto {
    public String id;

    public String email;

    public ApplicationUserDto(String id, String email) {
        this.id = id;
        this.email = email;
    }
}
