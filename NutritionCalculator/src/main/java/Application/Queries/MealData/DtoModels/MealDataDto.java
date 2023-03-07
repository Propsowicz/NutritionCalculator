package Application.Queries.MealData.DtoModels;

public class MealDataDto {
    public String id;

    public String name;

    public Integer caloriesPer100Grams;

    public Double carbsPer100Grams;

    public Double proteinsPer100Grams;

    public Double fatsPer100Grams;

    public MealDataDto(
        String id,
        String name,
        Integer caloriesPer100Grams,
        Double carbsPer100Grams,
        Double proteinsPer100Grams,
        Double fatsPer100Grams
    )
    {
        this.id = id;
        this.name = name;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.carbsPer100Grams = carbsPer100Grams;
        this.proteinsPer100Grams = proteinsPer100Grams;
        this.fatsPer100Grams = fatsPer100Grams;
    }
}
