package alexinc.roman.data;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import alexinc.roman.data.model.ExamModel;
import alexinc.roman.data.model.VocabularyModel;

public class DataProvider implements DataOperation {

    private static final String TAG = "DataProvider -> ";
    private DBHelper dbHelper;

    public DataProvider(final Context context) {
        Log.d(TAG, "create");
        this.dbHelper = new DBHelper(context);
    }

    @Override
    public void insert(String tableName, VocabularyModel model) {
        Log.d(TAG, "insert : " + model.toString());
        dbHelper.insert(tableName, transformModelToContent(model));
    }

    @Override
    public List<VocabularyModel> getWordsByTheme(String tableName) {
        Log.d(TAG, "getWordsByTheme : " + tableName);
        return transformToUse(dbHelper.getAllData(tableName));
    }

    @Nullable
    @Override
    public List<VocabularyModel> getAllWords(String tableName) {
        Log.d(TAG, "getAllWords : " + tableName);
        return null;
    }

    @Override
    public List<VocabularyModel> getFamilyList() {
        Log.d(TAG, "getFamilyList ");
        return getWordsByTheme(DBHelper.TABLE_FAMILY);
    }

    @Override
    public List<VocabularyModel> getAnimalList() {
        Log.d(TAG, "getAnimalList ");
        return getWordsByTheme(DBHelper.TABLE_ANIMAL);
    }

    @Override
    public List<VocabularyModel> getVegetableList() {
        Log.d(TAG, "getVegetableList ");
        return getWordsByTheme(DBHelper.TABLE_VEGETABLE);
    }

    @Override
    public List<VocabularyModel> getFruitList() {
        Log.d(TAG, "getFruitList ");
        return getWordsByTheme(DBHelper.TABLE_FRUIT);
    }

    @Override
    public List<VocabularyModel> getAlphabetList() {
        Log.d(TAG, "getAlphabetList ");
        return getWordsByTheme(DBHelper.TABLE_ALPHABET);
    }

    @Nullable
    @Override
    public VocabularyModel getWordById(int wordId) {
        Log.d(TAG, "getWordById : " + wordId);
        return null;
    }

    @Override
    public List<ExamModel> getFamilyExamList() {
        List<VocabularyModel> vocabularyList = getFamilyList();
        List<ExamModel> examList = new ArrayList<>();
        for (VocabularyModel vocabModel : vocabularyList) {
            ExamModel newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            while (!isAllUnique(newModel.getVariants())) {
                newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            }
            examList.add(newModel);
        }
        Log.d(TAG, "getFamilyExamList : size " + examList.size());
        return examList;
    }

    @Override
    public List<ExamModel> getAnimalExamList() {
        List<VocabularyModel> vocabularyList = getFamilyList();
        List<ExamModel> examList = new ArrayList<>();
        for (VocabularyModel vocabModel : vocabularyList) {
            ExamModel newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            while (!isAllUnique(newModel.getVariants())) {
                newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            }
            examList.add(newModel);
        }
        Log.d(TAG, "getAnimalExamList : size " + examList.size());
        return examList;
    }

    @Override
    public List<ExamModel> getVegetableExamList() {
        List<VocabularyModel> vocabularyList = getFamilyList();
        List<ExamModel> examList = new ArrayList<>();
        for (VocabularyModel vocabModel : vocabularyList) {
            ExamModel newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            while (!isAllUnique(newModel.getVariants())) {
                newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            }
            examList.add(newModel);
        }
        Log.d(TAG, "getVegetableExamList : size " + examList.size());
        return examList;
    }

    @Override
    public List<ExamModel> getFruitExamList() {
        List<VocabularyModel> vocabularyList = getFamilyList();
        List<ExamModel> examList = new ArrayList<>();
        for (VocabularyModel vocabModel : vocabularyList) {
            ExamModel newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            while (!isAllUnique(newModel.getVariants())) {
                newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            }
            examList.add(newModel);
        }
        Log.d(TAG, "getFruitExamList : size " + examList.size());
        return examList;
    }

    @Override
    public List<ExamModel> getAlphabetExamList() {
        List<VocabularyModel> vocabularyList = getFamilyList();
        List<ExamModel> examList = new ArrayList<>();
        for (VocabularyModel vocabModel : vocabularyList) {
            ExamModel newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            while (!isAllUnique(newModel.getVariants())) {
                newModel = new ExamModel(vocabModel, randomVariants(vocabModel));
            }
            examList.add(newModel);
        }
        Log.d(TAG, "getAlphabetExamList : size " + examList.size());
        return examList;
    }

    @Override
    public int countGoodAnswers(List<ExamModel> list) {
        int result = 0;
        for (ExamModel model: list) {
            if (model.isGuessed()) result++;
        }
        return result;
    }

    private VocabularyModel transformContentToModel(final ContentValues value) {
        Log.d(TAG, "transformContentToModel ");
        return new VocabularyModel(value.getAsInteger(DBHelper.KEY_ID),
                value.getAsString(DBHelper.KEY_WORD),
                value.getAsString(DBHelper.KEY_WORD_TRANSLATE),
                value.getAsInteger(DBHelper.KEY_IMAGE),
                value.getAsInteger(DBHelper.KEY_SOUND_ORIGINAL),
                value.getAsInteger(DBHelper.KEY_SOUND_TRANSLATE));
    }

    private ContentValues transformModelToContent(final VocabularyModel model) {
        Log.d(TAG, "transformModelToContent ");
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_WORD, model.getOrigin());
        values.put(DBHelper.KEY_WORD_TRANSLATE, model.getTranslate());
        values.put(DBHelper.KEY_IMAGE, model.getImageId());
        values.put(DBHelper.KEY_SOUND_ORIGINAL, model.getSoundOriginalId());
        values.put(DBHelper.KEY_SOUND_TRANSLATE, model.getSoundTranslateId());
        return values;
    }

    private List<VocabularyModel> transformToUse(List<ContentValues> values) {
        Log.d(TAG, "transformToUse : size " + values.size());
        List<VocabularyModel> modelList = new ArrayList<>();
        for (ContentValues value : values) {
            modelList.add(transformContentToModel(value));
        }
        return modelList;
    }

    private String randomTable() {
        int rand = new Random().nextInt(DBHelper.COUNT_TABLES);
        Log.d(TAG, "randomTable : number " + rand);
        switch (rand) {
            default:
            case 1:
//                return DBHelper.TABLE_ALPHABET;
            case 2:
                return DBHelper.TABLE_ANIMAL;
            case 3:
                return DBHelper.TABLE_FRUIT;
            case 4:
                return DBHelper.TABLE_FAMILY;
            case 5:
                return DBHelper.TABLE_VEGETABLE;
        }
    }

    private VocabularyModel randomWord() {
        Log.d(TAG, "randomWord { Open ");

        final List<VocabularyModel> list = getWordsByTheme(randomTable());
        int rand = new Random().nextInt(list.size() - 1);

        Log.d(TAG, "random position " + rand + " from the size " + list.size());
        Log.d(TAG, "randomWord Close }");
        return list.get(rand);
    }

    private List<VocabularyModel> randomVariants(VocabularyModel answer) {
        Log.d(TAG, "randomVariants ");
        final List<VocabularyModel> list = new ArrayList<>();
        list.add(answer);
        list.add(randomWord());
        list.add(randomWord());
        list.add(randomWord());
        Collections.shuffle(list);
        return list;
    }

    private boolean isAllUnique(List<VocabularyModel> list) {
        Log.d(TAG, "isAllUnique ");
        for (VocabularyModel model : list) {
            int positionMain = list.indexOf(model);

            for (int secondIndex = positionMain + 1; secondIndex < list.size(); secondIndex++) {

                VocabularyModel secondModel = list.get(secondIndex);

                if (secondModel.getId() == model.getId()
                        && secondModel.getOrigin().trim().equals(model.getOrigin().trim())
                        && secondModel.getTranslate().trim().equals(model.getTranslate().trim())) {
                    Log.d(TAG, "isAllUnique : false positions [ " + positionMain + " , " + secondIndex + " ]");
                    return false;
                }
            }
        }
        Log.d(TAG, "isAllUnique : true");
        return true;
    }

}
