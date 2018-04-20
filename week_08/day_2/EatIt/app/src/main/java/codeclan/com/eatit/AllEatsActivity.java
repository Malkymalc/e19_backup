package codeclan.com.eatit;

import android.app.Activity;
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

import codeclan.com.eatit.Helpers.BottomNavHelper;

import static codeclan.com.eatit.MainActivity.disableShiftMode;

public class AllEatsActivity extends AppCompatActivity {

    private static final String TAG = "All Eats Activity";

    private AllEatsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_eats);


        //=====================  View Pager  ======================//
        mSectionsPageAdapter = new AllEatsPageAdapter(getSupportFragmentManager());

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
                        intent = new Intent(AllEatsActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_eat:
                        intent = new Intent(AllEatsActivity.this, AddEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_add:
                        intent = new Intent(AllEatsActivity.this, AllEatsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_stats:
                        intent = new Intent(AllEatsActivity.this, DataActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_settings:
                        intent = new Intent(AllEatsActivity.this, LogActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });


        Menu navMenu = navigation.getMenu();
        MenuItem navMenuItem = navMenu.getItem(2);
        navMenuItem.setChecked(true);

        //======================  Bottom Nav Bar  =======================//
    }

    private void setUpViewPager(ViewPager viewPager){
        AllEatsPageAdapter allEatsPageAdapter = new AllEatsPageAdapter(getSupportFragmentManager());
        allEatsPageAdapter.addFragment(new AllFoodsFragment(), getString(R.string.foods_tab));
        allEatsPageAdapter.addFragment(new AllMealsFragment(), getString(R.string.meals_tab));
        viewPager.setAdapter(allEatsPageAdapter);
    }





}


