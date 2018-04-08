package alexinc.roman.acitvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import alexinc.roman.R;
import alexinc.roman.global.Const;

public final class ChoiceKindThemeMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ChoiceKindThemeMenu -> ";

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
     */
    private void findUI() {
        alphabetLayout = findViewById(R.id.rlAlphabetCont);
        familyLayout = findViewById(R.id.rlFamilyCont);
        vegetableLayout = findViewById(R.id.rlVegetableCont);
        animalLayout = findViewById(R.id.rlAnimalCont);
        fruitLayout = findViewById(R.id.rlFruitCont);
    }

    /**
     * setup ui elements
     * currently attach click listeners to buttons and layouts
     */
    private void setupUI() {
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
            case R.id.rlAlphabetCont:
                intent.putExtra(Const.SELECTED_SECTION, Const.ALPHABET);
                break;
            case R.id.rlVegetableCont:
                intent.putExtra(Const.SELECTED_SECTION, Const.VEGETABLE);
                break;
            case R.id.rlAnimalCont:
                intent.putExtra(Const.SELECTED_SECTION, Const.ANIMAL);
                break;
            case R.id.rlFamilyCont:
                intent.putExtra(Const.SELECTED_SECTION, Const.FAMILY);
                break;
            case R.id.rlFruitCont:
                intent.putExtra(Const.SELECTED_SECTION, Const.FRUIT);
                break;
        }
        startActivity(intent);
    }
}

