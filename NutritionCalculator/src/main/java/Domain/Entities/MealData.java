package Domain.Entities;

import Domain.Entities.Base.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Objects;

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

    private void setName(String name) {
        Name = name;
    }

    public Integer getCaloriesPer100Grams() {
        return CaloriesPer100Grams;
    }

    private void setCaloriesPer100Grams(Integer caloriesPer100Grams) {
        CaloriesPer100Grams = caloriesPer100Grams;
    }

    public Double getCarbsPer100Grams() {
        return CarbsPer100Grams;
    }

    private void setCarbsPer100Grams(Double carbsPer100Grams) {
        CarbsPer100Grams = carbsPer100Grams;
    }

    public Double getProteinsPer100Grams() {
        return ProteinsPer100Grams;
    }

    private void setProteinsPer100Grams(Double proteinsPer100Grams) {
        ProteinsPer100Grams = proteinsPer100Grams;
    }

    public Double getFatsPer100Grams() {
        return FatsPer100Grams;
    }

    private void setFatsPer100Grams(Double fatsPer100Grams) {
        FatsPer100Grams = fatsPer100Grams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealData mealData = (MealData) o;
        return Name.equals(mealData.Name) && CaloriesPer100Grams.equals(mealData.CaloriesPer100Grams) && CarbsPer100Grams.equals(mealData.CarbsPer100Grams) && ProteinsPer100Grams.equals(mealData.ProteinsPer100Grams) && FatsPer100Grams.equals(mealData.FatsPer100Grams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, CaloriesPer100Grams, CarbsPer100Grams, ProteinsPer100Grams, FatsPer100Grams);
    }
}