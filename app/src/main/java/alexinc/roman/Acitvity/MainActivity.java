package alexinc.roman.Acitvity;

import android.content.Intent;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import alexinc.roman.DataBase.DataBaseHelper;
import alexinc.roman.R;
import alexinc.roman.SavePreferences.Preferences;

public class MainActivity extends AppCompatActivity  implements  View.OnClickListener {

    Button  familyButtonMenu;
    Button  alphabetButtonMenu;
    Button  vegetableButtonMenu;
    Button  animalButtonMenu;
    Button  fruitButtonMenu;


    RelativeLayout alphabetLayout;
    RelativeLayout familyLayout;
    RelativeLayout vegetableLayout;
    RelativeLayout animalLayout;
    RelativeLayout fruitLayout;


    private final int ALPHABET = 1;
    private final int FAMILY = 2;
    private final int VEGETABLE = 3;
    private final int ANIMAL = 4;
    private final int FRUIT = 5;

    MenuViewChoise menuViewChoise;

    String TAG = "mainClass";
    Preferences preferences = new Preferences(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_main);

//        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
//        dataBaseHelper.getAllData(DataBaseHelper.TABLE_ANIMAL);
//        dataBaseHelper.getAllData(DataBaseHelper.TABLE_FAMILY);
//        dataBaseHelper.getAllData(DataBaseHelper.TABLE_VEGETABLE);
//        dataBaseHelper.getAllData(DataBaseHelper.TABLE_FRUIT);


//        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);


        // TODO: 29.03.2018 всі лайаути настрояні і адаптивні база даних готова , всталося її лише заповнити

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


//        new DataBaseHelper(this).getAllData(DataBaseHelper.TABLE_FAMILY);
//        new DataBaseHelper(this).getAllData(DataBaseHelper.TABLE_ANIMAL);
//        new DataBaseHelper(this).getAllData();


        alphabetButtonMenu.setOnClickListener(this);
        vegetableButtonMenu.setOnClickListener(this);
        animalButtonMenu.setOnClickListener(this);
        fruitButtonMenu.setOnClickListener(this);
        familyButtonMenu.setOnClickListener(this);

        // TODO: 28.03.2018  тута роботает всьо окей / всталося придумати логику // исползувати можна
//        preferences.saveScore("100");
//        Log.i(TAG, "onCreate: "+preferences.loadScore());

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.alphabetButtonMenu){

            Intent intent = new Intent(this, MenuViewChoise.class);

            intent.putExtra("section", ALPHABET);
            startActivity(intent);

        }else if (v.getId() == R.id.vegetableButtonMenu){


            Intent intent = new Intent(this, MenuViewChoise.class);

            intent.putExtra("section", VEGETABLE);
            startActivity(intent);

        }else if (v.getId() == R.id.animalButtonMenu){


            Intent intent = new Intent(this, MenuViewChoise.class);

            intent.putExtra("section", ANIMAL);
            startActivity(intent);

        }else if (v.getId() == R.id.familyButtonMenu ){


            Intent intent = new Intent(this, MenuViewChoise.class);

            intent.putExtra("section", FAMILY);
            startActivity(intent);


        }else if (v.getId() == R.id.fruitButtonMenu) {


            Intent intent = new Intent(this, MenuViewChoise.class);

            intent.putExtra("section", FRUIT);
            startActivity(intent);
        }
    }
}

