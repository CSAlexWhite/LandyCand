package sweetworld.landycand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        console = (TextView) findViewById(R.id.textView2);

        final Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                go(console);
            }
        });
    }

    public void go(TextView c){

        console.setText("What in the holy hell?");

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        console.setText("WHAT THE FUCK DUDE??");
                        Game test = new Game(console, getApplicationContext(), "cfg/cards.dat", "cfg/board.dat", 4);
                        test.run();
                    }
                });
            }
        };
        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
