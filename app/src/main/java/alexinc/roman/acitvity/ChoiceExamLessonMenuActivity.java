package alexinc.roman.acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.MessageFormat;

import alexinc.roman.global.Const;
import alexinc.roman.R;
import alexinc.roman.global.SharedPrefManager;

/**
 * Created by alex on 28.03.2018.
 */

public final class ChoiceExamLessonMenuActivity extends AppCompatActivity {

    private static final String TAG = "ChoiceExamLessonMenu -> ";

    private RelativeLayout relativeLayoutMainLayout;
    private ImageView imageView;
    private TextView allScore;
    private TextView userScore;

    private Button btnTraining;
    private Button btnTestExam;
    private int section;
    private SharedPrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_choice);
        findUI();
        setupUI();
        prefManager = SharedPrefManager.getInstance();
        extractSelectedThemeToTraining(getIntent().getExtras());
        applyChoiceTheme(section);
    }

    private void extractSelectedThemeToTraining(final Bundle args) {
        if (args != null) {
            section = args.getInt(Const.SELECTED_SECTION, 0);
        }
    }

    private void findUI() {
        relativeLayoutMainLayout = findViewById(R.id.full_layout);
        imageView = findViewById(R.id.ivThemeKindPreview);
        userScore = findViewById(R.id.tvBestScore);
        allScore = findViewById(R.id.tvTotalPossibleScore);
        btnTraining = findViewById(R.id.btnLearnGo);
        btnTestExam = findViewById(R.id.btnExamGo);
    }

    private void setupUI() {
        btnTraining.setOnClickListener(trainingClickListener);
        btnTestExam.setOnClickListener(examClickListener);
    }

    private void applyChoiceTheme(final int section) {
        switch (section) {
            case Const.ALPHABET:
                setTheme(R.style.themeForAlphabet);
                alphabet();
                break;
            case Const.FAMILY:
                setTheme(R.style.themeForFamily);
                family();
                break;
            case Const.VEGETABLE:
                setTheme(R.style.themeForVegetable);
                vegetable();
                break;
            case Const.ANIMAL:
                setTheme(R.style.themeForAnimal);
                animal();
                break;
            case Const.FRUIT:
            default:
                setTheme(R.style.themeForFriut);
                fruit();
                break;
        }
    }

    private void alphabet() {
        relativeLayoutMainLayout.setBackgroundColor(getResources().getColor(R.color.colorAlphabet));
        allScore.setText(MessageFormat.format("{0}", prefManager.retrieveAlphabetAll()));
        userScore.setText(MessageFormat.format("{0}", prefManager.retrieveAlphabetUser()));
        imageView.setImageResource(R.drawable.ic_alphabet);
    }

    private void family() {
        relativeLayoutMainLayout.setBackgroundColor(getResources().getColor(R.color.colorFamily));
        allScore.setText(MessageFormat.format("{0}", prefManager.retrieveFamilyAll()));
        userScore.setText(MessageFormat.format("{0}", prefManager.retrieveFamilyUser()));
        imageView.setImageResource(R.drawable.ic_family);
    }

    private void vegetable() {
        relativeLayoutMainLayout.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
        allScore.setText(MessageFormat.format("{0}", prefManager.retrieveVegetableScoreAll()));
        userScore.setText(MessageFormat.format("{0}", prefManager.retrieveVegetableScoreUser()));
        imageView.setImageResource(R.drawable.ic_vegetable);
    }

    private void animal() {
        relativeLayoutMainLayout.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
        allScore.setText(MessageFormat.format("{0}", prefManager.retrieveAnimalAll()));
        userScore.setText(MessageFormat.format("{0}", prefManager.retrieveAnimalUser()));
        imageView.setImageResource(R.drawable.ic_animal);
    }

    private void fruit() {
        relativeLayoutMainLayout.setBackgroundColor(getResources().getColor(R.color.colorFruit));
        allScore.setText(MessageFormat.format("{0}", prefManager.retrieveFruitScoreAll()));
        userScore.setText(MessageFormat.format("{0}", prefManager.retrieveFruitScoreUser()));
        imageView.setImageResource(R.drawable.ic_fruit);
    }

    private View.OnClickListener trainingClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ChoiceExamLessonMenuActivity.this, LessonActivity.class);
            intent.putExtra(Const.SELECTED_SECTION, section);
            startActivity(intent);
            finish();
        }
    };

    private View.OnClickListener examClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ChoiceExamLessonMenuActivity.this, ExamActivity.class);
            intent.putExtra(Const.SELECTED_SECTION, section);
            startActivity(intent);
            finish();
        }
    };

}
