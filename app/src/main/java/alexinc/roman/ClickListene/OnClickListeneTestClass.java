package alexinc.roman.ClickListene;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import alexinc.roman.DataBase.DataBaseHelper;
import alexinc.roman.PlaySound.PlaySound;
import alexinc.roman.R;

public class OnClickListeneTestClass  implements View.OnClickListener{

    ImageView imageViewTrue;
    ImageView imageViewFalse_1;
    ImageView imageViewFalse_2;
    ImageView imageViewFalse_3;
    TextView textView;
    Context context;
    PlaySound playSound;
    DataBaseHelper dataBaseHelper;

    public OnClickListeneTestClass(ImageView imageViewTrue, ImageView imageViewFalse_1, ImageView imageViewFalse_2, ImageView imageViewFalse_3, TextView textView, Context context) {

        this.imageViewTrue = imageViewTrue;
        this.imageViewFalse_1 = imageViewFalse_1;
        this.imageViewFalse_2 = imageViewFalse_2;
        this.imageViewFalse_3 = imageViewFalse_3;
        this.textView = textView;
        this.context = context;
    }


    @Override
    public void onClick(View v) {

        playSound = new PlaySound(context);
        dataBaseHelper = new DataBaseHelper(context);

        if (v.getId() == R.id.imageViewTest_1){
            textView.setText("23323");
        }


    }

}
