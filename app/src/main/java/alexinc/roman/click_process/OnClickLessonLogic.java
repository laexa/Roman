package alexinc.roman.click_process;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import alexinc.roman.data.DataBaseHelper;
import alexinc.roman.media.PlaySound;
import alexinc.roman.R;

public class OnClickLessonLogic implements View.OnClickListener {

    PlaySound playSound;
    Cursor cursor;
    DataBaseHelper dataBaseHelper;
    Context context;
    int section;
    TextView textViewWord;
    TextView textViewTranslateWord;
    ImageView imageView;
    int countCursor = 0;

    public OnClickLessonLogic(Context context, int section, TextView textViewWord, TextView textViewTranslateWord, ImageView imageView) {

        this.context = context;
        this.section = section;
        this.textViewWord = textViewWord;
        this.textViewTranslateWord = textViewTranslateWord;
        this.imageView = imageView;
    }


    @Override
    public void onClick(View v) {

        dataBaseHelper = new DataBaseHelper(context);
        playSound = new PlaySound(context);


        if (section == 1 ){

            // alphabet


        } else  if (section == 2){

            //family

            cursor = dataBaseHelper.getData(DataBaseHelper.TABLE_FAMILY);
            logicLearn(v);
        }
        else  if (section == 3){

            //vegetable

            cursor = dataBaseHelper.getData(DataBaseHelper.TABLE_VEGETABLE);
            logicLearn(v);


        }
        else  if (section == 4){

            //animal

            cursor = dataBaseHelper.getData(DataBaseHelper.TABLE_ANIMAL);
            logicLearn(v);

        }
        else  if (section == 5){

            //fruit

            cursor = dataBaseHelper.getData(DataBaseHelper.TABLE_FRUIT);
            logicLearn(v);

        }

        cursor.close();
    }

    public void logicLearn(View v){

        if (v.getId()  == R.id.button_left_layout_learn){

            if (countCursor == 0){
                cursor.moveToPosition(countCursor);
                textViewWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD)));
                textViewTranslateWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD_TRANSLATE)));
                imageView.setImageResource(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_IMAGE)));
                playSound.getSound(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_SOUND_TRANSLATE)));
            }else {
                countCursor-=1;
                cursor.moveToPosition(countCursor);
                textViewWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD)));
                textViewTranslateWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD_TRANSLATE)));
                imageView.setImageResource(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_IMAGE)));
                playSound.getSound(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_SOUND_TRANSLATE)));
            }


        }else if (v.getId()  == R.id.button_right_layout_learn){

            if (countCursor == cursor.getCount()-1){

                countCursor = 0;
                cursor.moveToPosition(countCursor);
                textViewWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD)));
                textViewTranslateWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD_TRANSLATE)));
                imageView.setImageResource(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_IMAGE)));
                playSound.getSound(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_SOUND_TRANSLATE)));

            } else if (countCursor < cursor.getCount()){

                countCursor += 1;
                cursor.moveToPosition(countCursor);
                textViewWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD)));
                textViewTranslateWord.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_WORD_TRANSLATE)));
                imageView.setImageResource(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_IMAGE)));
                playSound.getSound(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_SOUND_TRANSLATE)));

            }

        }else  if (v.getId()  == R.id.button_again_layout_learn){

            cursor.moveToPosition(countCursor);
            playSound.getSound(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.KEY_SOUND_TRANSLATE)));

        }

    }
}
