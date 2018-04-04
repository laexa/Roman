package alexinc.roman.acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import alexinc.roman.global.Const;
import alexinc.roman.R;

public final class ChoiceKindThemeMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ChoiceKindThemeMenuActivity";

    private Button familyButtonMenu;
    private Button alphabetButtonMenu;
    private Button vegetableButtonMenu;
    private Button animalButtonMenu;
    private Button fruitButtonMenu;

    private RelativeLayout alphabetLayout;
    private RelativeLayout familyLayout;
    private RelativeLayout vegetableLayout;
    private RelativeLayout animalLayout;
    private RelativeLayout fruitLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_main);
        findUI();
        setupUI();
    }

    /**
     * find ui elements on the content view for setup in future
     * */
    private void findUI() {
        familyButtonMenu = findViewById(R.id.familyButtonMenu);
        alphabetButtonMenu = findViewById(R.id.alphabetButtonMenu);
        vegetableButtonMenu = findViewById(R.id.vegetableButtonMenu);
        animalButtonMenu = findViewById(R.id.animalButtonMenu);
        fruitButtonMenu = findViewById(R.id.fruitButtonMenu);

        alphabetLayout = findViewById(R.id.relativ_layout_menu_main_alphabet);
        familyLayout = findViewById(R.id.relativ_layout_menu_main_family);
        vegetableLayout = findViewById(R.id.relativ_layout_menu_main_vegetable);
        animalLayout = findViewById(R.id.relativ_layout_menu_main_animal);
        fruitLayout = findViewById(R.id.relativ_layout_menu_main_fruit);
    }

    /**
     * setup ui elements
     * currently attach click listeners to buttons
     * */
    private void setupUI() {
        alphabetButtonMenu.setOnClickListener(this);
        vegetableButtonMenu.setOnClickListener(this);
        animalButtonMenu.setOnClickListener(this);
        fruitButtonMenu.setOnClickListener(this);
        familyButtonMenu.setOnClickListener(this);

        alphabetLayout.setOnClickListener(this);
        familyLayout.setOnClickListener(this);
        vegetableLayout.setOnClickListener(this);
        animalLayout.setOnClickListener(this);
        fruitLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.d(this.getClass().getSimpleName(), String.format("onClickById(%d)", v.getId()));
        Intent intent = new Intent(this, ChoiceExamLessonMenuActivity.class);

        switch (v.getId()) {
            case R.id.alphabetButtonMenu:
            case R.id.relativ_layout_menu_main_alphabet:
                intent.putExtra(Const.SELECTED_SECTION, Const.ALPHABET);
                break;

            case R.id.vegetableButtonMenu:
            case R.id.relativ_layout_menu_main_vegetable:
                intent.putExtra(Const.SELECTED_SECTION, Const.VEGETABLE);
                break;

            case R.id.animalButtonMenu:
            case R.id.relativ_layout_menu_main_animal:
                intent.putExtra(Const.SELECTED_SECTION, Const.ANIMAL);
                break;

            case R.id.familyButtonMenu:
            case R.id.relativ_layout_menu_main_family:
                intent.putExtra(Const.SELECTED_SECTION, Const.FAMILY);
                break;

            case R.id.fruitButtonMenu:
            case R.id.relativ_layout_menu_main_fruit:
                intent.putExtra(Const.SELECTED_SECTION, Const.FRUIT);
                break;
        }
        startActivity(intent);
    }
}

