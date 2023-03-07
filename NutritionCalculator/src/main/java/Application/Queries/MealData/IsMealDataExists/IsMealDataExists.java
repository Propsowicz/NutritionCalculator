package Application.Queries.MealData.IsMealDataExists;

import Domain.Entities.MealData;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class IsMealDataExists implements IIsMealDataExists {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean Handle(String mealDataId) {
        if (entityManager.find(MealData.class, mealDataId) == null) { return false; }
        return true;
    }
}
