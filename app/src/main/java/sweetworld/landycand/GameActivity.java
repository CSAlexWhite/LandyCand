package sweetworld.landycand;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                //console.setText("WHat the fuck!!");
            }
        });
    }

    public void go(TextView c){

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                console.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                console.setText(output);
            }

        }.start();
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

    String output = "**Initializing Cards**\n" +
            "\n" +
            "**Shuffling**\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 0\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Red#0\n" +
            "Nate drew a Yellow\n" +
            "Nate moved 2 spaces\n" +
            "Nate is now at position Yellow#2\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Red#0\n" +
            "Alex drew a Trip to Mint's World\n" +
            "Alex moved 17 spaces\n" +
            "Alex is now at position 17, Mint's World\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Red#0\n" +
            "Nate drew a Orange\n" +
            "Nate moved 4 spaces\n" +
            "Nate is now at position Orange#4\n" +
            "Nate is now stuck \n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Red#0\n" +
            "Alex drew a Blue\n" +
            "Alex moved 3 spaces\n" +
            "Alex is now at position Blue#3\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 1\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Yellow#2\n" +
            "Nate drew a Orange\n" +
            "Nate moved 2 spaces\n" +
            "Nate is now at position Orange#4\n" +
            "Nate is now stuck \n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at Mint's World\n" +
            "Alex drew a Orange\n" +
            "Alex moved 1 spaces\n" +
            "Alex is now at position Orange#18\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#4\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Red\n" +
            "Nate didn't get a Orange and is still stuck at Orange#4\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Blue#3\n" +
            "Alex drew a Green\n" +
            "Alex moved 2 spaces\n" +
            "Alex is now at position Green#5\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 2\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#4\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Purple\n" +
            "Nate didn't get a Orange and is still stuck at Orange#4\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Orange#18\n" +
            "Alex drew a Red\n" +
            "Alex moved 2 spaces\n" +
            "Alex is now at position Red#20\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#4\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Green\n" +
            "Nate didn't get a Orange and is still stuck at Orange#4\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Green#5\n" +
            "Alex drew a Purple\n" +
            "Alex moved 2 spaces\n" +
            "Alex is now at position Purple#7\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 3\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#4\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Trip to Plumpy's World\n" +
            "Nate moved 4 spaces\n" +
            "Nate is now at position 8, Plumpy's World\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Red#20\n" +
            "Alex drew a Blue\n" +
            "Alex moved 3 spaces\n" +
            "Alex is now at position Blue#23\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#4\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Trip to Nut's World\n" +
            "Nate moved 70 spaces\n" +
            "Nate is now at position 74, Nut's World\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#7\n" +
            "Alex drew a Purple\n" +
            "Alex moved 7 spaces\n" +
            "Alex is now at position Purple#14\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 4\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Blue#23\n" +
            "Alex drew a Yellow\n" +
            "Alex moved 5 spaces\n" +
            "Alex is now at position Yellow#28\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Nut's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Green\n" +
            "Nate didn't get a Orange and is still stuck at Orange#74\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#14\n" +
            "Alex drew a Red\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Red#20\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 5\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Green\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Yellow#28\n" +
            "Alex drew a Blue\n" +
            "Alex moved 1 spaces\n" +
            "Alex is now at position Blue#29\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Nut's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Orange\n" +
            "Nate moved 6 spaces\n" +
            "Nate is now at position Orange#80\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Red#20\n" +
            "Alex drew a Red\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Red#26\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 6\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Blue\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Blue#29\n" +
            "Alex drew a Purple\n" +
            "Alex moved 4 spaces\n" +
            "Alex is now at position Purple#33\n" +
            "Alex is now stuck \n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#80\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Green\n" +
            "Nate didn't get a Orange and is still stuck at Orange#80\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Red#26\n" +
            "Alex drew a Purple\n" +
            "Alex moved 1 spaces\n" +
            "Alex is now at position Purple#27\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 7\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#33\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Yellow\n" +
            "Alex didn't get a Purple and is still stuck at Purple#33\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#80\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Purple\n" +
            "Nate didn't get a Orange and is still stuck at Orange#80\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#27\n" +
            "Alex drew a Blue\n" +
            "Alex moved 2 spaces\n" +
            "Alex is now at position Blue#29\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 8\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Blue\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#33\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Red\n" +
            "Alex didn't get a Purple and is still stuck at Purple#33\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#80\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Blue\n" +
            "Nate didn't get a Orange and is still stuck at Orange#80\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Blue#29\n" +
            "Alex drew a Green\n" +
            "Alex moved 2 spaces\n" +
            "Alex is now at position Green#31\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 9\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#33\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Yellow\n" +
            "Alex didn't get a Purple and is still stuck at Purple#33\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#80\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Blue\n" +
            "Nate didn't get a Orange and is still stuck at Orange#80\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Green#31\n" +
            "Alex drew a Orange\n" +
            "Alex moved 5 spaces\n" +
            "Alex is now at position Orange#36\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 10\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Green\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#33\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Purple\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Purple#39\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#80\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#80\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Orange#36\n" +
            "Alex drew a Orange\n" +
            "Alex moved 7 spaces\n" +
            "Alex is now at position Orange#43\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 11\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Orange\n" +
            "Nate moved 3 spaces\n" +
            "Nate is now at position Orange#11\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#39\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Red\n" +
            "Alex didn't get a Purple and is still stuck at Purple#39\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#80\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Blue\n" +
            "Nate didn't get a Orange and is still stuck at Orange#80\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Orange#43\n" +
            "Alex drew a Orange\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Orange#49\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 12\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#11\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Red\n" +
            "Nate didn't get a Orange and is still stuck at Orange#11\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#39\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Red\n" +
            "Alex didn't get a Purple and is still stuck at Purple#39\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#80\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Green\n" +
            "Nate didn't get a Orange and is still stuck at Orange#80\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Orange#49\n" +
            "Alex drew a Trip to Lolly's World\n" +
            "Alex moved 46 spaces\n" +
            "Alex is now at position 95, Lolly's World\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 13\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#11\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Trip to Jolly's World\n" +
            "Nate moved 31 spaces\n" +
            "Nate is now at position 42, Jolly's World\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#39\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Purple\n" +
            "Alex moved 7 spaces\n" +
            "Alex is now at position Purple#46\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#80\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Red\n" +
            "Nate didn't get a Orange and is still stuck at Orange#80\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at Lolly's World\n" +
            "Alex drew a Red\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Red#101\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 14\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Jolly's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Blue\n" +
            "Nate didn't get a Orange and is still stuck at Orange#42\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#46\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Green\n" +
            "Alex didn't get a Purple and is still stuck at Purple#46\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#80\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Orange\n" +
            "Nate moved 6 spaces\n" +
            "Nate is now at position Orange#86\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Red#101\n" +
            "Alex drew a Trip to Frostine's World\n" +
            "Alex moved 2 spaces\n" +
            "Alex is now at position 103, Frostine's World\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 15\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Jolly's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Orange\n" +
            "Nate moved 1 spaces\n" +
            "Nate is now at position Orange#43\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#46\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Purple\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Purple#52\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#86\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#86\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at Frostine's World\n" +
            "Alex drew a Green\n" +
            "Alex moved 4 spaces\n" +
            "Alex is now at position Green#107\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 16\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#43\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#43\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#52\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Purple\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Purple#58\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#86\n" +
            "Nate is currently stuck.\n" +
            "\n" +
            "No more cards, reshuffling\n" +
            "**Initializing Cards**\n" +
            "**Shuffling**\n" +
            "Nate drew a Trip to Mint's World\n" +
            "Nate moved -69 spaces\n" +
            "Nate is now at position 17, Mint's World\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Green#107\n" +
            "Alex drew a Purple\n" +
            "Alex moved 2 spaces\n" +
            "Alex is now at position Purple#109\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 17\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#43\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#43\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#58\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Green\n" +
            "Alex didn't get a Purple and is still stuck at Purple#58\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Mint's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Trip to Plumpy's World\n" +
            "Nate moved -9 spaces\n" +
            "Nate is now at position 8, Plumpy's World\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#109\n" +
            "Alex drew a Orange\n" +
            "Alex moved 3 spaces\n" +
            "Alex is now at position Orange#112\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 18\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#43\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Orange\n" +
            "Nate moved 6 spaces\n" +
            "Nate is now at position Orange#49\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#58\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Trip to Frostine's World\n" +
            "Alex moved 45 spaces\n" +
            "Alex is now at position 103, Frostine's World\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Red\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Orange#112\n" +
            "Alex drew a Blue\n" +
            "Alex moved 5 spaces\n" +
            "Alex is now at position Blue#117\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 19\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#49\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Blue\n" +
            "Nate didn't get a Orange and is still stuck at Orange#49\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at Frostine's World\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Red\n" +
            "Alex didn't get a Purple and is still stuck at Purple#103\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Blue#117\n" +
            "Alex drew a Orange\n" +
            "Alex moved 1 spaces\n" +
            "Alex is now at position Orange#118\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 20\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#49\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Red\n" +
            "Nate didn't get a Orange and is still stuck at Orange#49\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at Frostine's World\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Purple\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Purple#109\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Red\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Orange#118\n" +
            "Alex drew a Yellow\n" +
            "Alex moved 4 spaces\n" +
            "Alex is now at position Yellow#122\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 21\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#49\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#49\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#109\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Purple\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Purple#115\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Red\n" +
            "Nate didn't get a Orange and is still stuck at Orange#8\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Yellow#122\n" +
            "Alex drew a Blue\n" +
            "Alex moved 1 spaces\n" +
            "Alex is now at position Blue#123\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 22\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#49\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Orange\n" +
            "Nate moved 6 spaces\n" +
            "Nate is now at position Orange#55\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#115\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Green\n" +
            "Alex didn't get a Purple and is still stuck at Purple#115\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Plumpy's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Trip to Nut's World\n" +
            "Nate moved 66 spaces\n" +
            "Nate is now at position 74, Nut's World\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Blue#123\n" +
            "Alex drew a Green\n" +
            "Alex moved 2 spaces\n" +
            "Alex is now at position Green#125\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 23\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#55\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Yellow\n" +
            "Nate didn't get a Orange and is still stuck at Orange#55\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#115\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Purple\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Purple#121\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Nut's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Green\n" +
            "Nate didn't get a Orange and is still stuck at Orange#74\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Green#125\n" +
            "Alex drew a Green\n" +
            "Alex moved 5 spaces\n" +
            "Alex is now at position Green#130\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 24\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at position Orange#55\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Green\n" +
            "Nate didn't get a Orange and is still stuck at Orange#55\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#121\n" +
            "Alex is currently stuck.\n" +
            "Alex drew a Purple\n" +
            "Alex moved 6 spaces\n" +
            "Alex is now at position Purple#127\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Nut's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Red\n" +
            "Nate didn't get a Orange and is still stuck at Orange#74\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Green#130\n" +
            "Alex drew a Purple\n" +
            "Alex moved 2 spaces\n" +
            "Alex is now at position Purple#132\n" +
            "\n" +
            "******************\n" +
            "\n" +
            "TURN 25\n" +
            "\n" +
            "It is now Nate's turn\n" +
            "Nate is starting at Nut's World\n" +
            "Nate is currently stuck.\n" +
            "Nate drew a Blue\n" +
            "Nate didn't get a Orange and is still stuck at Orange#74\n" +
            "\n" +
            "It is now Alex's turn\n" +
            "Alex is starting at position Purple#132\n" +
            "Alex drew a Orange\n" +
            "Alex is the WINNER\n";
}
