package codeclan.com.eatit.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import codeclan.com.eatit.Models.Food;
import codeclan.com.eatit.Models.FoodLogItem;
import codeclan.com.eatit.Models.Meal;

import static android.content.ContentValues.TAG;

/**
 * Created by user on 25/03/2018.
 */

public class DBHandler extends SQLiteOpenHelper {

    SQLiteDatabase mDatabase;

    //information of databas
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "eatItDB.db";

    public static final String TABLE_DEFAULTFOODS = "DefaultFoods";
    public static final String COLUMN_FOOD_ID = "ID";
    public static final String COLUMN_FOOD_NAME = "Name";
    public static final String COLUMN_FOOD_SUMMARY = "Summary";
    public static final String COLUMN_FOOD_FAVOURITE = "Favourite";
    public static final String COLUMN_FOOD_FRUITVEG = "FruitVeg";
    public static final String COLUMN_FOOD_WATER = "Water";
    public static final String COLUMN_FOOD_FIBRE = "Fibre";
    public static final String COLUMN_FOOD_KCALS = "KCals";
    public static final String COLUMN_FOOD_CARBS = "Carbs";
    public static final String COLUMN_FOOD_PROTEIN = "Protein";
    public static final String COLUMN_FOOD_FAT = "Fat";

    public static final String TABLE_USERFOODS = "UserFoods";

    public static final String TABLE_USERMEALS = "UserMeals";
    public static final String COLUMN_MEAL_ID = "ID";
    public static final String COLUMN_MEAL_NAME = "Name";
    public static final String COLUMN_MEAL_SUMMARY = "Summary";
    public static final String COLUMN_MEAL_FAVOURITE = "Favourite";
    public static final String COLUMN_MEAL_FOODS = "Foods";

    public static final String TABLE_FOODLOG = "FoodLog";
    public static final String COLUMN_FOODLOG_ID = "ID";
    public static final String COLUMN_FOODLOG_DATE = "Date";
    public static final String COLUMN_FOODLOG_EAT = "Eatable";
    public static final String COLUMN_FOODLOG_FOODBOOL = "FoodOrMeal";
    public static final String COLUMN_FOODLOG_MEAL = "MealTime";

    private static DBHandler sInstance;

    public static synchronized DBHandler getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBHandler(context.getApplicationContext(), DATABASE_NAME, null, DATABASE_VERSION);
        }
        return sInstance;
    }

    //initialize the database
    private DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_DEFAULTFOODS = "CREATE TABLE " + TABLE_DEFAULTFOODS
                + "("
                + COLUMN_FOOD_ID + " INTEGER PRIMARYKEY,"
                + COLUMN_FOOD_NAME + " TEXT,"
                + COLUMN_FOOD_SUMMARY + " TEXT,"
                + COLUMN_FOOD_FAVOURITE + " BOOLEAN,"
                + COLUMN_FOOD_FRUITVEG + " INTEGER,"
                + COLUMN_FOOD_WATER + " INTEGER,"
                + COLUMN_FOOD_FIBRE + " DOUBLE,"
                + COLUMN_FOOD_KCALS + " INTEGER,"
                + COLUMN_FOOD_CARBS + " INTEGER,"
                + COLUMN_FOOD_PROTEIN + " INTEGER,"
                + COLUMN_FOOD_FAT + " INTEGER"
                + ")";
        db.execSQL(CREATE_DEFAULTFOODS);

        Food apple = new Food("Apple", "an apple", true, true, 0, 0.0, 50, 11, 1, 0);
        addDefaultFood(apple, db);
        Food banana = new Food("Banana", "a banana", false, true, 0, 0.0, 80, 19, 1, 0);
        addDefaultFood(banana, db);
        Food kale = new Food("Kale", "some Kale", true, true, 0, 3.5, 20, 4, 1, 0);
        addDefaultFood(kale, db);
        Food Chicken = new Food("Chicken", "Uncooked, 100g", true, false, 0, 0.0, 89, 0, 20, 1);
        addDefaultFood(Chicken, db);
        Food Beef = new Food("Beef", "Uncooked, 100g", true, false, 0, 0.0, 98, 0, 20, 2);
        addDefaultFood(Beef, db);


        String CREATE_USERFOODS = "CREATE TABLE " + TABLE_USERFOODS
                + "("
                + COLUMN_FOOD_ID + " INTEGER PRIMARYKEY,"
                + COLUMN_FOOD_NAME + " TEXT,"
                + COLUMN_FOOD_SUMMARY + " TEXT,"
                + COLUMN_FOOD_FAVOURITE + " BOOLEAN,"
                + COLUMN_FOOD_FRUITVEG + " INTEGER,"
                + COLUMN_FOOD_WATER + " INTEGER,"
                + COLUMN_FOOD_FIBRE + " DOUBLE,"
                + COLUMN_FOOD_KCALS + " INTEGER,"
                + COLUMN_FOOD_CARBS + " INTEGER,"
                + COLUMN_FOOD_PROTEIN + " INTEGER,"
                + COLUMN_FOOD_FAT + " INTEGER"
                + ")";
        db.execSQL(CREATE_USERFOODS);


        String CREATE_USERMEALS = "CREATE TABLE " + TABLE_USERMEALS
                + "("
                + COLUMN_MEAL_ID + " INTEGER PRIMARYKEY,"
                + COLUMN_MEAL_NAME + " TEXT,"
                + COLUMN_MEAL_SUMMARY + " TEXT,"
                + COLUMN_MEAL_FAVOURITE + " BOOLEAN,"
                + COLUMN_MEAL_FOODS + " TEXT"
                + ")";
        db.execSQL(CREATE_USERMEALS);


        String CREATE_FOODLOG = "CREATE TABLE " + TABLE_FOODLOG
                + "("
                + COLUMN_FOODLOG_ID + " INTEGER PRIMARYKEY,"
                + COLUMN_FOODLOG_DATE + " DATE,"
                + COLUMN_FOODLOG_EAT + " TEXT,"
                + COLUMN_FOODLOG_FOODBOOL + " BOOLEAN,"
                + COLUMN_FOODLOG_MEAL + " TEXT"
                + ")";
        db.execSQL(CREATE_FOODLOG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEFAULTFOODS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERFOODS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERMEALS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODLOG);
            onCreate(db);
        }
    }

    //=====================  CREATE METHODS  ======================//

    public void addDefaultFood(Food food, SQLiteDatabase db) {

        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(COLUMN_FOOD_NAME, food.getName());
            values.put(COLUMN_FOOD_SUMMARY, food.getSummary());
            values.put(COLUMN_FOOD_FAVOURITE, food.getFavourite());
            values.put(COLUMN_FOOD_FRUITVEG, food.getFruitVeg());
            values.put(COLUMN_FOOD_WATER, food.getWater());
            values.put(COLUMN_FOOD_FIBRE, food.getFibre());
            values.put(COLUMN_FOOD_KCALS, food.getkCals());
            values.put(COLUMN_FOOD_CARBS, food.getCarbs());
            values.put(COLUMN_FOOD_PROTEIN, food.getProtein());
            values.put(COLUMN_FOOD_FAT, food.getFat());

            db.insertOrThrow(TABLE_DEFAULTFOODS, null, values);
            db.setTransactionSuccessful();

        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add DEFAULT_FOOD to database");
        } finally {
            db.endTransaction();
        }
    }

    public void addUserFood(Food food) {

        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(COLUMN_FOOD_NAME, food.getName() );
            values.put(COLUMN_FOOD_SUMMARY, food.getSummary() );
            values.put(COLUMN_FOOD_FAVOURITE, food.getFavourite() );
            values.put(COLUMN_FOOD_FRUITVEG, food.getFruitVeg() );
            values.put(COLUMN_FOOD_WATER, food.getWater() );
            values.put(COLUMN_FOOD_FIBRE, food.getFibre() );
            values.put(COLUMN_FOOD_KCALS, food.getkCals() );
            values.put(COLUMN_FOOD_CARBS, food.getCarbs() );
            values.put(COLUMN_FOOD_PROTEIN, food.getProtein() );
            values.put(COLUMN_FOOD_FAT, food.getFat() );

            db.insertOrThrow(TABLE_USERFOODS, null, values);
            db.setTransactionSuccessful();

        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add USER_FOOD to database");
        } finally {
            db.endTransaction();
        }
    }

    public void addMeal(Meal meal) {
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(COLUMN_MEAL_NAME, meal.getName());
            values.put(COLUMN_MEAL_SUMMARY, meal.getSummary());
            values.put(COLUMN_MEAL_FAVOURITE, meal.getFavourite());
            values.put(COLUMN_MEAL_FOODS, meal.getFoodsString());

            db.insertOrThrow(TABLE_USERMEALS, null, values);
            db.setTransactionSuccessful();

        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add USER_MEAL to database");
        } finally {
            db.endTransaction();
        }
    }


    public void addEatFood(Date date, Food food, String mealtime) {
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {

            Gson gson = new Gson();

            String s= gson.toJson(food);

            ContentValues values = new ContentValues();
            values.put(COLUMN_FOODLOG_DATE, String.valueOf(date));
            values.put(COLUMN_FOODLOG_EAT, s);
            values.put(COLUMN_FOODLOG_FOODBOOL, 1);
            values.put(COLUMN_FOODLOG_MEAL, mealtime);
            Log.d("inDB", "adding" + food.getName());
            db.insertOrThrow(TABLE_FOODLOG, null, values);
            Log.d("inDB", "past insertOrThrow Method");
            db.setTransactionSuccessful();
            Log.d("inDB", "past setTransactionSuccessful Method");

        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add USER_EAT to database");
        } finally {
            Log.d("inDB", "about to end db Transaction");
            db.endTransaction();
            db.close();
        }
    }

    public void addEatMeal(Date date, Meal meal, String mealtime) {
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {

            Gson gson = new Gson();
            String s = gson.toJson(meal);
            ContentValues values = new ContentValues();
            values.put(COLUMN_FOODLOG_DATE, String.valueOf(date));
            values.put(COLUMN_FOODLOG_EAT, s);
            values.put(COLUMN_FOODLOG_FOODBOOL, 0);
            values.put(COLUMN_FOODLOG_MEAL, mealtime);

            db.insertOrThrow(TABLE_FOODLOG, null, values);
            db.setTransactionSuccessful();

        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add USER_EAT to database");
        } finally {
            db.endTransaction();
        }
    }

    //=====================  CREATE METHODS  ======================//


    //=====================  READ METHODS  ======================//


    public ArrayList<Food> getAllfoods() {
        ArrayList<Food> allFoods = new ArrayList<>();

        String ALL_FOOD_SELECT_QUERY =
                String.format("SELECT * FROM %s UNION ALL SELECT * FROM %s", TABLE_DEFAULTFOODS, TABLE_USERFOODS);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(ALL_FOOD_SELECT_QUERY, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME));
                    String summary = cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_SUMMARY));
                    String favourite = cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_FAVOURITE));
                    Boolean favouriteBool = favourite.equals("true");
                    String fruitveg = cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_FRUITVEG));
                    Boolean fruitvegBool = fruitveg.equals("true");
                    Integer water = Integer.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_WATER)));
                    Double fibre = Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_FIBRE)));
                    Integer kCals = Integer.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_KCALS)));
                    Integer carbs = Integer.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_CARBS)));
                    Integer protein = Integer.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_PROTEIN)));
                    Integer fat = Integer.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_FAT)));

                    Food food = new Food(name, summary, favouriteBool, fruitvegBool, water, fibre, kCals, carbs, protein, fat);
                    allFoods.add(food);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get ALL FOODS from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return allFoods;
    }

    public ArrayList<Meal> getAllMeals() {
        ArrayList<Meal> allMeals = new ArrayList<>();

        String ALL_MEALS_SELECT_QUERY =
                String.format("SELECT * FROM %s", TABLE_USERMEALS);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(ALL_MEALS_SELECT_QUERY, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    String mealName = cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_NAME));
                    String summary = cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_SUMMARY));
                    String favourite = cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_FAVOURITE));
                    Boolean favouriteBool = favourite.equals("true");
                    String foodsString = cursor.getString(cursor.getColumnIndex(COLUMN_FOOD_FAVOURITE));
                    Gson gson = new Gson();
                    ArrayList<Food> foods = gson.fromJson(foodsString, ArrayList.class);

                    Meal meal = new Meal(mealName, summary, favouriteBool, foods);
                    allMeals.add(meal);

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get ALL MEALS from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return allMeals;
    }

    public ArrayList<FoodLogItem> getFoodLog() {
        ArrayList<FoodLogItem> foodLog = new ArrayList<>();

        String FOODLOG_SELECT_QUERY =
                String.format("SELECT * FROM %s", TABLE_FOODLOG);
        Log.d("in DB",  "running query"+ FOODLOG_SELECT_QUERY);
        SQLiteDatabase db = getReadableDatabase();



        Cursor cursor = db.rawQuery(FOODLOG_SELECT_QUERY, null);



        try {
            if (cursor.moveToFirst()) {
                do {
                    String dateString = cursor.getString(cursor.getColumnIndex(COLUMN_FOODLOG_DATE));
                    Gson gson = new Gson();
                    Log.e(TAG, dateString);
                    Date date =  new Date(dateString); //gson.fromJson(dateString, Date.class);

                    String mealTime = cursor.getString(cursor.getColumnIndex(COLUMN_FOODLOG_MEAL));

                    Integer foodBool = cursor.getInt(cursor.getColumnIndex(COLUMN_FOODLOG_FOODBOOL));
                    String eatString = cursor.getString(cursor.getColumnIndex(COLUMN_FOODLOG_EAT));

                    Log.e("t", eatString);

                    FoodLogItem item;
                    if (foodBool == 1) {
                        item = new FoodLogItem(date, gson.fromJson(eatString, Food.class), mealTime);
                    } else {
                       item = new FoodLogItem(date, gson.fromJson(eatString, Meal.class), mealTime);
                    }

                    Log.e("tag", "Adding item: " + item.getName());
                    foodLog.add(item);

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e(TAG, "ERROR: " + e.getMessage());
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        Log.e("Tag", "Size: " + foodLog.size() );
        return foodLog;
    }


    //=====================  READ METHODS  ======================//



}


