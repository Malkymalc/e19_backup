package codeclan.com.eatit.Models;

import java.io.Serializable;

/**
 * Created by user on 24/03/2018.
 */

public class Food implements Serializable {

    private String name;
    private String summary;
    private Boolean favourite;

    private Boolean fruitVeg;
    private Integer water;
    private Double fibre;

    private Integer kCals;
    private Integer carbs;
    private Integer protein;
    private Integer fat;

    public Food(String name, String summary, Boolean favourite, Boolean fruitVeg, Integer water, Double fibre, Integer kCals, Integer carbs, Integer protein, Integer fat) {
        this.name = name;
        this.summary = summary;
        this.favourite = favourite;
        this.fruitVeg = fruitVeg;
        this.water = water;
        this.fibre = fibre;
        this.kCals = kCals;
        this.carbs = carbs;
        this.protein = protein;
        this.fat = fat;
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

    public Boolean getFruitVeg() {
        return fruitVeg;
    }

    public void setFruitVeg(Boolean fruitVeg) {
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
