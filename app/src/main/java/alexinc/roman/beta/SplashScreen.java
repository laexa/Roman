package alexinc.roman.beta;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import alexinc.roman.R;
import alexinc.roman.acitvity.MainActivity;

public class SplashScreen extends AppCompatActivity {

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
                final Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, TimeUnit.SECONDS.toMillis(SECONDS_ON_SPLASH));
    }

}
