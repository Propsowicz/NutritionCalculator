package Application.Helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;

public class PaginationHelper<T> {

    public static <T> TypedQuery<T> GetPage(
        EntityManager entityManager,
        CriteriaQuery<T> criteriaQuery,
        Integer pageNumber,
        Integer pageSize
    )
    {
        if (pageNumber == 1){
            return entityManager.createQuery(criteriaQuery)
                    .setFirstResult(pageNumber - 1)
                    .setMaxResults(pageSize);
        }else {
            return entityManager.createQuery(criteriaQuery)
                    .setFirstResult(pageSize * (pageNumber - 1))
                    .setMaxResults(pageSize);
        }
    }
}
