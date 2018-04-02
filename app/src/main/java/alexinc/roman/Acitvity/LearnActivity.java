package alexinc.roman.Acitvity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import alexinc.roman.DataBase.DataBaseHelper;
import alexinc.roman.ClickListene.OnClickListeneLearnClass;
import alexinc.roman.PlaySound.PlaySound;
import alexinc.roman.R;

/**
 * Created by alex on 28.03.2018.
 */

public class LearnActivity extends AppCompatActivity {

    private int section;
    private Bundle bundle;
    LinearLayout linearLayout;
    TextView textViewWord;
    TextView textViewTranslateWord;
    ImageView imageView;
    Button leftButton;
    Button rightButton;
    Button againButton;
    DataBaseHelper dataBaseHelper;
    private Cursor cursor = null;
    private int countCursor = 0;
    private PlaySound playSound;
    OnClickListeneLearnClass onClickListeneLearnClass;

    protected void onCreate(Bundle savedInstanceState){

        bundle = getIntent().getExtras();
        section = bundle.getInt("section");

        changeTheme(section);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_learn);
        dataBaseHelper = new DataBaseHelper(this);

        linearLayout = findViewById(R.id.linear_layout_view_learn);
        textViewWord = findViewById(R.id.text_view_word);
        textViewTranslateWord = findViewById(R.id.text_view_translate_word);
        imageView = findViewById(R.id.image_view_learn);

        leftButton = findViewById(R.id.button_left_layout_learn);
        rightButton = findViewById(R.id.button_right_layout_learn);
        againButton = findViewById(R.id.button_again_layout_learn);




        if(section == 1){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAlphabet));
            imageView.setImageResource(R.drawable.ic_vegetable);

        }else if (section == 2){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFamily));
            loadData(DataBaseHelper.TABLE_FAMILY);
            onClickListeneLearnClass = new OnClickListeneLearnClass(this, 2, textViewWord, textViewTranslateWord, imageView);


        }else if (section == 3){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
            loadData(DataBaseHelper.TABLE_VEGETABLE);
            onClickListeneLearnClass = new OnClickListeneLearnClass(this, 3, textViewWord, textViewTranslateWord, imageView);

        }else if (section == 4){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
            loadData(DataBaseHelper.TABLE_ANIMAL);
            onClickListeneLearnClass = new OnClickListeneLearnClass(this, 4, textViewWord, textViewTranslateWord, imageView);

        }else if (section == 5){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFriut));
            loadData(DataBaseHelper.TABLE_FRUIT);
            onClickListeneLearnClass = new OnClickListeneLearnClass(this, 5, textViewWord, textViewTranslateWord, imageView);

        }

        leftButton.setOnClickListener(onClickListeneLearnClass);
        rightButton.setOnClickListener(onClickListeneLearnClass);
        againButton.setOnClickListener(onClickListeneLearnClass);

    }

    private void changeTheme(int section) {


        if(section == 1){

            setTheme(R.style.themeForAlphabet);

        }else if (section == 2){

            setTheme(R.style.themeForFamily);

        }else if (section == 3){

            setTheme(R.style.themeForVegetable);

        }else if (section == 4){

            setTheme(R.style.themeForAnimal);

        }else if (section == 5){
            setTheme(R.style.themeForFriut);
        }
    }

    private void loadData(String table_name){

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
