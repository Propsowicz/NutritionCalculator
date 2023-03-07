package Application.BuildingBlocks.Helpers;

import Presentation.BuidlingBlocks.Primitives.PaginatedRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;

public class PaginationHelperFactory<T, TDto> {
    private EntityManager entityManager;

    private CriteriaBuilder criteriaBuilder;

    private CriteriaQuery<TDto> criteriaQuery;

    private Root<T> root;

    public PaginationHelperFactory(
            EntityManager entityManager,
            CriteriaBuilder criteriaBuilder,
            CriteriaQuery<TDto> criteriaQuery,
            Root<T> root
    )
    {
        this.entityManager = entityManager;
        this.criteriaBuilder = criteriaBuilder;
        this.criteriaQuery = criteriaQuery;
        this.root = root;
    }

    public TypedQuery<TDto> GetQuery(
        PaginatedRequest request,
        String columnToSearch
    )
    {
        Where(request.getPhrase(), columnToSearch);
        OrderBy(request.getOrderingValue(), request.getOrderDirection());

        return GetPage(request.getPageNumber(), request.getPageSize());
    }

    protected TypedQuery<TDto> GetPage(
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

    protected void OrderBy(
            String orderValue,
            String orderDirectory
    )
    {
        if (orderDirectory.equals("desc")){
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderValue)));
        }
        else {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderValue)));
        }
    }

    protected void Where(
            String phrase,
            String columnToSearch
    )
    {
        if (phrase != null){
            criteriaQuery.where(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(
                                    root.get(StringUtils.capitalize(columnToSearch))
                            ),
                            "%" + phrase.toLowerCase() + "%"
                    )
            );
        }
    }
}
