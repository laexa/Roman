package alexinc.roman;

import android.app.Application;

import alexinc.roman.global.SharedPrefManager;

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SharedPrefManager.getInstance().stroreFamilyAll(8);
        SharedPrefManager.getInstance().stroreAnimalAll(8);
        SharedPrefManager.getInstance().stroreFruitScoreAll(11);
        SharedPrefManager.getInstance().stroreVegetableScoreAll(9);
    }

}
