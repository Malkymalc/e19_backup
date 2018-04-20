package codeclan.com.eatit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

import codeclan.com.eatit.DB.DBHandler;
import codeclan.com.eatit.Models.Food;
import codeclan.com.eatit.Models.FoodLog;
import codeclan.com.eatit.Models.FoodLogItem;
import codeclan.com.eatit.Models.Meal;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private DBHandler db;

    private TextView kCalsOutput;
    private TextView waterOutput;
    private TextView fvOutput;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // 1. Create new foodlog with data from db foodlog table.
        db = DBHandler.getInstance(this);
        ArrayList<FoodLogItem> foodLogList = db.getFoodLog();
        FoodLog foodLog = new FoodLog();
        foodLog.addFoodLogList(foodLogList);

        // 2. Get ArrayList<FoodLogItems> for today's date
        ArrayList<FoodLogItem> todaysEats = foodLog.getEatenByDay(new Date());


        // 3. Get summaries of these lists from foodlog.
        Integer kCalsToday = foodLog.getkCalsSum(todaysEats);
        Integer waterToday = foodLog.getWaterSum(todaysEats);
        Integer fvToday = foodLog.getFVSum(todaysEats);

        // 4. populate TextView with summaries.
        kCalsOutput = findViewById(R.id.main_kCals_output);
        kCalsOutput.setText(kCalsToday.toString());
        waterOutput = findViewById(R.id.main_water_output);
        waterOutput.setText(waterToday.toString());
        fvOutput = findViewById(R.id.main_fv_output);
        fvOutput.setText(fvToday.toString());

//      5. populate listview with foodlog entries.

         //1. Get the data we need to populate the list view
        // Done

        // 2. Instantiate an instance of the "AllFoodsListAdapter" ListAdapter class
        MainListAdapter mainListAdapter = new MainListAdapter(this, todaysEats);

        // 3. Get the listView component and set it's adapter to the allFoodsListAdapter instance in (2.)
        ListView listView = findViewById(R.id.main_list);
        listView.setAdapter(mainListAdapter);


        //=====================  Bottom Nav  Bar  ======================//
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        disableShiftMode(navigation);

        navigation.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_eat:
                        intent = new Intent(MainActivity.this, AddEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_add:
                        intent = new Intent(MainActivity.this, AllEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_stats:
                        intent = new Intent(MainActivity.this, DataActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_settings:
                        intent = new Intent(MainActivity.this, LogActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });

        Menu navMenu = navigation.getMenu();
        MenuItem navMenuItem = navMenu.getItem(0);
        navMenuItem.setChecked(true);
        //======================  Bottom Nav Bar  =======================//
    }


    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

}
