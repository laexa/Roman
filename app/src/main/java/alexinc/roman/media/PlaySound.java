package alexinc.roman.media;


import android.content.Context;
import android.media.MediaPlayer;

import java.util.Random;

import alexinc.roman.R;

/**
 * Created by alex on 29.01.2018.
 */

public class PlaySound {

    private MediaPlayer mediaPlayer;
    private Context context;
    private int idGoodSound_1;
    private int idGoodSound_2;

    public PlaySound(Context context) {
        this.context = context;

    }

    /*
        метод який дозволяє відтворювати звук по "id" звука. Потрібний для бази даних в якій будуть записані "id"
        цих звуків
     */


    public void getSound(int idSound){

        mediaPlayer = MediaPlayer.create(context, idSound);
        mediaPlayer.start();
    }


    /*
        Метод який випадково вибирає звук для відтворення. Потрібний для того щоб підвищувати самооцінку гравця.
     */

    public void getRandomGoodSound(){



        idGoodSound_1 = R.raw.good_1;
        idGoodSound_2 = R.raw.good_2;

        int rand = new Random().nextInt(10);

        if (rand < 5){
            mediaPlayer = MediaPlayer.create(context, idGoodSound_1);
        }else {
            mediaPlayer = MediaPlayer.create(context, idGoodSound_2);
        }

        mediaPlayer.start();

    }


}

