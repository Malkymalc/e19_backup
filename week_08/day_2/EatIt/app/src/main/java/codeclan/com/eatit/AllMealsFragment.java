package codeclan.com.eatit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import codeclan.com.eatit.DB.DBHandler;
import codeclan.com.eatit.Models.Meal;

/**
 * Created by user on 28/03/2018.
 */

public class AllMealsFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_all_meals_fragment, container, false);

        // 1. Get the data we need to populate the list view
        DBHandler db = DBHandler.getInstance(getContext());
        ArrayList<Meal> allMeals = db.getAllMeals();

        // 2. Instantiate an instance of the "AllFoodsListAdapter" ListAdapter class
        AllMealsListAdapter allMealsListAdapter = new AllMealsListAdapter(getContext(), allMeals);

        // 3. Get the listView component and set it's adapter to the allFoodsListAdapter instance in (2.)
        ListView listView = view.findViewById(R.id.all_meals_list);
        listView.setAdapter(allMealsListAdapter);


        return view;
    }


}