package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PlayerNames extends AppCompatActivity {

    EditText etPlayer1, etPlayer2;
    Button btnStartGame;
    ConstraintLayout layoutNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names);

        etPlayer1 = findViewById(R.id.etPlayer1);
        etPlayer2 = findViewById(R.id.etPlayer2);
        btnStartGame = findViewById(R.id.btnStartGame);
        layoutNames = findViewById(R.id.layoutNames);
        etPlayer2.setText("");
        etPlayer1.setText("");

        if(MainActivity.isDark)
        {
            layoutNames.setBackgroundColor(getResources().getColor(R.color.colorPrimaryText));
            etPlayer1.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
            etPlayer2.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
        }

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etPlayer1.getText().toString().isEmpty() && etPlayer2.getText().toString().isEmpty())
                {
                    Toast.makeText(PlayerNames.this, "Please Enter all fields !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Jump to game activity
                    Intent intent = new Intent(PlayerNames.this, com.example.tictactoe.Game.class);
                    intent.putExtra("player1", etPlayer1.getText().toString().trim());
                    intent.putExtra("player2", etPlayer2.getText().toString().trim());
                    intent.putExtra("isDark", MainActivity.isDark);
                    startActivity(intent);
                    PlayerNames.this.finish();
                }
            }
        });
    }
}