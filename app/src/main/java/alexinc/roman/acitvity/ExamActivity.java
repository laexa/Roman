package alexinc.roman.acitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import alexinc.roman.R;
import alexinc.roman.data.DataOperation;
import alexinc.roman.data.DataProvider;
import alexinc.roman.data.model.ExamModel;
import alexinc.roman.data.model.VocabularyModel;
import alexinc.roman.global.Const;
import alexinc.roman.media.PlaySound;

public class ExamActivity extends AppCompatActivity implements View.OnClickListener {

    private int section;

    private LinearLayout backgroundView;

    private ImageView imageView_1;
    private ImageView imageView_2;
    private ImageView imageView_3;
    private ImageView imageView_4;

    private List<ImageView> imageViewList = new ArrayList<>();
    private TextView textView;

    private DataOperation dataOperation;
    private PlaySound playSound;

    private List<ExamModel> list = new ArrayList<>();
    private int listPosition;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_test);

        findUI();
        setupUI();

        extractSelectedThemeToTraining(getIntent().getExtras());

        dataOperation = new DataProvider(this);
        playSound = new PlaySound(this);

        changeTheme(section);
    }

    private void findUI() {
        backgroundView = findViewById(R.id.linear_layout_view_test);

        imageView_1 = findViewById(R.id.imageViewTest_1);
        imageView_2 = findViewById(R.id.imageViewTest_2);
        imageView_3 = findViewById(R.id.imageViewTest_3);
        imageView_4 = findViewById(R.id.imageViewTest_4);

        textView = findViewById(R.id.text_view_test);
    }

    private void setupUI() {
        imageView_1.setOnClickListener(this);
        imageView_2.setOnClickListener(this);
        imageView_3.setOnClickListener(this);
        imageView_4.setOnClickListener(this);

        imageViewList.add(imageView_1);
        imageViewList.add(imageView_2);
        imageViewList.add(imageView_3);
        imageViewList.add(imageView_4);
    }

    private void extractSelectedThemeToTraining(Bundle extras) {
        if (extras != null) {
            section = extras.getInt(Const.SELECTED_SECTION, 0);
        }
    }

    @Override
    public void onClick(View view) {
        int position = 0;
        switch (view.getId()) {
            case R.id.imageViewTest_1:
                position = 0;
                break;
            case R.id.imageViewTest_2:
                position = 1;
                break;
            case R.id.imageViewTest_3:
                position = 2;
                break;
            case R.id.imageViewTest_4:
                position = 3;
                break;
        }
        checkSelection(position);
    }

    private void changeTheme(int section) {
        switch (section) {
            case 1:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorAlphabet));
//                textView.setText("ПРОХОДИМО ТЕСТ ПО АЛФАВИТУ");
                setTheme(R.style.themeForAlphabet);
                list = dataOperation.getAlphabetExamList();
                break;
            case 2:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorFamily));
//                textView.setText("ПРОХОДИМО ТЕСТ ПО СІМЇ");
                setTheme(R.style.themeForFamily);
                list = dataOperation.getFamilyExamList();
                break;
            case 3:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
//                textView.setText("ПРОХОДИМО ТЕСТ ПО ОВОЩАХ");
                setTheme(R.style.themeForVegetable);
                list = dataOperation.getVegetableExamList();
                break;
            case 4:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
//                textView.setText("ПРОХОДИМО ТЕСТ ПО ТВАРИНАХ");
                setTheme(R.style.themeForAnimal);
                list = dataOperation.getAnimalExamList();
                break;
            case 5:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorFriut));
//                textView.setText("ПРОХОДИМО ТЕСТ ПО ФРУКТАХ");
                setTheme(R.style.themeForFriut);
                list = dataOperation.getFruitExamList();
                break;
        }

        processData();
    }

    private void processData() {
        if (!list.isEmpty())
            listPosition = 0;
        showData(list.get(listPosition));
    }

    private void showData(ExamModel model) {
        textView.setText(model.getAnswer().getTranslate());
        for (VocabularyModel vModel : model.getVariants()) {
            int index = model.getVariants().indexOf(vModel);
            imageViewList.get(index).setImageResource(vModel.getImageId());
        }
    }

    private void checkSelection(int position) {
        ExamModel exam = list.get(listPosition);
        if (exam.isAnswer(position)) {
            Toast.makeText(this, "True from " + exam.getShootCount() + " shoots", Toast.LENGTH_LONG).show();
            playSound.playPraiseSound();
            goToNext();
        } else {
            Toast.makeText(this, "False try again", Toast.LENGTH_LONG).show();
        }
    }

    private void goToNext() {
        if (listPosition == list.size() - 1) arriveToFinish();
        else listPosition = listPosition + 1;

        showData(list.get(listPosition));
    }

    private void arriveToFinish() {
        int totalScore = dataOperation.countGoodAnswers(list);
        if ((totalScore/list.size() * 100) > 60) {
            Toast.makeText(this, "Nice " + (totalScore/list.size() * 100) + "%", Toast.LENGTH_LONG).show();
            playSound.playPraiseSound();
        } else {
            Toast.makeText(this, "not bad but learn more and try again", Toast.LENGTH_LONG).show();
        }
    }

}
