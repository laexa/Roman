package alexinc.roman.acitvity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import alexinc.roman.global.SharedPrefManager;
import alexinc.roman.media.PlaySound;

public final class ExamActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ExamActivity -> ";

    private int section;

    private RelativeLayout backgroundView;

    private ImageView imageVariant_1;
    private ImageView imageVariant_2;
    private ImageView imageVariant_3;
    private ImageView imageVariant_4;

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
        backgroundView = findViewById(R.id.full_layout);

        imageVariant_1 = findViewById(R.id.iv_1_Variant);
        imageVariant_2 = findViewById(R.id.iv_2_Variant);
        imageVariant_3 = findViewById(R.id.iv_3_Variant);
        imageVariant_4 = findViewById(R.id.iv_4_Variant);

        textView = findViewById(R.id.tvQuestion);
    }

    private void setupUI() {
        imageVariant_1.setOnClickListener(this);
        imageVariant_2.setOnClickListener(this);
        imageVariant_3.setOnClickListener(this);
        imageVariant_4.setOnClickListener(this);

        imageViewList.add(imageVariant_1);
        imageViewList.add(imageVariant_2);
        imageViewList.add(imageVariant_3);
        imageViewList.add(imageVariant_4);
    }

    private void extractSelectedThemeToTraining(Bundle extras) {
        if (extras != null) {
            section = extras.getInt(Const.SELECTED_SECTION, 0);
        }
    }

    @Override
    public void onClick(View view) {
        checkSelection(imageViewList.indexOf(view));
    }

    private void changeTheme(int section) {
        switch (section) {
            case Const.ALPHABET:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorAlphabet));
                setTheme(R.style.themeForAlphabet);
                list = dataOperation.getAlphabetExamList();
                break;
            case Const.FAMILY:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorFamily));
                list = dataOperation.getFamilyExamList();
                break;
            case Const.VEGETABLE:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
                setTheme(R.style.themeForVegetable);
                list = dataOperation.getVegetableExamList();
                break;
            case Const.ANIMAL:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
                setTheme(R.style.themeForAnimal);
                list = dataOperation.getAnimalExamList();
                break;
            case Const.FRUIT:
                backgroundView.setBackgroundColor(getResources().getColor(R.color.colorFruit));
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
        storeResult(totalScore);
        String displayMsg = "Your result = " + totalScore;
        playSound.playPraiseSound();
        finalWindowShow(displayMsg);
    }

    private void finalWindowShow(final String msg) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        builder.setTitle("Congratulation!")
                .setMessage(msg)
                .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ExamActivity.this.finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }


    private void storeResult(final int totalScore) {
        SharedPrefManager manager = SharedPrefManager.getInstance();
        switch (section) {
            case Const.ALPHABET:
                manager.stroreAlphabetUser(totalScore);
                break;
            case Const.FAMILY:
                manager.stroreFamilyUser(totalScore);
                break;
            case Const.VEGETABLE:
                manager.stroreVegetableScoreUser(totalScore);
                break;
            case Const.ANIMAL:
                manager.stroreAnimalUser(totalScore);
                break;
            case Const.FRUIT:
                manager.stroreFamilyUser(totalScore);
                break;
        }
    }

}
