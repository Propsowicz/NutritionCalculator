package Application.Commands.MealData.Create;

import Domain.Entities.MealData;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CreateMealDataCommand implements ICreateMealDataCommand{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public String Handle(String name, Integer caloriesPer100Grams, Double carbsPer100Grams, Double proteinsPer100Grams, Double fatsPer100Grams) {
        var mealData = new MealData().Create(
            name,
            caloriesPer100Grams,
            carbsPer100Grams,
            proteinsPer100Grams,
            fatsPer100Grams
        );

        entityManager.persist(mealData);

        return mealData.getId();
    }
}
