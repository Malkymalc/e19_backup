package codeclan.com.eatit;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import codeclan.com.eatit.DB.DBHandler;
import codeclan.com.eatit.Models.Food;

/**
 * Created by user on 29/03/2018.
 */

public class AddFoodFragment extends Fragment {

    private EditText inputName;
    private EditText inputSummary;
    private Switch inputFav;
    private Switch inputFoV;
    private EditText inputWater;
    private EditText inputFibre;
    private EditText inputkCals;
    private EditText inputProtein;
    private EditText inputCarbs;
    private EditText inputFat;

    private Button saveFoodButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_food_fragment, container, false);

        // Set up form to add details for new food;
//        inputName = view.findViewById(R.id.createf_iname);
//        inputSummary = view.findViewById(R.id.createf_isummary);
//        inputFav = view.findViewById(R.id.createf_ifavourite);
//        inputFoV = view.findViewById(R.id.createf_ifov);
//        inputWater = view.findViewById(R.id.createf_iwater);
//        inputFibre = view.findViewById(R.id.createf_ifibre);
//        inputkCals = view.findViewById(R.id.createf_ikcals);
//        inputProtein = view.findViewById(R.id.createf_iprotein);
//        inputCarbs = view.findViewById(R.id.createf_icarbs);
//        inputFat = view.findViewById(R.id.createf_ifat);
//
//        saveFoodButton = view.findViewById(R.id.createf_save);

        return view;
    }

    public void onSaveFoodButtonClick(){
        String foodName = inputName.getText().toString();
        String foodSummary = inputSummary.getText().toString();
        Boolean foodFav = inputFav.isChecked();
        Boolean foodFoV = inputFoV.isChecked();
        Integer foodWater = Integer.parseInt(inputWater.getText().toString());
        Double foodFibre = Double.parseDouble(inputFibre.getText().toString());
        Integer foodkCals = Integer.parseInt(inputkCals.getText().toString());
        Integer foodProtein = Integer.parseInt(inputProtein.getText().toString());
        Integer foodCarbs = Integer.parseInt(inputCarbs.getText().toString());
        Integer foodFat = Integer.parseInt(inputFat.getText().toString());

        Food newFood = new Food(foodName, foodSummary, foodFav, foodFoV, foodWater, foodFibre, foodkCals, foodProtein, foodCarbs, foodFat);

        DBHandler db = DBHandler.getInstance(getContext());
        db.addUserFood(newFood);


        Intent intent = new Intent(getContext(), AllEatsActivity.class);
        startActivity(intent);
    }


}
