package Domain.Entities;

import Domain.Entities.Base.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table
(
    name = "MealData"
)
public class MealData extends EntityId {
    @Column(length = 50, nullable = false)
    public String Name;

    @Column(nullable = false)
    @PositiveOrZero
    public Integer CaloriesPer100Grams;

    @Column(nullable = false)
    @PositiveOrZero
    public Double CarbsPer100Grams;

    @Column(nullable = false)
    @PositiveOrZero
    public Double ProteinsPer100Grams;

    @Column(nullable = false)
    @PositiveOrZero
    public Double FatsPer100Grams;

    public MealData() {
    }

    public String getName() {
        return Name;
    }

    public MealData Create(
            String name,
            Integer calories,
            Double carbs,
            Double proteins,
            Double fats
    )
    {
        var mealData = new MealData();
        mealData.setId(CreateId());
        mealData.setName(name);
        mealData.setCaloriesPer100Grams(calories);
        mealData.setCarbsPer100Grams(carbs);
        mealData.setProteinsPer100Grams(proteins);
        mealData.setFatsPer100Grams(fats);

        return mealData;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCaloriesPer100Grams() {
        return CaloriesPer100Grams;
    }

    public void setCaloriesPer100Grams(Integer caloriesPer100Grams) {
        CaloriesPer100Grams = caloriesPer100Grams;
    }

    public Double getCarbsPer100Grams() {
        return CarbsPer100Grams;
    }

    public void setCarbsPer100Grams(Double carbsPer100Grams) {
        CarbsPer100Grams = carbsPer100Grams;
    }

    public Double getProteinsPer100Grams() {
        return ProteinsPer100Grams;
    }

    public void setProteinsPer100Grams(Double proteinsPer100Grams) {
        ProteinsPer100Grams = proteinsPer100Grams;
    }

    public Double getFatsPer100Grams() {
        return FatsPer100Grams;
    }

    public void setFatsPer100Grams(Double fatsPer100Grams) {
        FatsPer100Grams = fatsPer100Grams;
    }
}