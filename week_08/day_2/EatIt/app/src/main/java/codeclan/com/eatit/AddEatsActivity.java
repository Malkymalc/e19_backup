package codeclan.com.eatit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import static codeclan.com.eatit.MainActivity.disableShiftMode;

public class AddEatsActivity extends AppCompatActivity {

    private static final String TAG = "Add Eats Activity";

    private AddEatsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_eats);


        //=====================  View Pager  ======================//
        mSectionsPageAdapter = new AddEatsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setUpViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        //=====================  View Pager  ======================//


        //=====================  Bottom Nav Bar  ======================//

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        disableShiftMode(navigation);

        navigation.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        intent = new Intent(AddEatsActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_eat:
                        intent = new Intent(AddEatsActivity.this, AddEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_add:
                        intent = new Intent(AddEatsActivity.this, AllEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_stats:
                        intent = new Intent(AddEatsActivity.this, DataActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_settings:
                        intent = new Intent(AddEatsActivity.this, LogActivity.class);
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

    private void setUpViewPager(ViewPager viewPager){
        AddEatsPageAdapter addEatsPageAdapter = new AddEatsPageAdapter(getSupportFragmentManager());
        addEatsPageAdapter.addFragment(new AddFoodFragment(), getString(R.string.add_new_food));
        addEatsPageAdapter.addFragment(new AddMealFragment(), getString(R.string.add_new_meal));
        viewPager.setAdapter(addEatsPageAdapter);
    }

}
