package com.example.sportlife;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Videos extends AppCompatActivity {

    private Button botonmp4,botonmp4_2,botonmp4_3,botonmp4_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        botonmp4 = (Button)findViewById(R.id.mp4);
        botonmp4_2 = (Button)findViewById(R.id.mp4_2);
        botonmp4_3 = (Button)findViewById(R.id.mp4_3);
        botonmp4_4 = (Button)findViewById(R.id.mp4_4);




        botonmp4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String LINK = "https://www.ebookfrenzy.com/android_book/movie.mp4";
                playVideo();

            }
        });


        botonmp4_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String LINK = "https://www.ebookfrenzy.com/android_book/movie.mp4";
                playVideo1();

            }
        });

        botonmp4_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String LINK = "https://www.ebookfrenzy.com/android_book/movie.mp4";
                playVideo2();

            }
        });

        botonmp4_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String LINK = "https://www.ebookfrenzy.com/android_book/movie.mp4";
                playVideo3();
            }
        });



    }


    private void playVideo() {
        VideoView videoView = (VideoView) findViewById(R.id.vv1);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        mc.setMediaPlayer(videoView);
        videoView.setMediaController(mc);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.chamber);
        videoView.requestFocus();
        videoView.start();
    }
    private void playVideo1() {
        VideoView videoView = (VideoView) findViewById(R.id.vv2);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        mc.setMediaPlayer(videoView);
        videoView.setMediaController(mc);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.chicote);
        videoView.requestFocus();
        videoView.start();
    }
    private void playVideo2() {
        VideoView videoView = (VideoView) findViewById(R.id.vv2);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        mc.setMediaPlayer(videoView);
        videoView.setMediaController(mc);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.chamber);
        videoView.requestFocus();
        videoView.start();
    }
    private void playVideo3() {
        VideoView videoView = (VideoView) findViewById(R.id.vv2);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        mc.setMediaPlayer(videoView);
        videoView.setMediaController(mc);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.chicote);
        videoView.requestFocus();
        videoView.start();
    }



}