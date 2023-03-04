package Domain.Entities;

import Domain.Entities.Base.EntityId;
import jakarta.persistence.Entity;

@Entity
public class MealData extends EntityId {
    public String Name;

    public Integer CaloriesPer100Grams;

    public Integer CarbsPer100Grams;

    public Integer ProteinsPer100Grams;

    public Integer FatsPer100Grams;

    public MealData() {
    }

    public String getName() {
        return Name;
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

    public Integer getCarbsPer100Grams() {
        return CarbsPer100Grams;
    }

    public void setCarbsPer100Grams(Integer carbsPer100Grams) {
        CarbsPer100Grams = carbsPer100Grams;
    }

    public Integer getProteinsPer100Grams() {
        return ProteinsPer100Grams;
    }

    public void setProteinsPer100Grams(Integer proteinsPer100Grams) {
        ProteinsPer100Grams = proteinsPer100Grams;
    }

    public Integer getFatsPer100Grams() {
        return FatsPer100Grams;
    }

    public void setFatsPer100Grams(Integer fatsPer100Grams) {
        FatsPer100Grams = fatsPer100Grams;
    }
}