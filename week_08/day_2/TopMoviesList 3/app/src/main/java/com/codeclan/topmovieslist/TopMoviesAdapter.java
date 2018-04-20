package com.codeclan.topmovieslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user on 20/03/2018.
 */

public class TopMoviesAdapter extends ArrayAdapter<Movie> {

    public TopMoviesAdapter(Context context, ArrayList<Movie> list){
        super(context, 0, list);

    }

    // We override the getView() method of ArrayAdapter class.
    // This method takes in a position, listItemView and VeiwGroup, and returns a listte
    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        // set the current movie using the **position** arg passed in.
        Movie currentMovie = getItem(position);

        // Create a blank view if we need one (if one has not been instantiated)
        if (listItemView == null) {
            //                          (what view to create, ??, ??)
            // listItemView = new View (movie_item.xml, parent, attachToRoot)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);
        }

        // fill the **listItemView** we've been passed / created above,
        //  using info from  the currentMovie (based on the **position** arg passed in).
        TextView ranking = listItemView.findViewById(R.id.ranking);
        ranking.setText(currentMovie.getRanking().toString());

        TextView title = listItemView.findViewById(R.id.title);
        title.setText(currentMovie.getTitle());

        TextView year = listItemView.findViewById(R.id.year);
        year.setText(currentMovie.getYear().toString());

        listItemView.setTag(currentMovie);

        // return the listItemView
        return listItemView;
    }
}
