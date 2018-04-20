package codeclan.com.eatit.Models;

import java.util.Date;

/**
 * Created by user on 30/03/2018.
 */

public class FoodLogItem {

    private Date date;
    private Food food;
    private Meal meal;
    private String mealTime;

    public FoodLogItem(Date date, Food food, String mealTime) {
        this.date = date;
        this.food = food;
        this.meal = null;
        this.mealTime = mealTime;
    }

    public FoodLogItem(Date date, Meal meal, String mealTime) {
        this.date = date;
        this.food = null;
        this.meal = meal;
        this.mealTime = mealTime;
    }

    public Date getDate(){
        return date;
    }

    public String getMealTime(){
        return mealTime;
    }

    public String getName(){
        if(food == null){
            return meal.getName();
        } else return food.getName();
    }

    public String getSummary(){
        if(food == null){
            return meal.getSummary();
        } else return food.getSummary();
    }

    public Integer getkCals(){
        if(food == null){
            return meal.getkCals();
        } else return food.getkCals();
    }

    public Integer getWater(){
        if(food == null){
            return meal.getWater();
        } else return food.getWater();
    }

    public Integer getFV(){
        if(food == null){
            return meal.getFruitVeg();
        } else if (food.getFruitVeg()) {
            return 1;
        } else return 0;
    }
}
