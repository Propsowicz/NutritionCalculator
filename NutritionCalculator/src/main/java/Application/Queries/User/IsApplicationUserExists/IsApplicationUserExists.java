package Application.Queries.User.IsApplicationUserExists;

import Domain.Entities.ApplicationUser;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class IsApplicationUserExists implements IIsApplicationUserExists {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean Handle(String applicationUserId) {
        if (entityManager.find(ApplicationUser.class, applicationUserId) == null) { return false; }
        return true;
    }
}
