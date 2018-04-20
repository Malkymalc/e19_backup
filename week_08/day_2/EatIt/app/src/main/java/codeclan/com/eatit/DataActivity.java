package codeclan.com.eatit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static codeclan.com.eatit.MainActivity.disableShiftMode;

public class DataActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);

        //=====================  Bottom Nav Bar  ======================//

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        disableShiftMode(navigation);

        navigation.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        intent = new Intent(DataActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_eat:
                        intent = new Intent(DataActivity.this, AddEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_add:
                        intent = new Intent(DataActivity.this, AllEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_stats:
                        intent = new Intent(DataActivity.this, DataActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_settings:
                        intent = new Intent(DataActivity.this, LogActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });


        Menu navMenu = navigation.getMenu();
        MenuItem navMenuItem = navMenu.getItem(3);
        navMenuItem.setChecked(true);

        //======================  Bottom Nav Bar  =======================//
    }
}
