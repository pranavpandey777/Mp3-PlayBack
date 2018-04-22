package com.example.pranav.ptanhikya;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private MediaPlayer mediaPlayer;
   // private MediaController mediaController;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mediaController=new MediaController(this);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.god);
              //  mediaPlayer.setMediaController(mediaController);
               // mediaController.setAnchorView(mediaController);

                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this, "PlayBack", Toast.LENGTH_SHORT).show();
                    btn.setEnabled(false);

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {

                        mediaPlayer.release();
                        mediaPlayer =null;
                        Toast.makeText(MainActivity.this, "PlayBack finish", Toast.LENGTH_SHORT).show();
                        btn.setEnabled(true);
                    }
                });


            }
        });
    }
}
