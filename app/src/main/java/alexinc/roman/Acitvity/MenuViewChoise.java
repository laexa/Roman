package alexinc.roman.Acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import alexinc.roman.R;

/**
 * Created by alex on 28.03.2018.
 */

public class MenuViewChoise extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout linearLayout;
    private ImageView imageView;
    private TextView allScore;
    private TextView userScore;

    private Button buttonLearn;
    private Button buttonTest;
    private int section;
    private Bundle bundle;

    private final int ALPHABET = 1;
    private final int FAMILY = 2;
    private final int VEGETABLE = 3;
    private final int ANIMAL = 4;
    private final int FRUIT = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        bundle = getIntent().getExtras();
        section = bundle.getInt("section");

        changeTheme(section);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_choice);

        linearLayout = findViewById(R.id.linear_layout_menu_choice);
        imageView = findViewById(R.id.image_view_menu_choice);
        allScore = findViewById(R.id.text_view_all_score);
        userScore = findViewById(R.id.text_view_user_score);
        buttonLearn = findViewById(R.id.button_learn);
        buttonTest = findViewById(R.id.button_test);



        if(section == 1){
            alpabet();
        }else if (section == 2){
            family();
        }else if (section == 3){
            vegetable();
        }else if (section == 4){
            animal();
        }else if (section == 5){
            fruit();
        }

        buttonLearn.setOnClickListener(this);
        buttonTest.setOnClickListener(this);
        buttonLearn.setText(R.string.learn);
        buttonTest.setText(R.string.testLearn);

    }

    private void alpabet(){

        linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAlphabet));
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_alphabet);
        setTheme(R.style.themeForAlphabet);

    }

    private void family(){

        linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFamily));
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_family);

    }

    private void vegetable(){

        linearLayout.setBackgroundColor(getResources().getColor(R.color.colorVegetable));
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_vegetable);

    }

    private void animal(){

        linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAnimal));
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_animal);

    }

    private void fruit(){

        linearLayout.setBackgroundColor(getResources().getColor(R.color.colorFriut));
        allScore.setText("30");
        userScore.setText("13");
        imageView.setImageResource(R.drawable.ic_fruit);

    }

    private void changeTheme(int section){
        if(section == ALPHABET){

            setTheme(R.style.themeForAlphabet);

        }else if (section == FAMILY){

            setTheme(R.style.themeForFamily);

        }else if (section == VEGETABLE){

            setTheme(R.style.themeForVegetable);

        }else if (section == ANIMAL){

            setTheme(R.style.themeForAnimal);

        }else if (section == FRUIT){
            setTheme(R.style.themeForFriut);
        }

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button_learn){

            Intent intent = new Intent(this , LearnActivity.class);
            intent.putExtra("section", section);
            startActivity(intent);

        }else if (v.getId() == R.id.button_test){

            Intent intent = new Intent(this , TestActivity.class);
            intent.putExtra("section", section);
            startActivity(intent);

        }
    }
}
