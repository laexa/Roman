package alexinc.roman.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import alexinc.roman.R;


public class DataBaseHelper extends SQLiteOpenHelper {

    String LOG_TAG = "log";
    public static final String DATABASE_NAME = "DATA_BASE_GAME";
    private static final int DATABASE_VERSION = 11;
    public static final String TABLE_FAMILY = "family";
    public static final String TABLE_ANIMAL = "animal";
    public static final String TABLE_VEGETABLE = "vegetable";
    public static final String TABLE_FRUIT = "fruit";
    public static final String TABLE_ALPHABET = "alphabet";

    public static final String KEY_ID = "_id";
    public static final String KEY_WORD = "word";
    public static final String KEY_WORD_TRANSLATE = "word_translate";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_SOUND_ORIGINAL = "sound_original";
    public static final String KEY_SOUND_TRANSLATE = "sound_translate";



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_FAMILY + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_WORD + " TEXT,"
                + KEY_WORD_TRANSLATE + " TEXT," + KEY_IMAGE + " INTEGER," + KEY_SOUND_ORIGINAL + " INTEGER,"
                + KEY_SOUND_TRANSLATE + " INTEGER" + ");");

        db.execSQL("CREATE TABLE " + TABLE_ANIMAL + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_WORD + " TEXT,"
                + KEY_WORD_TRANSLATE + " TEXT," + KEY_IMAGE + " INTEGER," + KEY_SOUND_ORIGINAL + " INTEGER,"
                + KEY_SOUND_TRANSLATE + " INTEGER" + ");");

        db.execSQL("CREATE TABLE " + TABLE_VEGETABLE+ "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_WORD + " TEXT,"
                + KEY_WORD_TRANSLATE + " TEXT," + KEY_IMAGE + " INTEGER," + KEY_SOUND_ORIGINAL + " INTEGER,"
                + KEY_SOUND_TRANSLATE + " INTEGER" + ");");

        db.execSQL("CREATE TABLE " + TABLE_FRUIT + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_WORD + " TEXT,"
                + KEY_WORD_TRANSLATE + " TEXT," + KEY_IMAGE + " INTEGER," + KEY_SOUND_ORIGINAL + " INTEGER,"
                + KEY_SOUND_TRANSLATE + " INTEGER" + ");");

        db.execSQL("CREATE TABLE " + TABLE_ALPHABET + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_WORD + " TEXT,"
                + KEY_WORD_TRANSLATE + " TEXT," + KEY_IMAGE + " INTEGER," + KEY_SOUND_ORIGINAL + " INTEGER,"
                + KEY_SOUND_TRANSLATE + " INTEGER" + ");");

        loadDataBase(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAMILY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALPHABET);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRUIT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VEGETABLE);
        onCreate(db);
    }

    public  void clearTable(String TABLE_NAME){

        Log.i(LOG_TAG, "clearTable: ");
        SQLiteDatabase db = this.getWritableDatabase();
        int count = db.delete(TABLE_NAME, null, null);
        Log.i(LOG_TAG, "ccount row : " + count);

    }

    public void insert(SQLiteDatabase db, String tableName, String word, String wordTranslate, int image, int soundOriginal, int soundTranslate){

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_WORD, word);
        contentValues.put(KEY_WORD_TRANSLATE, wordTranslate);
        contentValues.put(KEY_IMAGE, image);
        contentValues.put(KEY_SOUND_ORIGINAL, soundOriginal);
        contentValues.put(KEY_SOUND_TRANSLATE, soundTranslate);
        db.insert(tableName, null, contentValues);

    }

    public  void getAllData(String table){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.query(table, null, null, null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex(KEY_ID);
            int wordColIndex = c.getColumnIndex(KEY_WORD);
            int wordTranslateColIndex = c.getColumnIndex(KEY_WORD_TRANSLATE);
            int imageColIndex = c.getColumnIndex(KEY_IMAGE);
            int soundOriginalColIndex = c.getColumnIndex(KEY_SOUND_ORIGINAL);
            int soundTranslateColIndex = c.getColumnIndex(KEY_SOUND_TRANSLATE);
            int nameColIndex = c.getColumnIndex("name");
            int emailColIndex = c.getColumnIndex("email");

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(LOG_TAG,
                        "ID = " + c.getInt(idColIndex) +
                                ", word = " + c.getString(wordColIndex) +
                                ", wordTranslte = " + c.getString(wordTranslateColIndex) +
                                ", image = " + c.getString(imageColIndex) +
                                ", soundOriginal = " + c.getString(soundOriginalColIndex) +
                                ", soundTranslate = " + c.getString(soundTranslateColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else
            Log.d(LOG_TAG, "0 rows");
        c.close();
    }



    public Cursor getData(String TABLE_NAME){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =  db.query(TABLE_NAME, null,null, null, null, null, null);
        return cursor;
    }

    private void loadDataBase(SQLiteDatabase db){

        //family 8

        insert(db, DataBaseHelper.TABLE_FAMILY,"Тато", "Tata", R.drawable.ic_father, R.raw.father_original, R.raw.father_translate);
        insert(db, DataBaseHelper.TABLE_FAMILY,"Мама", "Mamă", R.drawable.ic_mother, R.raw.mother_original, R.raw.mother_translate);
        insert(db, DataBaseHelper.TABLE_FAMILY,"Брат", "Frate", R.drawable.ic_brother, R.raw.brother_original, R.raw.brother_translate);
        insert(db, DataBaseHelper.TABLE_FAMILY,"Сестра", "Soră", R.drawable.ic_sister, R.raw.sister_original, R.raw.sister_translate);
        insert(db, DataBaseHelper.TABLE_FAMILY,"Бабка", "Bunică", R.drawable.ic_grandmother, R.raw.grandmother_original, R.raw.grandmother_translate);
        insert(db, DataBaseHelper.TABLE_FAMILY,"Дідусь", "Bunic", R.drawable.ic_grandfather, R.raw.grandfather_original, R.raw.grandfather_translate);
        insert(db, DataBaseHelper.TABLE_FAMILY,"Син", "Fiu", R.drawable.ic_son, R.raw.son_original, R.raw.son_translate);
        insert(db, DataBaseHelper.TABLE_FAMILY,"Дочка", "Fiică", R.drawable.ic_daughter, R.raw.daughter_original, R.raw.daughter_translate);

        //animal 8
        insert(db, DataBaseHelper.TABLE_ANIMAL,"Кіт", "Pisică", R.drawable.ic_cat, R.raw.cat_original, R.raw.cat_translate);
        insert(db, DataBaseHelper.TABLE_ANIMAL,"Собака", "Câinele", R.drawable.ic_dog, R.raw.dog_original, R.raw.dog_translate);
        insert(db, DataBaseHelper.TABLE_ANIMAL,"Кролик", "Iepure", R.drawable.ic_rabbit, R.raw.rabbit_original, R.raw.rabbit_translate);
        insert(db, DataBaseHelper.TABLE_ANIMAL,"Порося", "Purceluș", R.drawable.ic_pig, R.raw.pig_original, R.raw.pig_translate);
        insert(db, DataBaseHelper.TABLE_ANIMAL,"Корова", "Vacă", R.drawable.ic_cow, R.raw.cow_original, R.raw.cow_translate);
        insert(db, DataBaseHelper.TABLE_ANIMAL,"Кінь", "Cal", R.drawable.ic_horse, R.raw.horse_original, R.raw.horse_translate);
        insert(db, DataBaseHelper.TABLE_ANIMAL,"Качка", "Rață", R.drawable.ic_duck, R.raw.duck_original, R.raw.duck_translate);
        insert(db, DataBaseHelper.TABLE_ANIMAL,"Мишка", "Soarece", R.drawable.ic_mouse, R.raw.mother_original, R.raw.mouse_translate);

        //fruit 11
        insert(db, DataBaseHelper.TABLE_FRUIT,"Яблоко", "Măr", R.drawable.ic_apple, R.raw.apple_original, R.raw.apple_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Банан", "Banană", R.drawable.ic_banana, R.raw.banana_original, R.raw.banana_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Вишня", "Cireșe", R.drawable.ic_cherry, R.raw.cherry_original, R.raw.cherry_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Апельсин", "Portocaliu", R.drawable.ic_orange, R.raw.orange_original, R.raw.orange_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Лимон", "Lămâie", R.drawable.ic_lemon, R.raw.lemon_original, R.raw.lemon_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Лайм", "Tei", R.drawable.ic_lime, R.raw.lime_original, R.raw.lime_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Груша", "Pară", R.drawable.ic_pear, R.raw.pear_original, R.raw.pear_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Ананас", "Ananas", R.drawable.ic_pineapple, R.raw.pineapple_original, R.raw.pineapple_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Слива", "prună", R.drawable.ic_plum, R.raw.plum_original, R.raw.plum_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Полуниця", "căpșune", R.drawable.ic_strawberry, R.raw.strawberry_original, R.raw.strawberry_translate);
        insert(db, DataBaseHelper.TABLE_FRUIT,"Каву", "Pepene verde", R.drawable.ic_watermelon, R.raw.watermelon_original, R.raw.watermelon_translate);

        //Vegetable 9
        insert(db, DataBaseHelper.TABLE_VEGETABLE,"Капуста", "Varză", R.drawable.ic_cabbage, R.raw.cabbage_original, R.raw.cabbage_translate);
        insert(db, DataBaseHelper.TABLE_VEGETABLE,"Морква", "Morcovi", R.drawable.ic_carrot, R.raw.carrot_original, R.raw.carrot_translate);
        insert(db, DataBaseHelper.TABLE_VEGETABLE,"Кукурудза", "Porumb", R.drawable.ic_corn, R.raw.corn_original, R.raw.corn_translate);
        insert(db, DataBaseHelper.TABLE_VEGETABLE,"Огірок", "Castravete", R.drawable.ic_cucumber, R.raw.cucumber_original, R.raw.cucumber_translate);
        insert(db, DataBaseHelper.TABLE_VEGETABLE,"Цибуля", "Cepe", R.drawable.ic_onion, R.raw.onion_original, R.raw.onion_translate);
        insert(db, DataBaseHelper.TABLE_VEGETABLE,"Перець", "Piper", R.drawable.ic_pepper, R.raw.pepper_original, R.raw.pepper_translate);
        insert(db, DataBaseHelper.TABLE_VEGETABLE,"Картопля", "Cartof", R.drawable.ic_potato, R.raw.potato_original, R.raw.potato_translate);
        insert(db, DataBaseHelper.TABLE_VEGETABLE,"Гарбуз", "Dovleac", R.drawable.ic_pumpkin, R.raw.pumpkin_original, R.raw.pumpkin_translate);
        insert(db, DataBaseHelper.TABLE_VEGETABLE,"Помідор", "Tomată", R.drawable.ic_tomato, R.raw.tomato_original, R.raw.tomato_translate);


    }
}
