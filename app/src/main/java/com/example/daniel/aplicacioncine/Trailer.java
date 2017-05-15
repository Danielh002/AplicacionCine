package com.example.daniel.aplicacioncine;

import android.app.ProgressDialog;
import android.content.Intent;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.OrientationEventListener;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Trailer extends YouTubeBaseActivity{
    private OrientationEventListener orientationEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        Intent myIntent = getIntent();
        final String uri = myIntent.getStringExtra("URL");
        Bundle bundle = myIntent.getExtras();
        bundle.getString(uri);

        YouTubePlayerView youTubePlayerView =
                (YouTubePlayerView) findViewById(R.id.youtube_player_view);

        youTubePlayerView.initialize("AIzaSyAhQYXavpMpK_HzpPTBS5xqJ64MfqzsxNE",
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc :y-1PV-I_Sv0.
                        // uisBaTkQAEs
                        youTubePlayer.loadVideo(uri);
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });

        orientationEventListener = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL) {

            @Override
            public void onOrientationChanged(int orientation) {

                // ....

            }
        };

        if (orientationEventListener.canDetectOrientation()) {
            orientationEventListener.enable();
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        orientationEventListener.disable();
    }
}
