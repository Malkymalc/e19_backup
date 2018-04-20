package com.codeclan.topmovieslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        // 1. Get the intent from the clicked list item on the main activity
        // 1b. The list item has a tag attached to it which contains the Movie it references
        // 1c. When it's clicked we get the Movie from the tag and add it as an extra to the intent
        Intent intent = getIntent();

        // 2a. We use getSerializableExtra() (but not putSerializableExtra() when creating the intent)
        // 2b. We cast the serializable from a Serializable back to a Movie.
        Movie selectedMovie = (Movie) intent.getSerializableExtra("movie");

        Log.d("Movie Activity", selectedMovie.getRanking().toString());

    }
}
