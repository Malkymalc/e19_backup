package codeclan.com.eatit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import codeclan.com.eatit.DB.DBHandler;
import codeclan.com.eatit.Models.Meal;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by user on 25/03/2018.
 */

public class AllMealsListAdapter extends ArrayAdapter<Meal> {

    public AllMealsListAdapter(Context context, ArrayList<Meal> list){
        super(context, 0, list);

    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        final Meal currentMeal = getItem(position);


        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_all_meals_item, parent, false);
        }


        //============  Basic setup for the list view item  ============//
        TextView name = listItemView.findViewById(R.id.meal_name);
        name.setText(currentMeal.getName());

        TextView summary = listItemView.findViewById(R.id.meal_summary);
        summary.setText(currentMeal.getSummary());

        Button mealEatButton = listItemView.findViewById(R.id.meal_eat_button);
        mealEatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DBHandler db = DBHandler.getInstance(getContext());
                db.addEatMeal(new Date(), currentMeal, "Breakfast");
                String confirmation = String.format("%s added to food log", currentMeal.getName());
                Toast.makeText(getContext(), confirmation, Toast.LENGTH_LONG).show();
            }
        });

        Button mealDetailsButton = listItemView.findViewById(R.id.meal_detail_button);
        mealDetailsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AllMealsDetailActivity.class);
                intent.putExtra("meal", currentMeal);
                startActivity(getContext(),intent,null);
            }
        });

        //============  Basic setup up for the list view item  ============//

        listItemView.setTag(currentMeal);

        // return the listItemView
        return listItemView;
    }
}
