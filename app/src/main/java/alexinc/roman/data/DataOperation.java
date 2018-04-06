package alexinc.roman.data;

import java.util.List;

import alexinc.roman.data.model.ExamModel;
import alexinc.roman.data.model.VocabularyModel;

public interface DataOperation {

    void insert(String tableName, VocabularyModel model);

    List<VocabularyModel> getWordsByTheme(String tableName);

    List<VocabularyModel> getAllWords(String tableName);

    VocabularyModel getWordById(int wordId);

    List<VocabularyModel> getFamilyList();

    List<VocabularyModel> getAnimalList();

    List<VocabularyModel> getVegetableList();

    List<VocabularyModel> getFruitList();

    List<VocabularyModel> getAlphabetList();

    List<ExamModel> getFamilyExamList();

    List<ExamModel> getAnimalExamList();

    List<ExamModel> getVegetableExamList();

    List<ExamModel> getFruitExamList();

    List<ExamModel> getAlphabetExamList();

    int countGoodAnswers(List<ExamModel> list);
}
