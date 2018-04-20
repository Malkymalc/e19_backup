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
import codeclan.com.eatit.Models.Food;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by user on 25/03/2018.
 */

public class AllFoodsListAdapter extends ArrayAdapter<Food> {

    public AllFoodsListAdapter(Context context, ArrayList<Food> list){
        super(context, 0, list);

    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        final Food currentFood = getItem(position);


        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_all_foods_item, parent, false);
        }

        //============  Basic setup for the list view item  ============//
        TextView name = listItemView.findViewById(R.id.food_name);
        name.setText(currentFood.getName());

        TextView summary = listItemView.findViewById(R.id.food_summary);
        summary.setText(currentFood.getSummary());

        Button eatButton = listItemView.findViewById(R.id.eat_button);
        eatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DBHandler db = DBHandler.getInstance(getContext());

                db.addEatFood(new Date(), currentFood, "Breakfast");
                String confirmation = String.format("%s added to food log", currentFood.getName());
                Toast.makeText(getContext(), confirmation, Toast.LENGTH_LONG).show();
            }
        });

        Button detailsButton = listItemView.findViewById(R.id.details_button);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AllFoodsDetailActivity.class);
                intent.putExtra("food", currentFood);
                startActivity(getContext(),intent,null);
            }
        });

        //============  Basic setup up for the list view item  ============//

        // set tag to current food so that we can access this
        listItemView.setTag(currentFood);

        // return the listItemView
        return listItemView;
    }
}
