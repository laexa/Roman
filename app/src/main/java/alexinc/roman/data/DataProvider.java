package alexinc.roman.data;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import alexinc.roman.data.model.VocabularyModel;

public class DataProvider implements DataOperation {

    private DBHelper dbHelper;

    public DataProvider(final Context context) {
        this.dbHelper = new DBHelper(context);
    }

    @Override
    public void insert(String tableName, VocabularyModel model) {
        dbHelper.insert(tableName, transformModelToContent(model));
    }

    @Override
    public List<VocabularyModel> getWordsByTheme(String tableName) {
        return transformToUse(dbHelper.getAllData(tableName));
    }

    @Override
    public List<VocabularyModel> getAllWords(String tableName) {
        return null;
    }

    @Override
    public List<VocabularyModel> getFamilyList() {
        return getWordsByTheme(DBHelper.TABLE_FAMILY);
    }

    @Override
    public List<VocabularyModel> getAnimalList() {
        return getWordsByTheme(DBHelper.TABLE_ANIMAL);
    }

    @Override
    public List<VocabularyModel> getVegetableList() {
        return getWordsByTheme(DBHelper.TABLE_VEGETABLE);
    }

    @Override
    public List<VocabularyModel> getFruitList() {
        return getWordsByTheme(DBHelper.TABLE_FRUIT);
    }

    @Override
    public List<VocabularyModel> getAlphabetList() {
        return getWordsByTheme(DBHelper.TABLE_ALPHABET);
    }

    @Override
    public VocabularyModel getWordById(int wordId) {
        return null;
    }

    private VocabularyModel transformContentToModel(final ContentValues value) {
        return new VocabularyModel(value.getAsInteger(DBHelper.KEY_ID),
                value.getAsString(DBHelper.KEY_WORD),
                value.getAsString(DBHelper.KEY_WORD_TRANSLATE),
                value.getAsInteger(DBHelper.KEY_IMAGE),
                value.getAsInteger(DBHelper.KEY_SOUND_ORIGINAL),
                value.getAsInteger(DBHelper.KEY_SOUND_TRANSLATE));
    }

    private ContentValues transformModelToContent(final VocabularyModel model) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_WORD, model.getOrigin());
        values.put(DBHelper.KEY_WORD_TRANSLATE, model.getTranslate());
        values.put(DBHelper.KEY_IMAGE, model.getImageId());
        values.put(DBHelper.KEY_SOUND_ORIGINAL, model.getSoundOriginalId());
        values.put(DBHelper.KEY_SOUND_TRANSLATE, model.getSoundTranslateId());
        return values;
    }

    private List<VocabularyModel> transformToUse(List<ContentValues> values) {
        List<VocabularyModel> modelList = new ArrayList<>();
        for (ContentValues value: values) {
            modelList.add(transformContentToModel(value));
        }
        return modelList;
    }
}
