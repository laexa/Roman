package alexinc.roman.media;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.Random;

import alexinc.roman.R;

/**
 * Created by alex on 29.01.2018.
 */

public final class PlaySound {

    private MediaPlayer mediaPlayer;
    private final Context context;
    private final int idGoodSound_1 = R.raw.good_1;
    private final int idGoodSound_2 = R.raw.good_2;

    public PlaySound(final Context context) {
        this.context = context;
    }

    /**
     * метод який дозволяє відтворювати звук по "id" звука. Потрібний для бази даних в якій будуть записані "id"
     * цих звуків
     */
    public void playSoundById(int idSound) {
        mediaPlayer = MediaPlayer.create(context, idSound);
        mediaPlayer.start();
    }

    /**
     * Метод який випадково вибирає звук для відтворення. Потрібний для того щоб підвищувати самооцінку гравця.
     */
    public void playPraiseSound() {
        mediaPlayer = MediaPlayer.create(context, getPraiseSoundId());
        mediaPlayer.start();
    }

    private int getPraiseSoundId() {
        int rand = new Random().nextInt(10);

        if (rand < 5) return idGoodSound_1;
        else return idGoodSound_2;
    }

}

