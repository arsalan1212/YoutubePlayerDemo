package com.example.arsalankhan.youtubeplayerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class MainActivity extends AppCompatActivity {
Intent intent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SingleVideo(View view){
/*
        Intent intent=new Intent(this,SingleVideoActivity.class);
        startActivity(intent);*/
      // intent= YouTubeStandalonePlayer.createVideoIntent(this,YouTubeKey.YOUTUBE_KEY,YouTubeKey.YOUTUBE_SINGLE_VIDEO_ID);
        intent= YouTubeStandalonePlayer.createVideoIntent(this,YouTubeKey.YOUTUBE_KEY,YouTubeKey.YOUTUBE_SINGLE_VIDEO_ID,0,true,false);
        startActivity(intent);
    }

    public void GoToPlaylist(View view){

//        intent=YouTubeStandalonePlayer.createPlaylistIntent(this,YouTubeKey.YOUTUBE_KEY,YouTubeKey.YOUTUBE_PLAYLIST_ID);
        intent=YouTubeStandalonePlayer.createPlaylistIntent(this,YouTubeKey.YOUTUBE_KEY,YouTubeKey.YOUTUBE_PLAYLIST_ID,0,0,true,false);
        startActivity(intent);
    }
}
