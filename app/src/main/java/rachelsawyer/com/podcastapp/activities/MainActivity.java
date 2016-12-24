package rachelsawyer.com.podcastapp.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import rachelsawyer.com.podcastapp.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button playButton = (Button) findViewById(R.id.playButton);
        final Button rewindButton = (Button) findViewById(R.id.rewindButton);
        final Button fastForwardButton = (Button) findViewById(R.id.fastForwardButton);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        final MediaPlayer mPlayer = MediaPlayer.create(MainActivity.this, R.raw.song);

        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(mPlayer.isPlaying()){
                    playButton.setText("Pause");
                    mPlayer.pause();
                } else {
                    playButton.setText("Play");
                    mPlayer.start();
                }
            }
        });

        //Making the seekBar and the audio match up
        seekBar.setMax(mPlayer.getDuration());
        final Handler mHandler = new Handler();
        //Make sure you update Seekbar on UI thread
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int mCurrentPosition = mPlayer.getCurrentPosition();
                seekBar.setProgress(mCurrentPosition);
                mHandler.postDelayed(this, 1000);

                TextView progressTextView = (TextView)findViewById(R.id.progressTextView);
                progressTextView.setText(String.valueOf(mCurrentPosition));

                TextView remainingTextView = (TextView)findViewById(R.id.remainingTextView);
                remainingTextView.setText(String.valueOf(mPlayer.getDuration() - mCurrentPosition));
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //rewindButton
        rewindButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //How to rewind
                int currentPosition = mPlayer.getCurrentPosition();
                mPlayer.seekTo(currentPosition - 30000);

            }
        });

        //fastForwardButton
        fastForwardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //How to fast forward
                int currentPosition = mPlayer.getCurrentPosition();
                mPlayer.seekTo(currentPosition + 30000);

            }
        });
    }

    public String millisecondsToDisplayTime(int milliseconds) {
        return "0:00";
    }
}

//Show episode info, like episode number and who it is and whatnot
//Speed up and slow down the sound
//Keep the layout that I want when the phone switches between landscape and portait mode


//you should turn milliseconds into minutes and seconds for your labels
//you should make a separate function to do it for you, so you can use it twice (once for the remaining and once for the progress)
//public String millisecondsToDisplayTime(int milliseconds) {
// } and then you fill in the logic in the middle and return a string!

//    public String millisecondsToDisplayTime(int milliseconds) {
//  }