package com.example.spotify; // Tu paquete

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReggaetonActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // --- ARREGLADO 1: Carga el layout de Reggaeton ---
        setContentView(R.layout.activity_reggaeton);

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
        btnPlay2.setOnClickListener(v -> playSong2());
        btnPause2.setOnClickListener(v -> pauseSong2());
        btnStop2.setOnClickListener(v -> stopSong2());

        // --- Listener Volver ---
        btnBack.setOnClickListener(v -> finish());
    }

    // --- Métodos de control Canción 1 ---
    private void playSong1() {
        if (mediaPlayer1 == null) {
            // --- ARREGLADO 2: Carga la canción de reggaeton 1 ---
            mediaPlayer1 = MediaPlayer.create(this, R.raw.reggaeton_song_1);
            mediaPlayer1.setOnCompletionListener(mp -> stopSong1()); // Limpia al terminar
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
            // --- ARREGLADO 3: Carga la canción de reggaeton 2 ---
            mediaPlayer2 = MediaPlayer.create(this, R.raw.reggaeton_song_2);
            mediaPlayer2.setOnCompletionListener(mp -> stopSong2()); // Limpia al terminar
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

    // Limpia los reproductores al destruir la actividad (MUY IMPORTANTE)
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopSong1();
        stopSong2();
    }
}