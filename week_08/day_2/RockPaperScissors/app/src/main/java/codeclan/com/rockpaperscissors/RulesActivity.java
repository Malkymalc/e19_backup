//package codeclan.com.rockpaperscissors;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.TextView;
//
//public class RulesActivity extends ScoresTemplate {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rules);
//    }
//
//    public void onPlayButtonClicked(){
//        Intent intent = new Intent(this, Player1Choice.class);
//
//        intent.putExtra("Scores", scores);
//
//        Game game = new Game();
//        intent.putExtra("Game", game);
//
//        startActivity(intent);
//    }
//}
