package Application.Commands.ApplicationUser.Create;

import Application.AuthFactory.PasswordHasher;
import Domain.Entities.ApplicationUser;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CreateApplicationUser implements ICreateApplicationUser {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public String Handle(String email, String password) {
        var hashedPassword = PasswordHasher.Hash(password);

        var user = new ApplicationUser().Create(email, hashedPassword);
        entityManager.persist(user);

        return user.getId();
    }
}
