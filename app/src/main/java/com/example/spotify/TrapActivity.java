package com.example.spotify; // Tu paquete

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TrapActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // --- ARREGLADO 1: Apunta al layout correcto ---
        setContentView(R.layout.activity_trap);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Aquí va el resto del código de la aplicación
        Button btnPlay1 = findViewById(R.id.btn_play_1);
        Button btnPause1 = findViewById(R.id.btn_pause_1);
        Button btnStop1 = findViewById(R.id.btn_stop_1);

        Button btnPlay2 = findViewById(R.id.btn_play_2);
        Button btnPause2 = findViewById(R.id.btn_pause_2);
        Button btnStop2 = findViewById(R.id.btn_stop_2);

        Button btnBack = findViewById(R.id.btn_back);

        // --- Listeners Canción 1 ---
        btnPlay1.setOnClickListener(v -> playSong1());
        btnPause1.setOnClickListener(v -> pauseSong1());
        btnStop1.setOnClickListener(v -> stopSong1());

        // --- Listeners Canción 2 ---
        // (Esto ya lo tenías bien)
        btnPlay2.setOnClickListener(v -> playSong2());
        btnPause2.setOnClickListener(v -> pauseSong2());
        btnStop2.setOnClickListener(v -> stopSong2());

        // --- Listener Volver ---
        btnBack.setOnClickListener(v -> finish());
    }

    // --- Métodos de control Canción 1 ---
    private void playSong1() {
        if (mediaPlayer1 == null) {
            // --- ARREGLADO 2: Carga la canción de trap 1 ---
            mediaPlayer1 = MediaPlayer.create(this, R.raw.trap_song_1);
            mediaPlayer1.setOnCompletionListener(mp -> stopSong1());
        }
        mediaPlayer1.start();
    }

    private void pauseSong1() {
        if (mediaPlayer1 != null && mediaPlayer1.isPlaying()) {
            mediaPlayer1.pause();
        }
    }

    private void stopSong1() {
        if (mediaPlayer1 != null) {
            mediaPlayer1.stop();
            mediaPlayer1.release();
            mediaPlayer1 = null;
        }
    }

    // --- Métodos de control Canción 2 ---
    private void playSong2() {
        if (mediaPlayer2 == null) {
            // --- ARREGLADO 3: Carga la canción de trap 2 ---
            mediaPlayer2 = MediaPlayer.create(this, R.raw.trap_song_2);
            mediaPlayer2.setOnCompletionListener(mp -> stopSong2());
        }
        mediaPlayer2.start();
    }

    private void pauseSong2() {
        if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
            mediaPlayer2.pause();
        }
    }

    private void stopSong2() {
        if (mediaPlayer2 != null) {
            mediaPlayer2.stop();
            mediaPlayer2.release();
            mediaPlayer2 = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopSong1();
        stopSong2();
    }
}