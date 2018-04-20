package com.codeclan.topmovieslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get the data we need to populate the list view
        TopMovies topMovies = new TopMovies();
        ArrayList<Movie> list = topMovies.getList();

        // 2. Instantiate a new adapter
        TopMoviesAdapter topMoviesAdapter = new TopMoviesAdapter(this, list);

        // 3.
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(topMoviesAdapter);
    }

    public void onItemClick(View listItem){
        Movie selectedMovie = (Movie) listItem.getTag();

        Log.d("Main Activity", selectedMovie.getTitle());

        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra("movie", selectedMovie);
        startActivity(intent);
    }

}
