package Application.Queries.User.IsUserEmailUnique;

import Domain.Entities.ApplicationUser;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Stateless
public class IsUserEmailUnique implements IIsUserEmailUnique {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean Handle(String email) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ApplicationUser> criteriaQuery = criteriaBuilder.createQuery(ApplicationUser.class);
        Root<ApplicationUser> from = criteriaQuery.from(ApplicationUser.class);

        criteriaQuery.select(from).where(criteriaBuilder.equal(from.get("Email"), email));

        TypedQuery<ApplicationUser> query = entityManager.createQuery((criteriaQuery));
        var result = (long) query.getResultList().size();

        return result == 0;
    }
}
