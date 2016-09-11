package sweetworld.landycand;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class EnterNames extends AppCompatActivity {

    private StringBuilder[] names;
    private boolean[] finished;
    public int k, numplayers;
    public boolean paused;
    boolean looping = true;

    Typeface tf;
    TextView tv;
    EditText et;
    TextView current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_names);

        tf = Typeface.createFromAsset(getAssets(), "fonts/COURIER.TTF");
        tv = (TextView) findViewById(R.id.please_enter);
        et = (EditText) findViewById(R.id.editText);
        current = (TextView) findViewById(R.id.currentName);

        tv.setTypeface(tf);
        et.setTypeface(tf);
        current.setTypeface(tf);
        et.setText("");

        Bundle bundle = getIntent().getExtras();
        numplayers = bundle.getInt("players");

        names = new StringBuilder[numplayers];
        finished = new boolean[numplayers];
        for(int i=0; i<numplayers; i++){
            names[i] = new StringBuilder("");
            finished[i] = false;
        }

        final Button entercharacter = (Button) findViewById(R.id.entercharacter);
        entercharacter.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                unpause();
            }
        });

        final Button entername = (Button) findViewById(R.id.entername);
        entername.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                finishName();
            }
        });

        final Button allfinished = (Button) findViewById(R.id.allfinished);
        allfinished.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                gotoNextGame();
            }
        });

        //TextView myTextView = (TextView) findViewById(R.id.myTextView); //grab your tv
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                while (!everyoneDone()) {
                    //Thread.sleep(1000); // Waits for 1 second (1000 milliseconds)
                    //String updateWords = updateAuto(); // make updateAuto() return a string
//                    myTextView.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            myTextView.setText(updateWords);
//                        });
                    for(k=0; k<numplayers; k++){
                        paused=true;
                        if(finished[k]) continue;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                current.setText(names[k].toString());
                                tv.setText("Player " + (k+1) + ", please enter a letter");
                                et.setText("");
                            }
                        });

                        while(paused){}
                    }
                }
            }
        };
        Thread myThread = new Thread(myRunnable);
        myThread.start();

//        while(!everyoneDone()) enterName();
        enterName();
    }

    public void gotoNextGame(){
        final Intent intent = new Intent(this, GameActivity.class);
        intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("names", names);
        startActivity(intent);
    }

    public void enterName(){
        for(k=0; k<numplayers; k++){

            if(finished[k]) continue;

            current.setText(names[k].toString());
            tv.setText("Player " + (k+1) + ", please enter a letter");
            if(tv.length() == 1) {
                names[k].append(tv.getText().charAt(0));
                tv.setText("");
            }
        }
    }

    private boolean everyoneDone(){
        for(int i=0; i<numplayers; i++){
            if(!finished[i]) return false;
        }
        return true;
    }

    public void finishName(){
        finished[k] = true;
    }

    public void unpause(){

        names[k].append(et.getText().charAt(0));
        tv.setText("");

        paused = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_names, menu);
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
