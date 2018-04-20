package codeclan.com.eatit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import codeclan.com.eatit.Models.Meal;

import static codeclan.com.eatit.MainActivity.disableShiftMode;

public class AllMealsDetailActivity extends AppCompatActivity {


    private Meal meal;
    private TextView mealName;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_meal_detail);

        meal = (Meal) getIntent().getSerializableExtra("meal");

        mealName = findViewById(R.id.meal_name);
        mealName.setText(meal.getName());

        //=====================  Bottom Nav  Bar  ======================//

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        disableShiftMode(navigation);

        navigation.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_eat:
                        intent = new Intent(AllMealsDetailActivity.this, AllEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_add:
                        intent = new Intent(AllMealsDetailActivity.this, AddEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_stats:
                        intent = new Intent(AllMealsDetailActivity.this, DataActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_settings:
                        intent = new Intent(AllMealsDetailActivity.this, LogActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });


        Menu navMenu = navigation.getMenu();
        MenuItem navMenuItem = navMenu.getItem(1);
        navMenuItem.setChecked(true);

        //======================  Bottom Nav Bar  =======================//


    }

}
