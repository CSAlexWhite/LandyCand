package sweetworld.landycand;

import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.TextView;

public class StartGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/COURIER.TTF");
        TextView tv = (TextView) findViewById(R.id.nameentry);
        tv.setTypeface(tf);

        final ImageButton twoplayers = (ImageButton) findViewById(R.id.twoplayers);
        twoplayers.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                choosePlayers(2, twoplayers);
            }
        });

        final ImageButton threeplayers = (ImageButton) findViewById(R.id.threeplayers);
        threeplayers.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                choosePlayers(3, threeplayers);
            }
        });

        final ImageButton fourplayers = (ImageButton) findViewById(R.id.fourplayers);
        fourplayers.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                choosePlayers(4, fourplayers);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_game, menu);
        return true;
    }

    public void choosePlayers(int numPlayers, ImageButton button){

        final Intent intent = new Intent(this, EnterNames.class);
        intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("players", numPlayers);

        final ImageButton btn_start = button;

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
