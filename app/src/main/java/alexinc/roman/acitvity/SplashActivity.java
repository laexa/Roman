package alexinc.roman.acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import alexinc.roman.R;

/**
 * Created by alex on 30.01.2018.
 */

public class SplashActivity extends AppCompatActivity {

    private static final long SECONDS_ON_SPLASH = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        openNextScreen();
    }


    private void openNextScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(SplashActivity.this, ChoiceKindThemeMenuActivity.class);
                startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, TimeUnit.SECONDS.toMillis(SECONDS_ON_SPLASH));
    }
}
