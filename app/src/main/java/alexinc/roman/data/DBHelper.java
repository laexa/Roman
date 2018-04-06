package alexinc.roman.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import alexinc.roman.R;


public class DBHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = "SQLiteOpenHelperApplication -> ";

    static final int DATABASE_VERSION = 11;

    static final String DATABASE_NAME = "DATA_BASE_GAME";

    static final String TABLE_FAMILY = "family";
    static final String TABLE_ANIMAL = "animal";
    static final String TABLE_VEGETABLE = "vegetable";
    static final String TABLE_FRUIT = "fruit";
    static final String TABLE_ALPHABET = "alphabet";

    static final String KEY_ID = "_id";
    static final String KEY_WORD = "word";
    static final String KEY_IMAGE = "image";
    static final String KEY_WORD_TRANSLATE = "word_translate";
    static final String KEY_SOUND_ORIGINAL = "sound_original";
    static final String KEY_SOUND_TRANSLATE = "sound_translate";


    public DBHelper(Context context) {
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

        db.execSQL("CREATE TABLE " + TABLE_VEGETABLE + "("
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

    public void clearTable(String TABLE_NAME) {
        Log.i(LOG_TAG, "clearTable: " + TABLE_NAME);

        SQLiteDatabase db = this.getWritableDatabase();
        int count = db.delete(TABLE_NAME, null, null);

        Log.i(LOG_TAG, "deleted rows : " + count);
    }

    private void insert(SQLiteDatabase db, String tableName, String word, String wordTranslate, int image, int soundOriginal, int soundTranslate) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_WORD, word);
        contentValues.put(KEY_WORD_TRANSLATE, wordTranslate);
        contentValues.put(KEY_IMAGE, image);
        contentValues.put(KEY_SOUND_ORIGINAL, soundOriginal);
        contentValues.put(KEY_SOUND_TRANSLATE, soundTranslate);
        db.insert(tableName, null, contentValues);
    }

    public void insert(String tableName, ContentValues contentValues) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.insert(tableName, null, contentValues);
    }

    public List<ContentValues> getAllData(String table) {
        final SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(table, null, null, null, null, null, null);
        List<ContentValues> values = new ArrayList<>();
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

            do {
                ContentValues value = new ContentValues();
                value.put(KEY_ID, c.getInt(idColIndex));
                value.put(KEY_WORD, c.getString(wordColIndex));
                value.put(KEY_WORD_TRANSLATE, c.getString(wordTranslateColIndex));
                value.put(KEY_IMAGE, c.getString(imageColIndex));
                value.put(KEY_SOUND_ORIGINAL, c.getString(soundOriginalColIndex));
                value.put(KEY_SOUND_TRANSLATE, c.getString(soundTranslateColIndex));

                values.add(value);
            } while (c.moveToNext());
        } else
            Log.d(LOG_TAG, "0 rows");
        c.close();
        return values;
    }

    public Cursor getW_CursorByName(final String _tableName) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(_tableName, null, null, null, null, null, null);
    }

    public Cursor getR_CursorByName(final String _tableName) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(_tableName, null, null, null, null, null, null);
    }

    private void loadDataBase(SQLiteDatabase db) {

        //family 8

        insert(db, DBHelper.TABLE_FAMILY, "Тато", "Tata", R.drawable.ic_father, R.raw.father_original, R.raw.father_translate);
        insert(db, DBHelper.TABLE_FAMILY, "Мама", "Mamă", R.drawable.ic_mother, R.raw.mother_original, R.raw.mother_translate);
        insert(db, DBHelper.TABLE_FAMILY, "Брат", "Frate", R.drawable.ic_brother, R.raw.brother_original, R.raw.brother_translate);
        insert(db, DBHelper.TABLE_FAMILY, "Сестра", "Soră", R.drawable.ic_sister, R.raw.sister_original, R.raw.sister_translate);
        insert(db, DBHelper.TABLE_FAMILY, "Бабка", "Bunică", R.drawable.ic_grandmother, R.raw.grandmother_original, R.raw.grandmother_translate);
        insert(db, DBHelper.TABLE_FAMILY, "Дідусь", "Bunic", R.drawable.ic_grandfather, R.raw.grandfather_original, R.raw.grandfather_translate);
        insert(db, DBHelper.TABLE_FAMILY, "Син", "Fiu", R.drawable.ic_son, R.raw.son_original, R.raw.son_translate);
        insert(db, DBHelper.TABLE_FAMILY, "Дочка", "Fiică", R.drawable.ic_daughter, R.raw.daughter_original, R.raw.daughter_translate);

        //animal 8
        insert(db, DBHelper.TABLE_ANIMAL, "Кіт", "Pisică", R.drawable.ic_cat, R.raw.cat_original, R.raw.cat_translate);
        insert(db, DBHelper.TABLE_ANIMAL, "Собака", "Câinele", R.drawable.ic_dog, R.raw.dog_original, R.raw.dog_translate);
        insert(db, DBHelper.TABLE_ANIMAL, "Кролик", "Iepure", R.drawable.ic_rabbit, R.raw.rabbit_original, R.raw.rabbit_translate);
        insert(db, DBHelper.TABLE_ANIMAL, "Порося", "Purceluș", R.drawable.ic_pig, R.raw.pig_original, R.raw.pig_translate);
        insert(db, DBHelper.TABLE_ANIMAL, "Корова", "Vacă", R.drawable.ic_cow, R.raw.cow_original, R.raw.cow_translate);
        insert(db, DBHelper.TABLE_ANIMAL, "Кінь", "Cal", R.drawable.ic_horse, R.raw.horse_original, R.raw.horse_translate);
        insert(db, DBHelper.TABLE_ANIMAL, "Качка", "Rață", R.drawable.ic_duck, R.raw.duck_original, R.raw.duck_translate);
        insert(db, DBHelper.TABLE_ANIMAL, "Мишка", "Soarece", R.drawable.ic_mouse, R.raw.mother_original, R.raw.mouse_translate);

        //fruit 11
        insert(db, DBHelper.TABLE_FRUIT, "Яблоко", "Măr", R.drawable.ic_apple, R.raw.apple_original, R.raw.apple_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Банан", "Banană", R.drawable.ic_banana, R.raw.banana_original, R.raw.banana_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Вишня", "Cireșe", R.drawable.ic_cherry, R.raw.cherry_original, R.raw.cherry_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Апельсин", "Portocaliu", R.drawable.ic_orange, R.raw.orange_original, R.raw.orange_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Лимон", "Lămâie", R.drawable.ic_lemon, R.raw.lemon_original, R.raw.lemon_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Лайм", "Tei", R.drawable.ic_lime, R.raw.lime_original, R.raw.lime_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Груша", "Pară", R.drawable.ic_pear, R.raw.pear_original, R.raw.pear_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Ананас", "Ananas", R.drawable.ic_pineapple, R.raw.pineapple_original, R.raw.pineapple_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Слива", "prună", R.drawable.ic_plum, R.raw.plum_original, R.raw.plum_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Полуниця", "căpșune", R.drawable.ic_strawberry, R.raw.strawberry_original, R.raw.strawberry_translate);
        insert(db, DBHelper.TABLE_FRUIT, "Каву", "Pepene verde", R.drawable.ic_watermelon, R.raw.watermelon_original, R.raw.watermelon_translate);

        //Vegetable 9
        insert(db, DBHelper.TABLE_VEGETABLE, "Капуста", "Varză", R.drawable.ic_cabbage, R.raw.cabbage_original, R.raw.cabbage_translate);
        insert(db, DBHelper.TABLE_VEGETABLE, "Морква", "Morcovi", R.drawable.ic_carrot, R.raw.carrot_original, R.raw.carrot_translate);
        insert(db, DBHelper.TABLE_VEGETABLE, "Кукурудза", "Porumb", R.drawable.ic_corn, R.raw.corn_original, R.raw.corn_translate);
        insert(db, DBHelper.TABLE_VEGETABLE, "Огірок", "Castravete", R.drawable.ic_cucumber, R.raw.cucumber_original, R.raw.cucumber_translate);
        insert(db, DBHelper.TABLE_VEGETABLE, "Цибуля", "Cepe", R.drawable.ic_onion, R.raw.onion_original, R.raw.onion_translate);
        insert(db, DBHelper.TABLE_VEGETABLE, "Перець", "Piper", R.drawable.ic_pepper, R.raw.pepper_original, R.raw.pepper_translate);
        insert(db, DBHelper.TABLE_VEGETABLE, "Картопля", "Cartof", R.drawable.ic_potato, R.raw.potato_original, R.raw.potato_translate);
        insert(db, DBHelper.TABLE_VEGETABLE, "Гарбуз", "Dovleac", R.drawable.ic_pumpkin, R.raw.pumpkin_original, R.raw.pumpkin_translate);
        insert(db, DBHelper.TABLE_VEGETABLE, "Помідор", "Tomată", R.drawable.ic_tomato, R.raw.tomato_original, R.raw.tomato_translate);


    }
}
