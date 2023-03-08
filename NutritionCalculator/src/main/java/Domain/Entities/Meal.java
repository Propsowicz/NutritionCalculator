package Domain.Entities;

import Domain.Entities.Base.DomainEventsData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Meal extends DomainEventsData {
    @JoinColumn(name = "ApplicationUserId", nullable = false)
    @ManyToOne
    public ApplicationUser applicationUser;

    @Column(nullable = false)
    public LocalDate Date;

    @Column(nullable = false)
    @PositiveOrZero
    public Double Weight;

    @JoinColumn(name = "MealDataId", nullable = false)
    @ManyToOne
    public MealData mealData;

    @Column(nullable = false)
    @PositiveOrZero
    public Integer Calories;

    @Column(nullable = false)
    @PositiveOrZero
    public Double Carbs;

    @Column(nullable = false)
    @PositiveOrZero
    public Double Proteins;

    @Column(nullable = false)
    @PositiveOrZero
    public Double Fats;

    public Meal() {
    }

    public Meal Create (
            ApplicationUser applicationUser,
            MealData mealData,
            LocalDate date,
            Double weight,
            Integer calories,
            Double carbs,
            Double proteins,
            Double fats
    )
    {
        Meal meal = new Meal();
        meal.setId(CreateId());
        meal.setApplicationUser(applicationUser);
        meal.setMealData(mealData);
        meal.setDate(date);
        meal.setWeight(weight);
        meal.setCalories(calories);
        meal.setCarbs(carbs);
        meal.setProteins(proteins);
        meal.setFats(fats);

        meal.setCreatedOn(LocalDate.now());
        meal.setCreatedById(applicationUser.Id);

        return meal;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    private void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public LocalDate getDate() {
        return Date;
    }

    private void setDate(LocalDate mealDate) {
        Date = mealDate;
    }

    public Double getWeight() {
        return Weight;
    }

    private void setWeight(Double Weight) {
        this.Weight = Weight;
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

    public Double getCarbs() {
        return Carbs;
    }

    private void setCarbs(Double carbs) {
        Carbs = carbs;
    }

    public Double getProteins() {
        return Proteins;
    }

    private void setProteins(Double proteins) {
        Proteins = proteins;
    }

    public Double getFats() {
        return Fats;
    }

    private void setFats(Double fats) {
        Fats = fats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return applicationUser.equals(meal.applicationUser) && Date.equals(meal.Date) && Weight.equals(meal.Weight) && mealData.equals(meal.mealData) && Calories.equals(meal.Calories) && Carbs.equals(meal.Carbs) && Proteins.equals(meal.Proteins) && Fats.equals(meal.Fats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationUser, Date, Weight, mealData, Calories, Carbs, Proteins, Fats);
    }
}
