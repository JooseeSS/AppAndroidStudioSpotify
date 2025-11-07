package com.example.spotify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_genre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Aquí va el resto del código de la aplicación
        TextView tvWelcome = findViewById(R.id.tv_welcome);
        Button btnReggaeton = findViewById(R.id.btn_reggaeton);
        Button btnTrap = findViewById(R.id.btn_trap);
        Button btnBack = findViewById(R.id.btn_back);

        // Recibir el nombre de la MainActivity
        String userName = getIntent().getStringExtra("USER_NAME");
        if (userName == null || userName.isEmpty()) {
            userName = "Usuario"; // Un valor por defecto
        }

        // Usar el string con formato
        tvWelcome.setText(getString(R.string.welcome_user, userName));

        // Listeners de los botones
        btnReggaeton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GenreActivity.this, ReggaetonActivity.class));
            }
        });

        btnTrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GenreActivity.this, TrapActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra esta actividad y vuelve a la anterior (MainActivity)
            }
        });
    }
}