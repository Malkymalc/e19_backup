package codeclan.com.eatit.Models;

import java.util.ArrayList;

/**
 * Created by user on 24/03/2018.
 */

public class FoodList {

    ArrayList<Food> foodsList;
    ArrayList<Meal> mealsList;

    public FoodList(ArrayList<Food> foodsList, ArrayList<Meal> mealsList) {
        this.foodsList = foodsList;
        this.mealsList = mealsList;
    }

    public ArrayList<Food> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(ArrayList<Food> foodsList) {
        this.foodsList = foodsList;
    }

    public ArrayList<Meal> getMealsList() {
        return mealsList;
    }

    public void setMealsList(ArrayList<Meal> mealsList) {
        this.mealsList = mealsList;
    }
}
