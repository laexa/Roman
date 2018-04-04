package alexinc.roman.acitvity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import alexinc.roman.global.Const;
import alexinc.roman.data.DataBaseHelper;
import alexinc.roman.click_process.OnClickLessonLogic;
import alexinc.roman.media.PlaySound;
import alexinc.roman.R;

/**
 * Created by alex on 28.03.2018.
 */

public final class LessonActivity extends AppCompatActivity {

    private int section;

    private LinearLayout linearLayout;
    private TextView textViewWord;
    private TextView textViewTranslateWord;
    private ImageView imageView;
    private Button leftButton;
    private Button rightButton;
    private Button againButton;

    private DataBaseHelper dataBaseHelper;
    private Cursor cursor = null;
    private PlaySound playSound;
    protected OnClickLessonLogic onClickLessonLogic;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_learn);
        findUI();
        setupUI();
        dataBaseHelper = new DataBaseHelper(this);
        extractSelectedThemeToTraining(getIntent().getExtras());
        changeTheme(section);
    }

    private void extractSelectedThemeToTraining(Bundle extras) {
        if (extras != null) {
            section = extras.getInt(Const.SELECTED_SECTION, 0);
        }
    }

    private void findUI() {
        linearLayout = findViewById(R.id.linear_layout_view_learn);
        textViewWord = findViewById(R.id.text_view_word);
        textViewTranslateWord = findViewById(R.id.text_view_translate_word);
        imageView = findViewById(R.id.image_view_learn);

        leftButton = findViewById(R.id.button_left_layout_learn);
        rightButton = findViewById(R.id.button_right_layout_learn);
        againButton = findViewById(R.id.button_again_layout_learn);
    }

    private void setupUI() {
        leftButton.setOnClickListener(onClickLessonLogic);
        rightButton.setOnClickListener(onClickLessonLogic);
        againButton.setOnClickListener(onClickLessonLogic);
    }

    private void changeTheme(int section) {
        switch (section) {
            case 1:
                setTheme(R.style.themeForAlphabet);
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAlphabet));
                imageView.setImageResource(R.drawable.ic_alphabet);
                loadData(DataBaseHelper.TABLE_ALPHABET);
                onClickLessonLogic = new OnClickLessonLogic(this, 1, textViewWord, textViewTranslateWord, imageView);
                break;
            case 2:
                setTheme(R.style.themeForFamily);
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFamily));
                imageView.setImageResource(R.drawable.ic_family);
                loadData(DataBaseHelper.TABLE_FAMILY);
                onClickLessonLogic = new OnClickLessonLogic(this, 2, textViewWord, textViewTranslateWord, imageView);
                break;
            case 3:
                setTheme(R.style.themeForVegetable);
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
                imageView.setImageResource(R.drawable.ic_vegetable);
                loadData(DataBaseHelper.TABLE_VEGETABLE);
                onClickLessonLogic = new OnClickLessonLogic(this, 3, textViewWord, textViewTranslateWord, imageView);
                break;
            case 4:
                setTheme(R.style.themeForAnimal);
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
                imageView.setImageResource(R.drawable.ic_animal);
                loadData(DataBaseHelper.TABLE_ANIMAL);
                onClickLessonLogic = new OnClickLessonLogic(this, 4, textViewWord, textViewTranslateWord, imageView);
                break;
            case 5:
                setTheme(R.style.themeForFriut);
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFriut));
                imageView.setImageResource(R.drawable.ic_fruit);
                loadData(DataBaseHelper.TABLE_FRUIT);
                onClickLessonLogic = new OnClickLessonLogic(this, 5, textViewWord, textViewTranslateWord, imageView);
                break;
        }
    }

    private void loadData(String table_name) {
        playSound = new PlaySound(this);
        cursor = dataBaseHelper.getData(table_name);
        cursor.moveToFirst();
        textViewWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD)));
        textViewTranslateWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD_TRANSLATE)));
        imageView.setImageResource(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_IMAGE)));
        playSound.getSound(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_SOUND_TRANSLATE)));
        cursor.close();
    }
}
