package Domain.Entities;

import Domain.Entities.Base.DomainEventsData;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Objects;

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

    private void setUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public LocalDate getMealDate() {
        return MealDate;
    }

    private void setMealDate(LocalDate mealDate) {
        MealDate = mealDate;
    }

    public Integer getMealWeight() {
        return MealWeight;
    }

    private void setMealWeight(Integer mealWeight) {
        MealWeight = mealWeight;
    }

    public MealData getMealData() {
        return mealData;
    }

    private void setMealData(MealData mealData) {
        this.mealData = mealData;
    }

    public Integer getCalories() {
        return Calories;
    }

    private void setCalories(Integer calories) {
        Calories = calories;
    }

    public Integer getCarbs() {
        return Carbs;
    }

    private void setCarbs(Integer carbs) {
        Carbs = carbs;
    }

    public Integer getProteins() {
        return Proteins;
    }

    private void setProteins(Integer proteins) {
        Proteins = proteins;
    }

    public Integer getFats() {
        return Fats;
    }

    private void setFats(Integer fats) {
        Fats = fats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return applicationUser.equals(meal.applicationUser) && MealDate.equals(meal.MealDate) && MealWeight.equals(meal.MealWeight) && mealData.equals(meal.mealData) && Calories.equals(meal.Calories) && Carbs.equals(meal.Carbs) && Proteins.equals(meal.Proteins) && Fats.equals(meal.Fats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationUser, MealDate, MealWeight, mealData, Calories, Carbs, Proteins, Fats);
    }
}
