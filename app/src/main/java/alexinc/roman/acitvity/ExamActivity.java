package alexinc.roman.acitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import alexinc.roman.R;
import alexinc.roman.click_process.OnClickExamLogic;
import alexinc.roman.global.Const;

/**
 * Created by alex on 28.03.2018.
 */

public class ExamActivity extends AppCompatActivity {

    private int section;

    private LinearLayout linearLayout;

    private ImageView imageView_1;
    private ImageView imageView_2;
    private ImageView imageView_3;
    private ImageView imageView_4;
    private TextView textView;

    protected OnClickExamLogic clickListenerLogic;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_test);
        findUI();
        setupUI();
        extractSelectedThemeToTraining(getIntent().getExtras());
        clickListenerLogic = new OnClickExamLogic(imageView_1, imageView_2, imageView_3, imageView_4, textView, this);
        changeTheme(section);
    }

    private void findUI() {
        linearLayout = findViewById(R.id.linear_layout_view_test);

        imageView_1 = findViewById(R.id.imageViewTest_1);
        imageView_2 = findViewById(R.id.imageViewTest_2);
        imageView_3 = findViewById(R.id.imageViewTest_3);
        imageView_4 = findViewById(R.id.imageViewTest_4);

        textView = findViewById(R.id.text_view_test);
    }

    private void setupUI() {

    }

    private void extractSelectedThemeToTraining(Bundle extras) {
        if (extras != null) {
            section = extras.getInt(Const.SELECTED_SECTION, 0);
        }
    }

    private void changeTheme(int section) {
        imageView_1.setOnClickListener(clickListenerLogic);
        switch (section) {
            case 1:
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAlphabet));
                textView.setText("ПРОХОДИМО ТЕСТ ПО АЛФАВИТУ");
                imageView_1.setImageResource(R.drawable.ic_son);
                imageView_2.setImageResource(R.drawable.ic_son);
                imageView_3.setImageResource(R.drawable.ic_son);
                imageView_4.setImageResource(R.drawable.ic_son);
                setTheme(R.style.themeForAlphabet);
                break;
            case 2:
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFamily));
                textView.setText("ПРОХОДИМО ТЕСТ ПО СІМЇ");
                imageView_1.setImageResource(R.drawable.ic_son);
                imageView_2.setImageResource(R.drawable.ic_son);
                imageView_3.setImageResource(R.drawable.ic_son);
                imageView_4.setImageResource(R.drawable.ic_son);
                setTheme(R.style.themeForFamily);
                break;
            case 3:
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
                textView.setText("ПРОХОДИМО ТЕСТ ПО ОВОЩАХ");
                imageView_1.setImageResource(R.drawable.ic_son);
                imageView_2.setImageResource(R.drawable.ic_son);
                imageView_3.setImageResource(R.drawable.ic_son);
                imageView_4.setImageResource(R.drawable.ic_son);
                setTheme(R.style.themeForVegetable);
                break;
            case 4:
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
                textView.setText("ПРОХОДИМО ТЕСТ ПО ТВАРИНАХ");
                imageView_1.setImageResource(R.drawable.ic_son);
                imageView_2.setImageResource(R.drawable.ic_son);
                imageView_3.setImageResource(R.drawable.ic_son);
                imageView_4.setImageResource(R.drawable.ic_son);
                setTheme(R.style.themeForAnimal);
                break;
            case 5:
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFriut));
                textView.setText("ПРОХОДИМО ТЕСТ ПО ФРУКТАХ");
                imageView_1.setImageResource(R.drawable.ic_son);
                imageView_2.setImageResource(R.drawable.ic_son);
                imageView_3.setImageResource(R.drawable.ic_son);
                imageView_4.setImageResource(R.drawable.ic_son);
                setTheme(R.style.themeForFriut);
                break;
        }
    }
}
