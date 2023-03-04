package Application.Queries.User.GetAll;

import Domain.Entities.ApplicationUser;

import java.util.List;

public interface IGetAllUsers {
    List<ApplicationUser> Handle();
}
