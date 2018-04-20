package codeclan.com.eatit;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import codeclan.com.eatit.DB.DBHandler;
import codeclan.com.eatit.Models.FoodLog;
import codeclan.com.eatit.Models.FoodLogItem;

import static codeclan.com.eatit.MainActivity.disableShiftMode;

public class LogActivity extends AppCompatActivity {

    Intent intent;

    EditText date;
    DatePickerDialog datePickerDialog;
    int mYear;
    int mMonth;
    int mDay;

    DBHandler db;

    private TextView kCalsOutput;
    private TextView waterOutput;
    private TextView fvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_activity);

        //=====================  Date Picker  ======================//

        // initiate the date picker and a button
        date = findViewById(R.id.foodlog_datepicker);
        date.setInputType(InputType.TYPE_NULL);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR); // current year
                mMonth = c.get(Calendar.MONTH); // current month
                mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(LogActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

                db = DBHandler.getInstance(getApplicationContext());
                ArrayList<FoodLogItem> foodLogList = db.getFoodLog();
                FoodLog foodLog = new FoodLog();
                foodLog.addFoodLogList(foodLogList);
                ArrayList<FoodLogItem> foodsEaten = foodLog.getEatenByDay(mDay, mMonth, mYear);

                // Populate the summary stats
                // 3. Get summaries of these lists from foodlog.
                Integer kCalsToday = foodLog.getkCalsSum(foodsEaten);
                Integer waterToday = foodLog.getWaterSum(foodsEaten);
                Integer fvToday = foodLog.getFVSum(foodsEaten);

                // 4. populate TextView with summaries.
                kCalsOutput = findViewById(R.id.foodlog_kCal_Calc);
                kCalsOutput.setText(kCalsToday.toString());
                waterOutput = findViewById(R.id.foodlog_water_cal);
                waterOutput.setText(waterToday.toString());
                fvOutput = findViewById(R.id.foodlog_fv_calc);
                fvOutput.setText(fvToday.toString());

                // Populate the list
                //1. Get the data we need to populate the list view
                // Done

                // 2. Instantiate an instance of the "AllFoodsListAdapter" ListAdapter class
                LogListAdapter logListAdapter = new LogListAdapter(getApplicationContext(), foodsEaten);

                // 3. Get the listView component and set it's adapter to the allFoodsListAdapter instance in (2.)
                ListView listView = findViewById(R.id.foodlog_list);
                listView.setAdapter(logListAdapter);
            }

        });
        //=====================  Date Picker  ======================//


        //=====================  Default Setup  ======================//
        db = DBHandler.getInstance(getApplicationContext());
        ArrayList<FoodLogItem> foodLogList = db.getFoodLog();
        Log.d("dbList", db.getDatabaseName());
        Log.d("dbList", String.valueOf(db.getFoodLog().isEmpty()));
        FoodLog initial = new FoodLog();


        Integer kCalsToday = initial.getkCalsSum(foodLogList);
        Integer waterToday = initial.getWaterSum(foodLogList);
        Integer fvToday = initial.getFVSum(foodLogList);
        Log.d("fvToday", fvToday.toString());

        // 4. populate TextView with summaries.
        kCalsOutput = findViewById(R.id.foodlog_kCal_Calc);
        kCalsOutput.setText(kCalsToday.toString());
        waterOutput = findViewById(R.id.foodlog_water_cal);
        waterOutput.setText(waterToday.toString());
        fvOutput = findViewById(R.id.foodlog_fv_calc);
        fvOutput.setText(fvToday.toString());

        // Populate the list
        //1. Get the data we need to populate the list view
        // Done

        // 2. Instantiate an instance of the "AllFoodsListAdapter" ListAdapter class
        LogListAdapter logListAdapter = new LogListAdapter(getApplicationContext(), foodLogList);

        // 3. Get the listView component and set it's adapter to the allFoodsListAdapter instance in (2.)
        ListView listView = findViewById(R.id.foodlog_list);
        listView.setAdapter(logListAdapter);


        //=====================  Default Setup  ======================//


        //=====================  Bottom Nav Bar  ======================//

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        disableShiftMode(navigation);

        navigation.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        intent = new Intent(LogActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_eat:
                        intent = new Intent(LogActivity.this, AddEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_add:
                        intent = new Intent(LogActivity.this, AllEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_stats:
                        intent = new Intent(LogActivity.this, DataActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_settings:
                        intent = new Intent(LogActivity.this, LogActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });


        Menu navMenu = navigation.getMenu();
        MenuItem navMenuItem = navMenu.getItem(4);
        navMenuItem.setChecked(true);

        //======================  Bottom Nav Bar  =======================//
    }
}
