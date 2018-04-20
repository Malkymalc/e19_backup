package codeclan.com.eatit.Models;

import android.text.format.DateUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by user on 24/03/2018.
 */

public class FoodLog {

    private ArrayList<FoodLogItem> foodLog;

    public FoodLog() {
        foodLog = new ArrayList<>();
    }

    public void addFoodLogList(ArrayList<FoodLogItem> list){
        foodLog.addAll(list);
    }

    public void addFoodLogItem(FoodLogItem item){
        foodLog.add(item);
    }

    public ArrayList<FoodLogItem> getEatenByDay(Date date){
        ArrayList<FoodLogItem> result = new ArrayList<>();
        for (FoodLogItem item: foodLog) {
            if((date.getDate() == item.getDate().getDate()) &&
                    (date.getMonth() == item.getDate().getMonth()) &&
                    (date.getYear() == item.getDate().getYear())){
                result.add(item);
            }
        }
        return result;
    }

    public ArrayList<FoodLogItem> getEatenByDay(int day, int month, int year){
        ArrayList<FoodLogItem> result = new ArrayList<>();
        for (FoodLogItem item: foodLog) {
            if((day == item.getDate().getDate()) &&
                    (month == item.getDate().getMonth()) &&
                    (year == item.getDate().getYear())){
                result.add(item);
            }
        }
        return result;
    }

    public Integer getkCalsSum(ArrayList<FoodLogItem> list){
        Integer result = 0;
        for (FoodLogItem item: list) {
            result += item.getkCals();
        }
        return result;
    }

    public Integer getWaterSum(ArrayList<FoodLogItem> list){
        Integer result = 0;
        for (FoodLogItem item: list) {
            result += item.getWater();
        }
        return result;
    }

    public Integer getFVSum(ArrayList<FoodLogItem> list){
        Integer result = 0;
        for (FoodLogItem item: list) {
            Log.d("fv", item.getFV().toString());
            result += item.getFV();
        }
        return result;
    }

}
