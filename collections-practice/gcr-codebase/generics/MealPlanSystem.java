interface MealPlan {
    String getMealDetails();
}
// Different Meal Types
class VegetarianMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegetarian Meal: Rice, Vegetables, Lentils";
    }
}
class VeganMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegan Meal: Quinoa, Beans, Salad";
    }
}
class KetoMeal implements MealPlan {
    public String getMealDetails() {
        return "Keto Meal: Eggs, Avocado, Cheese";
    }
}
// Generic Meal Handler
class Meal<T extends MealPlan> {
    private T meal;
    public Meal(T meal) {
        this.meal = meal;
    }
    public T getMeal() {
        return meal;
    }
}
// Generic Validator & Generator
class MealGenerator {
    public static <T extends MealPlan> void generateMeal(T meal) {
        System.out.println("Generated Meal Plan:");
        System.out.println(meal.getMealDetails());
    }
}
// Main Class
public class MealPlanSystem {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        MealGenerator.generateMeal(vegMeal.getMeal());
        MealGenerator.generateMeal(veganMeal.getMeal());
        MealGenerator.generateMeal(ketoMeal.getMeal());
    }
}
