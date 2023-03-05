package Application.Queries.MealData.GetMealData;

import Application.Helpers.PaginationHelper;
import Application.Primitives.PaginatedResponse;
import Application.Queries.MealData.DtoModels.MealDataDto;
import Domain.Entities.MealData;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Stateless
public class GetMealDataQuery implements IGetMealDataQuery {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public PaginatedResponse<MealDataDto> Handle(
        Integer pageNumber,
        Integer pageSize
    )
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        Long itemsCount = CountQueryItems(criteriaBuilder);
        TypedQuery<MealDataDto> typedQuery = QueryMealData(criteriaBuilder, pageNumber, pageSize);

        return new PaginatedResponse(
                typedQuery.getResultList(),
                itemsCount.intValue()
        );
    }

    private Long CountQueryItems(CriteriaBuilder criteriaBuilder){
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(MealData.class)));

        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private TypedQuery<MealDataDto> QueryMealData(
            CriteriaBuilder criteriaBuilder,
            Integer pageNumber,
            Integer pageSize
    )
    {
        CriteriaQuery<MealDataDto> criteriaQuery = criteriaBuilder.createQuery(MealDataDto.class);
        Root<MealData> from = criteriaQuery.from(MealData.class);
        CriteriaQuery<MealDataDto> select = criteriaQuery.select(
                criteriaBuilder.construct(
                        MealDataDto.class,
                        from.get("Id"),
                        from.get("Name"),
                        from.get("CaloriesPer100Grams"),
                        from.get("CarbsPer100Grams"),
                        from.get("ProteinsPer100Grams"),
                        from.get("FatsPer100Grams")
                )
        );
        return PaginationHelper.GetPage(entityManager, select, pageNumber, pageSize);
    }
}
