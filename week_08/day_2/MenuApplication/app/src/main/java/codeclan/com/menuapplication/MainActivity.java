package codeclan.com.menuapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

// Have this as a generic base class which other activities can inherit from,
// so that they all have the same menu etc (a template activity)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    // 1. Create a menu
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);

        return true;
    }

    @Override
    // 2a. On menu item selection method
    // 2b. This will contain an if/else chain or a switch statement, with actions for each menu option
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if (menuItem.getItemId() == R.id.action_hello){
            Toast.makeText(this, "Hello Worlds", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
