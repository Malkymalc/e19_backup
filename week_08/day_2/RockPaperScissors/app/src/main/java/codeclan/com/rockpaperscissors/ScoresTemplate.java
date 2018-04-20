//package codeclan.com.rockpaperscissors;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.TextView;
//
//public class ScoresTemplate extends AppCompatActivity {
//
//    private TextView player1Score;
//    private TextView player2Score;
//    private Scores scores;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scores_template);
//
//        player1Score = findViewById(R.id.player1_score);
//        player2Score = findViewById(R.id.player2_score);
//
//        if ( getIntent().getSerializableExtra("Scores") == null){
//            scores = new Scores();
//        } else {
//            scores = (Scores) getIntent().getSerializableExtra("Scores");
//        }
//
//        player1Score.setText(scores.getPlayer1Score());
//        player2Score.setText(scores.getPlayer2Score());
//    }
//}
