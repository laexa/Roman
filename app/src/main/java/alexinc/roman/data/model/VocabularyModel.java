package alexinc.roman.data.model;

public final class VocabularyModel {

    private int id;
    private String origin;
    private String translate;
    private int imageId;
    private int soundOriginalId;
    private int soundTranslateId;

    public VocabularyModel() {
    }

    public VocabularyModel(int id, String origin, String translate, int imageId, int soundOriginalId, int soundTranslateId) {
        this.id = id;
        this.origin = origin;
        this.translate = translate;
        this.imageId = imageId;
        this.soundOriginalId = soundOriginalId;
        this.soundTranslateId = soundTranslateId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getSoundOriginalId() {
        return soundOriginalId;
    }

    public void setSoundOriginalId(int soundOriginalId) {
        this.soundOriginalId = soundOriginalId;
    }

    public int getSoundTranslateId() {
        return soundTranslateId;
    }

    public void setSoundTranslateId(int soundTranslateId) {
        this.soundTranslateId = soundTranslateId;
    }
}
