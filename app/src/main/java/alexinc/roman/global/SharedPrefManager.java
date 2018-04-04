package alexinc.roman.global;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import alexinc.roman.App;

import static alexinc.roman.global.PreferencesConst.*;

public final class SharedPrefManager {

    private static SharedPrefManager instance;
    private SharedPreferences sharedPreferences;

    private SharedPrefManager(Context _context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(_context);
    }

    public static SharedPrefManager getInstance() {
        if (instance == null) {
            instance = new SharedPrefManager(App.getInstance());
        }
        return instance;
    }

    public void clear() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private void saveString(String _key, String _value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(_key, _value);
        editor.apply();
    }

    private void saveInt(String _key, int _value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(_key, _value);
        editor.apply();
    }

    private void saveLong(String _key, long _value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(_key, _value);
        editor.apply();
    }


    private void saveBoolean(String _key, boolean _value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(_key, _value);
        editor.apply();
    }

    private String retrieveString(String _s) {
        return sharedPreferences.getString(_s, "");
    }

    private boolean retrieveBoolean(String _s) {
        return sharedPreferences.getBoolean(_s, false);
    }

    private int retrieveInt(String _s) {
        return sharedPreferences.getInt(_s, -1);
    }

    private long retrieveLong(String _s) {
        return sharedPreferences.getLong(_s, -1);
    }


    public void stroreAlphabetScoreAll(final int _score){
        saveInt(ALL_SCORE_ALPHABET, _score);
    }

    public int retrieveAlphabetScoreAll(){
        return retrieveInt(ALL_SCORE_ALPHABET);
    }
}
