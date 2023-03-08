package Application.Commands.Meal.Create;

import Domain.BuildingBlocks.Helpers.MathMethods;
import Domain.BussinesLogic.Calculators.MealCalculator.IMealCalculator;
import Domain.Entities.ApplicationUser;
import Domain.Entities.Meal;
import Domain.Entities.MealData;
import Presentation.Controllers.Meal.Request.CreateMealRequest;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;

@Stateless
public class CreateMealCommand implements ICreateMealCommand {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    IMealCalculator mealCalculator;

    @Override
    public String Handle(CreateMealRequest request) {
        var applicationUser = entityManager.find(ApplicationUser.class, request.ApplicationUserId);
        var mealData = entityManager.find(MealData.class, request.MealDataId);

        var meal = new Meal().Create(
            applicationUser,
            mealData,
            LocalDate.now(),
            MathMethods.Round(request.MealWeightInGrams, 0),
            mealCalculator.GetCalories(mealData, request.MealWeightInGrams),
            mealCalculator.GetCarbs(mealData, request.MealWeightInGrams),
            mealCalculator.GetProteins(mealData, request.MealWeightInGrams),
            mealCalculator.GetFats(mealData, request.MealWeightInGrams)
        );

        entityManager.persist(meal);

        return meal.getId();
    }
}
