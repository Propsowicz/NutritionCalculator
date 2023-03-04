package Application.Queries.User.GetAll;

import Domain.Entities.ApplicationUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class GetAllUsers implements IGetAllUsers{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ApplicationUser> Handle() {
        return null;
    }
}
