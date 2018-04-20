package codeclan.com.eatit.Models;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 24/03/2018.
 */

public class Meal implements Serializable {

    private String name;
    private String summary;
    private Boolean favourite;
    private ArrayList<Food> foods;

    private Integer fruitVeg;
    private Integer water;
    private Double fibre;

    private Integer kCals;
    private Integer carbs;
    private Integer protein;
    private Integer fat;


    public Meal(String name, String summary, Boolean favourite, ArrayList<Food> foods) {
        this.name = name;
        this.summary = summary;
        this.favourite = favourite;
        this.foods = new ArrayList<>();

        this.fruitVeg = 0;
        for (Food food: foods) {
            if (food.getFruitVeg()) fruitVeg += 1;
        }

        this.water = 0;
        for (Food food: foods) {
            water += food.getWater();
        }

        this.fibre = 0.0;
        for (Food food: foods) {
            fibre += food.getFibre();
        }

        this.kCals = 0;
        for (Food food: foods) {
            kCals += food.getkCals();
        }

        this.carbs = 0;
        for (Food food: foods) {
            carbs += food.getCarbs();
        }

        this.protein = 0;
        for (Food food: foods) {
            protein += food.getProtein();
        }

        this.fat = 0;
        for (Food food: foods) {
            fat += food.getFat();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public String getFoodsString(){
        Gson gson = new Gson();
        return gson.toJson(foods);
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public Integer getFruitVeg() {
        return fruitVeg;
    }

    public void setFruitVeg(Integer fruitVeg) {
        this.fruitVeg = fruitVeg;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public Double getFibre() {
        return fibre;
    }

    public void setFibre(Double fibre) {
        this.fibre = fibre;
    }

    public Integer getkCals() {
        return kCals;
    }

    public void setkCals(Integer kCals) {
        this.kCals = kCals;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }
}
