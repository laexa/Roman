package alexinc.roman;

import android.app.Application;

public class App extends Application {

    private static App instance;
//    private static IDatabaseController mDbController;

    public static App getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}