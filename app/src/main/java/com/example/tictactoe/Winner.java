package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Winner extends AppCompatActivity {
    Button back;
    TextView tvWin;
    ConstraintLayout winLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        back = findViewById(R.id.back);
        tvWin = findViewById(R.id.tvWin);
        winLayout = findViewById(R.id.winLayout);


        String winner = getIntent().getStringExtra("winner");
        if (MainActivity.isDark)
        {
            winLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryText));
            tvWin.setTextColor(getResources().getColor(R.color.colorAccent));
        }
        tvWin.setText(winner);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Winner.this, com.example.tictactoe.MainActivity.class);
                startActivity(intent);
                Winner.this.finish();
            }
        });
    }
}