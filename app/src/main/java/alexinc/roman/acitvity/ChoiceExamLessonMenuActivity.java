package alexinc.roman.acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import alexinc.roman.global.Const;
import alexinc.roman.R;

/**
 * Created by alex on 28.03.2018.
 */

public final class ChoiceExamLessonMenuActivity extends AppCompatActivity {

    private RelativeLayout relativeLayoutMainLayout;
    private ImageView imageView;
    private TextView allScore;
    private TextView userScore;

    private Button btnTraining;
    private Button btnTestExam;
    private int section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_choice);
        findUI();
        setupUI();
        extractSelectedThemeToTraining(getIntent().getExtras());
        applyChoosedTheme(section);
    }

    private void extractSelectedThemeToTraining(final Bundle args) {
        if (args != null) {
            section = args.getInt(Const.SELECTED_SECTION, 0);
        }
    }

    private void findUI() {
        relativeLayoutMainLayout = findViewById(R.id.linear_layout_menu_choice);
        imageView = findViewById(R.id.image_view_menu_choice);
        allScore = findViewById(R.id.text_view_all_score);
        userScore = findViewById(R.id.text_view_user_score);
        btnTraining = findViewById(R.id.button_learn);
        btnTestExam = findViewById(R.id.button_test);
    }

    private void setupUI() {
        btnTraining.setOnClickListener(trainingClickListener);
        btnTestExam.setOnClickListener(examClickListener);
    }

    private void applyChoosedTheme(final int section) {
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
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_alphabet);
    }

    private void family() {
        relativeLayoutMainLayout.setBackgroundColor(getResources().getColor(R.color.colorFamily));
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_family);
    }

    private void vegetable() {
        relativeLayoutMainLayout.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_vegetable);
    }

    private void animal() {
        relativeLayoutMainLayout.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_animal);
    }

    private void fruit() {
        relativeLayoutMainLayout.setBackgroundColor(getResources().getColor(R.color.colorFriut));
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_fruit);
    }

    private View.OnClickListener trainingClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ChoiceExamLessonMenuActivity.this, LessonActivity.class);
            intent.putExtra(Const.SELECTED_SECTION, section);
            startActivity(intent);
        }
    };

    private View.OnClickListener examClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ChoiceExamLessonMenuActivity.this, ExamActivity.class);
            intent.putExtra(Const.SELECTED_SECTION, section);
            startActivity(intent);
        }
    };

}
