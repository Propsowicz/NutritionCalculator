package Application.Queries.User.GetAll;

import Application.BuildingBlocks.Helpers.PaginationHelperFactory;
import Application.BuildingBlocks.Primitives.PaginatedResponse;
import Application.Queries.User.DtoModels.ApplicationUserDto;
import Domain.Entities.ApplicationUser;
import Presentation.BuidlingBlocks.Primitives.PaginatedRequest;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Stateless
public class GetAllUsers implements IGetAllUsers{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public PaginatedResponse<ApplicationUserDto> Handle(PaginatedRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        Long itemsCount = CountQueryItems(criteriaBuilder);
        TypedQuery<ApplicationUserDto> typedQuery = QueryMealData(criteriaBuilder, request);

        return new PaginatedResponse(
                typedQuery.getResultList(),
                itemsCount.intValue()
        );
    }

    private Long CountQueryItems(CriteriaBuilder criteriaBuilder){
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(ApplicationUser.class)));

        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private TypedQuery<ApplicationUserDto> QueryMealData(
            CriteriaBuilder criteriaBuilder,
            PaginatedRequest request
    )
    {
        CriteriaQuery<ApplicationUserDto> criteriaQuery = criteriaBuilder.createQuery(ApplicationUserDto.class);
        Root<ApplicationUser> from = criteriaQuery.from(ApplicationUser.class);
        criteriaQuery.select(
                criteriaBuilder.construct(
                        ApplicationUserDto.class,
                        from.get("Id"),
                        from.get("Email")
                )
        );

        var paginationHelperFactory = new PaginationHelperFactory<ApplicationUser, ApplicationUserDto>(
                entityManager,
                criteriaBuilder,
                criteriaQuery,
                from
        );

        return paginationHelperFactory.GetQuery(request, "email");
    }
}
