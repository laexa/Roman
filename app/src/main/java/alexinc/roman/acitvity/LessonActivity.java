package alexinc.roman.acitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    private int section;

    private LinearLayout backGroundView;
    private TextView tvOriginal;
    private TextView tvTranslate;
    private ImageView ivPreview;
    private Button btnPrevious;
    private Button btnNext;
    private Button btnPlayAgain;

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
        backGroundView = findViewById(R.id.linear_layout_view_learn);

        tvOriginal = findViewById(R.id.text_view_word);
        tvTranslate = findViewById(R.id.text_view_translate_word);

        ivPreview = findViewById(R.id.image_view_learn);

        btnPrevious = findViewById(R.id.button_left_layout_learn);
        btnNext = findViewById(R.id.button_right_layout_learn);
        btnPlayAgain = findViewById(R.id.button_again_layout_learn);
    }

    private void setListeners() {
        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPlayAgain.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_left_layout_learn:
                previous();
                break;
            case R.id.button_right_layout_learn:
                next();
                break;
            case R.id.button_again_layout_learn:
                repeat();
                break;
        }
    }

    private void changeTheme(int section) {
        switch (section) {
            case 1:
                prepareAlphabet();
                break;
            case 2:
                prepareFamily();
                break;
            case 3:
                prepareVegetable();
                break;
            case 4:
                prepareAnimal();
                break;
            case 5:
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
        backGroundView.setBackgroundColor(getResources().getColor(R.color.colorFriut));
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
