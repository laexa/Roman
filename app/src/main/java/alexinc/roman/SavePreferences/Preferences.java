package alexinc.roman.SavePreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by alex on 25.03.2018.
 */

public class Preferences {

    private SharedPreferences sPref;
    Context context;

    private static final String SAVE_SCORE = "0";
    private static final String ALL_SCORE_ALPHABET  = "0";
    private static final String ALL_SCORE_FAMILY  = "8";
    private static final String ALL_SCORE_VEGETABLE  = "9";
    private static final String ALL_SCORE_ANIMAL  = "8";

    public static String getAllScoreAlphabet() {
        return ALL_SCORE_ALPHABET;
    }

    public static String getAllScoreFamily() {
        return ALL_SCORE_FAMILY;
    }

    public static String getAllScoreVegetable() {
        return ALL_SCORE_VEGETABLE;
    }

    public static String getAllScoreAnimal() {
        return ALL_SCORE_ANIMAL;
    }

    public static String getAllScoreFruit() {
        return ALL_SCORE_FRUIT;
    }

    private static final String ALL_SCORE_FRUIT  = "11";

    private static final String USER_SCORE_ALPHABET = "0";
    private static final String USER_SCORE_FAMILY = "0";
    private static final String USER_SCORE_VEGETABLE = "0";
    private static final String USER_SCORE_ANIMAL = "0";
    private static final String USER_SCORE_FRUIT = "0";

    private String TAG = "log";

    public Preferences(Context context) {
        this.context = context;
    }

    public void saveScore(String text){

        sPref = context.getSharedPreferences("", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(SAVE_SCORE, text);
        editor.commit();
        Log.i(TAG, "saveText: data save");
    }

    public String loadScore(){
        Log.i(TAG, "loadScore: data load");
        return sPref.getString(SAVE_SCORE, "");
    }
}
