package com.example.arsalankhan.youtubeplayerdemo;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class SingleVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
YouTubePlayerView youTubePlayerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_video);
        youTubePlayerview=findViewById(R.id.youtube_view);
        youTubePlayerview.initialize(YouTubeKey.YOUTUBE_KEY,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestore) {

        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        if(!wasRestore){
            youTubePlayer.loadVideo(YouTubeKey.YOUTUBE_SINGLE_VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else{
            Toast.makeText(this, "There is error in Initialization of Player: "+youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener=new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(SingleVideoActivity.this, "Video is Playing", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(SingleVideoActivity.this, "Video is pause", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopped() {
            Toast.makeText(SingleVideoActivity.this, "Video is stop", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBuffering(boolean b) {
            Toast.makeText(SingleVideoActivity.this, "Video is Buffering", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSeekTo(int i) {
            Toast.makeText(SingleVideoActivity.this, "Video is seek to: "+i, Toast.LENGTH_SHORT).show();
        }
    };


    //stateChange Listener

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener=new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {
            Toast.makeText(SingleVideoActivity.this, "Video is Loading", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLoaded(String s) {
            Toast.makeText(SingleVideoActivity.this, "Video is Loaded", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdStarted() {
            Toast.makeText(SingleVideoActivity.this, "Click on Ad", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(SingleVideoActivity.this, "Video is started", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(SingleVideoActivity.this, "Video is Ended", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            Toast.makeText(SingleVideoActivity.this, "An Error Occur: "+errorReason, Toast.LENGTH_SHORT).show();
        }
    };
}
