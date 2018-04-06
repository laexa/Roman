package alexinc.roman.data.model;

import java.util.List;

public class ExamModel {

    private VocabularyModel answer;
    private List<VocabularyModel> variants;

    private boolean isGuessed = false;
    private int shootCount = 0;

    public ExamModel() {
    }

    public ExamModel(VocabularyModel answer, List<VocabularyModel> variants) {
        this.answer = answer;
        this.variants = variants;
    }

    public VocabularyModel getAnswer() {
        return answer;
    }

    public void setAnswer(VocabularyModel answer) {
        this.answer = answer;
    }

    public List<VocabularyModel> getVariants() {
        return variants;
    }

    public void setVariants(List<VocabularyModel> variants) {
        this.variants = variants;
    }

    public boolean isAnswer(VocabularyModel model) {
        return compare(model);
    }

    public boolean isAnswer(int positionVariant) {
        return compare(variants.get(positionVariant));
    }

    private void markIsAnsweredRight() {
        isGuessed = true;
    }

    private boolean compare(VocabularyModel model) {
        shootCount ++;
        if (answer.getId() == model.getId()) {
            if (shootCount == 1) markIsAnsweredRight();
        }
        return answer.getId() == model.getId();
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    public int getShootCount() {
        return shootCount;
    }
}
