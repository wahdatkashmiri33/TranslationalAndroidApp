package com.emzah.kasher.zabaan;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;


    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT  ||
                            focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        //pause playback

                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);

                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {

                        mediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }

                }
            };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
       final ArrayList<word> words=new ArrayList<word>();
        words.add(new word("one","akh",R.drawable.one,R.raw.one));
        words.add(new word("two","za",R.drawable.two,R.raw.two));
        words.add(new word("three","tria",R.drawable.three,R.raw.three));
        words.add(new word("four","chour",R.drawable.four,R.raw.four));
        words.add(new word("five","panch",R.drawable.five,R.raw.five));
        words.add(new word("six","shiah",R.drawable.six,R.raw.six));
        words.add(new word("seven","saath",R.drawable.seven,R.raw.seven));
        words.add(new word("eight","aeeth",R.drawable.eight,R.raw.eight));
        words.add(new word("nine","nav",R.drawable.nine,R.raw.nine));
        words.add(new word("ten","dah",R.drawable.ten,R.raw.ten));
        words.add(new word("eleven","kah",R.drawable.eleven,R.raw.eleven));
        words.add(new word("twelve","bah",R.drawable.twelve,R.raw.twelve));
        words.add(new word("thirteen","truva",R.drawable.thirteen,R.raw.thirteen));
        words.add(new word("fourteen","chouda",R.drawable.fourteen,R.raw.fourteen));
        words.add(new word("fifteen","pandah",R.drawable.fifteen,R.raw.fifteen));
        words.add(new word("sixteen","shurah",R.drawable.sixteen,R.raw.sixteen));
        words.add(new word("seventeen","sadah",R.drawable.seventeen,R.raw.seventeen));
        words.add(new word("eighteen","ardah",R.drawable.eighteen,R.raw.eighteen));
        words.add(new word("nineteen","kunwuh",R.drawable.nineteen,R.raw.nineteen));
        words.add(new word("twenty","wuh",R.drawable.twenty,R.raw.twenty));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

        ListView listView=(ListView)findViewById(R.id.lists);

        listView.setAdapter(adapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        word mword = words.get(position);
        releaseMediaPlayer();
        // Request audio focus for playback
        int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                // Use the music stream.
                AudioManager.STREAM_MUSIC,
                // Request permanent focus.
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            // We hav audio focus now


            mediaPlayer = MediaPlayer.create(NumbersActivity.this, mword.getmAudioResourceId());
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(mCompletionListener);
        }
    }
});
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }
}
