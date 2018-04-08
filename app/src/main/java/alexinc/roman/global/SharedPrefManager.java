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
        return sharedPreferences.getInt(_s, 0);
    }

    private long retrieveLong(String _s) {
        return sharedPreferences.getLong(_s, -1);
    }


    public void stroreAlphabetAll(final int _score){
        saveInt(ALL_SCORE_ALPHABET, _score);
    }

    public int retrieveAlphabetAll(){
        return retrieveInt(ALL_SCORE_ALPHABET);
    }

    public void stroreAlphabetUser(final int _score){
        saveInt(USER_SCORE_ALPHABET, _score);
    }

    public int retrieveAlphabetUser(){
        return retrieveInt(USER_SCORE_ALPHABET);
    }



    public void stroreAnimalAll(final int _score){
        saveInt(ALL_SCORE_ANIMAL, _score);
    }

    public int retrieveAnimalAll(){
        return retrieveInt(ALL_SCORE_ANIMAL);
    }

    public void stroreAnimalUser(final int _score){
        saveInt(USER_SCORE_ANIMAL, _score);
    }

    public int retrieveAnimalUser(){
        return retrieveInt(USER_SCORE_ANIMAL);
    }



    public void stroreFamilyAll(final int _score){
        saveInt(ALL_SCORE_FAMILY, _score);
    }

    public int retrieveFamilyAll(){
        return retrieveInt(ALL_SCORE_FAMILY);
    }

    public void stroreFamilyUser(final int _score){
        saveInt(USER_SCORE_FAMILY, _score);
    }

    public int retrieveFamilyUser(){
        return retrieveInt(USER_SCORE_FAMILY);
    }



    public void stroreFruitScoreAll(final int _score){
        saveInt(ALL_SCORE_FRUIT, _score);
    }

    public int retrieveFruitScoreAll(){
        return retrieveInt(ALL_SCORE_FRUIT);
    }

    public void stroreFruitScoreUser(final int _score){
        saveInt(USER_SCORE_FRUIT, _score);
    }

    public int retrieveFruitScoreUser(){
        return retrieveInt(USER_SCORE_FRUIT);
    }



    public void stroreVegetableScoreAll(final int _score){
        saveInt(ALL_SCORE_VEGETABLE, _score);
    }

    public int retrieveVegetableScoreAll(){
        return retrieveInt(ALL_SCORE_VEGETABLE);
    }

    public void stroreVegetableScoreUser(final int _score){
        saveInt(USER_SCORE_VEGETABLE, _score);
    }

    public int retrieveVegetableScoreUser(){
        return retrieveInt(USER_SCORE_VEGETABLE);
    }
}
