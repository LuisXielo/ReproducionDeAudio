package com.example.reproduciondeaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play;
    SoundPool sp;

    int sonido_de_reproducion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calse soundpool
        play = (Button) findViewById(R.id.btn_play);
        // sp = new SoundPool( "lo primero es el numero de pistas" en este caso 1, que reproductor,
        // y por ultimo la calidad 1 )
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        //donde primero "this", donde esta de segundo y prioridad 1.
        sonido_de_reproducion = sp.load(this, R.raw.sound_short, 1);
    }

    public void AudioSoundPool (View view){
        // primero sonido, segunda volumen altavoces, prieridad, loop si se va a repetir y ultimo el rate (canal).
        sp.play(sonido_de_reproducion, 1,1,1, 0, 1);
    }

    //metodo mediaplayer
    public void AudioMediaPlayer(View view){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sound_long);
        mp.start();
    }
}