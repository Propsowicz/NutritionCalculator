package Domain.Entities;

import Domain.Entities.Base.DomainEventsData;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Meal extends DomainEventsData {
    @JoinColumn(name = "ApplicationUserId", nullable = false)
    @ManyToOne
    public ApplicationUser applicationUser;

    public LocalDate MealDate;

    public Integer MealWeight;

    @JoinColumn(name = "MealDataId", nullable = false)
    @ManyToOne
    public MealData mealData;

    public Integer Calories;

    public Integer Carbs;

    public Integer Proteins;

    public Integer Fats;

    public Meal() {
    }

    public ApplicationUser getUser() {
        return applicationUser;
    }

    public void setUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public LocalDate getMealDate() {
        return MealDate;
    }

    public void setMealDate(LocalDate mealDate) {
        MealDate = mealDate;
    }

    public Integer getMealWeight() {
        return MealWeight;
    }

    public void setMealWeight(Integer mealWeight) {
        MealWeight = mealWeight;
    }

    public MealData getMealData() {
        return mealData;
    }

    public void setMealData(MealData mealData) {
        this.mealData = mealData;
    }

    public Integer getCalories() {
        return Calories;
    }

    public void setCalories(Integer calories) {
        Calories = calories;
    }

    public Integer getCarbs() {
        return Carbs;
    }

    public void setCarbs(Integer carbs) {
        Carbs = carbs;
    }

    public Integer getProteins() {
        return Proteins;
    }

    public void setProteins(Integer proteins) {
        Proteins = proteins;
    }

    public Integer getFats() {
        return Fats;
    }

    public void setFats(Integer fats) {
        Fats = fats;
    }
}
