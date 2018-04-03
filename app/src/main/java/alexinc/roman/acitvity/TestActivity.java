package alexinc.roman.acitvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import alexinc.roman.ClickListene.OnClickListeneTestClass;
import alexinc.roman.R;

/**
 * Created by alex on 28.03.2018.
 */

public class TestActivity extends AppCompatActivity{

    private LinearLayout linearLayout;
    private Bundle bundle;
    private int section;

    private ImageView imageView_1;
    private ImageView imageView_2;
    private ImageView imageView_3;
    private ImageView imageView_4;
    private TextView textView;
    OnClickListeneTestClass onClickListeneTestClass;

    protected void onCreate(Bundle savedInstanceState){

        bundle = getIntent().getExtras();
        section = bundle.getInt("section");

        changeTheme(section);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_test);

        linearLayout = findViewById(R.id.linear_layout_view_test);
        imageView_1 = findViewById(R.id.imageViewTest_1);
        imageView_2 = findViewById(R.id.imageViewTest_2);
        imageView_3 = findViewById(R.id.imageViewTest_3);
        imageView_4 = findViewById(R.id.imageViewTest_4);
        textView = findViewById(R.id.text_view_test);

        onClickListeneTestClass = new OnClickListeneTestClass(imageView_1,imageView_2,imageView_3,imageView_4,textView,this);

        if(section == 1){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAlphabet));
            textView.setText("ПРОХОДИМО ТЕСТ ПО АЛФАВИТУ");
            imageView_1.setOnClickListener(onClickListeneTestClass);

        }else if (section == 2){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFamily));
            textView.setText("ПРОХОДИМО ТЕСТ ПО СІМЇ");
            imageView_1.setImageResource(R.drawable.ic_son);
            imageView_2.setImageResource(R.drawable.ic_son);
            imageView_3.setImageResource(R.drawable.ic_son);
            imageView_4.setImageResource(R.drawable.ic_son);

        }else if (section == 3){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
            textView.setText("ПРОХОДИМО ТЕСТ ПО ОВОЩАХ");
            imageView_1.setImageResource(R.drawable.ic_son);
            imageView_2.setImageResource(R.drawable.ic_son);
            imageView_3.setImageResource(R.drawable.ic_son);
            imageView_4.setImageResource(R.drawable.ic_son);

        }else if (section == 4){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
            textView.setText("ПРОХОДИМО ТЕСТ ПО ТВАРИНАХ");
            imageView_1.setImageResource(R.drawable.ic_son);
            imageView_2.setImageResource(R.drawable.ic_son);
            imageView_3.setImageResource(R.drawable.ic_son);
            imageView_4.setImageResource(R.drawable.ic_son);

        }else if (section == 5){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFriut));
            textView.setText("ПРОХОДИМО ТЕСТ ПО ФРУКТАХ");
            imageView_1.setImageResource(R.drawable.ic_son);
            imageView_2.setImageResource(R.drawable.ic_son);
            imageView_3.setImageResource(R.drawable.ic_son);
            imageView_4.setImageResource(R.drawable.ic_son);

        }

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

}
