package alexinc.roman.acitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alexinc.roman.R;
import alexinc.roman.data.DataOperation;
import alexinc.roman.data.DataProvider;
import alexinc.roman.data.model.VocabularyModel;
import alexinc.roman.global.Const;
import alexinc.roman.media.PlaySound;

public final class LessonActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LessonActivity -> ";

    private int section;

    private RelativeLayout backGroundView;
    private TextView tvOriginal;
    private TextView tvTranslate;
    private ImageView ivPreview;
    private ImageButton btnPrevious;
    private ImageButton btnNext;
    private ImageButton btnPlayAgain;

    private DataOperation dataOperation;
    private PlaySound playSound;

    private int listPosition;
    private List<VocabularyModel> list = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_learn);
        findUI();

        dataOperation = new DataProvider(this);
        playSound = new PlaySound(this);

        extractSelectedThemeToTraining(getIntent().getExtras());

        changeTheme(section);
    }

    private void extractSelectedThemeToTraining(Bundle extras) {
        if (extras != null) {
            section = extras.getInt(Const.SELECTED_SECTION, 0);
        }
    }

    private void findUI() {
        backGroundView = findViewById(R.id.full_layout);

        tvOriginal = findViewById(R.id.tvOriginalWord);
        tvTranslate = findViewById(R.id.tvTranslateWord);

        ivPreview = findViewById(R.id.ivLearnWord);

        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnPlayAgain = findViewById(R.id.btnPlay);
    }

    private void setListeners() {
        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPlayAgain.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPrevious:
                previous();
                break;
            case R.id.btnNext:
                next();
                break;
            case R.id.btnPlay:
                repeat();
                break;
        }
    }

    private void changeTheme(int section) {
        switch (section) {
            case Const.ALPHABET:
                prepareAlphabet();
                break;
            case Const.FAMILY:
                prepareFamily();
                break;
            case Const.VEGETABLE:
                prepareVegetable();
                break;
            case Const.ANIMAL:
                prepareAnimal();
                break;
            case Const.FRUIT:
                prepareFruit();
                break;
        }
        processData();
    }

    private void processData() {
        if (!list.isEmpty()) {
            listPosition = 0;
            showData(list.get(listPosition));
            setListeners();
        }
    }

    private void previous() {
        if (listPosition == 0) listPosition = list.size() - 1;
        else listPosition = listPosition - 1;

        showData(list.get(listPosition));
    }

    private void next() {
        if (listPosition == list.size() - 1) listPosition = 0;
        else listPosition = listPosition + 1;

        showData(list.get(listPosition));
    }

    private void repeat() {
        playSound.playSoundById(list.get(listPosition).getSoundTranslateId());
    }

    private void showData(VocabularyModel model) {
        tvOriginal.setText(model.getOrigin());
        tvTranslate.setText(model.getTranslate());
        ivPreview.setImageResource(model.getImageId());
        playSound.playSoundById(model.getSoundTranslateId());
    }

    private void prepareFruit() {
        setTheme(R.style.themeForFriut);
        backGroundView.setBackgroundColor(getResources().getColor(R.color.colorFruit));
        ivPreview.setImageResource(R.drawable.ic_fruit);
        list = dataOperation.getFruitList();
    }

    private void prepareAnimal() {
        setTheme(R.style.themeForAnimal);
        backGroundView.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
        ivPreview.setImageResource(R.drawable.ic_animal);
        list = dataOperation.getAnimalList();
    }

    private void prepareVegetable() {
        setTheme(R.style.themeForVegetable);
        backGroundView.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
        ivPreview.setImageResource(R.drawable.ic_vegetable);
        list = dataOperation.getVegetableList();
    }

    private void prepareFamily() {
        setTheme(R.style.themeForFamily);
        backGroundView.setBackgroundColor(getResources().getColor(R.color.colorFamily));
        ivPreview.setImageResource(R.drawable.ic_family);
        list = dataOperation.getFamilyList();
    }

    private void prepareAlphabet() {
        setTheme(R.style.themeForAlphabet);
        backGroundView.setBackgroundColor(getResources().getColor(R.color.colorAlphabet));
        ivPreview.setImageResource(R.drawable.ic_alphabet);
        list = dataOperation.getAlphabetList();
    }

}
