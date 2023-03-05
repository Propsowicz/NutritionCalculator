package Application.Commands.MealData.Create;

public interface ICreateMealDataCommand {
    String Handle(
            String name,
            Integer caloriesPer100Grams,
            Double carbsPer100Grams,
            Double proteinsPer100Grams,
            Double fatsPer100Grams
    );
}
