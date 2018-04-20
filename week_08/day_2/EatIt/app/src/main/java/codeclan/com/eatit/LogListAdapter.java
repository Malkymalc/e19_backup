package codeclan.com.eatit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import codeclan.com.eatit.Models.FoodLogItem;

/**
 * Created by user on 30/03/2018.
 */

public class LogListAdapter extends ArrayAdapter<FoodLogItem> {

    public LogListAdapter(Context context, ArrayList<FoodLogItem> list){
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        final FoodLogItem foodLogItem = getItem(position);

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.main_list_foodlog_item, parent, false);
        }

        //============  Basic setup for the list view item  ============//
        TextView name = listItemView.findViewById(R.id.main_food_name);
        name.setText(foodLogItem.getName());

        TextView summary = listItemView.findViewById(R.id.main_food_summary);
        summary.setText(foodLogItem.getSummary());

        TextView mealTime = listItemView.findViewById(R.id.main_food_mealTime);
        mealTime.setText(foodLogItem.getMealTime());

        TextView kCals = listItemView.findViewById(R.id.main_food_kCals);
        kCals.setText(foodLogItem.getkCals().toString());


        //============  Basic setup up for the list view item  ============/

        return listItemView;
    }

}
