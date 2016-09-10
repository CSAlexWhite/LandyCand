package sweetworld.landycand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Countdown1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown1);

        Button startButton = (Button) findViewById(R.id.btn_start);
        startButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                endStartScreen();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_countdown1, menu);
        return true;
    }

    public void endStartScreen(){

        final Intent intent = new Intent(this, StartGame.class);
        intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION);

        final Button btn_start = (Button)findViewById(R.id.btn_start);

        Animation a = new AlphaAnimation(1.00f, 0.00f);

        a.setDuration(500);
        a.setAnimationListener(new Animation.AnimationListener() {

            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            public void onAnimationEnd(Animation animation) {
                btn_start.setVisibility(View.GONE);
                startActivity(intent);
            }
        });

        btn_start.startAnimation(a);
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
