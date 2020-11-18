package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    TextView tvPlayer1Name, tvPlayer2Name, tvX, tvO;
    Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22, btnBack;
    ImageView undo;
    String player1, player2;
    ConstraintLayout outerlayout;
    int[][] gameArray = new int[3][3];
    int turn = 0,i, j;

    int won()
    {
        int player = 0;
        //rows
        if (gameArray[0][0] + gameArray[0][1] + gameArray[0][2] == -3)
            player = 1;
        if (gameArray[0][0] + gameArray[0][1] + gameArray[0][2] == 3)
            player = 2;
        if (gameArray[1][0] + gameArray[1][1] + gameArray[1][2] == -3)
            player = 1;
        if (gameArray[1][0] + gameArray[1][1] + gameArray[1][2] == 3)
            player = 2;
        if (gameArray[2][0] + gameArray[2][1] + gameArray[2][2] == -3)
            player = 1;
        if (gameArray[2][0] + gameArray[2][1] + gameArray[2][2] == 3)
            player = 2;
        //columns
        if (gameArray[0][1] + gameArray[1][1] + gameArray[2][1] == -3)
            player = 1;
        if (gameArray[0][1] + gameArray[1][1] + gameArray[2][1] == 3)
            player = 2;
        if (gameArray[0][0] + gameArray[1][0] + gameArray[2][0] == -3)
            player = 1;
        if (gameArray[0][0] + gameArray[1][0] + gameArray[2][0] == 3)
            player = 2;
        if (gameArray[0][2] + gameArray[1][2] + gameArray[2][2] == -3)
            player = 1;
        if (gameArray[0][2] + gameArray[1][2] + gameArray[2][2] == 3)
            player = 2;
        //Diagonals
        if (gameArray[0][0] + gameArray[1][1] + gameArray[2][2] == -3)
            player = 1;
        if (gameArray[0][0] + gameArray[1][1] + gameArray[2][2] == 3)
            player = 2;
        if (gameArray[0][2] + gameArray[1][1] + gameArray[2][0] == -3)
            player = 1;
        if (gameArray[0][2] + gameArray[1][1] + gameArray[2][0] == 3)
            player = 2;

        return player;
    }

    void updateButton(Button B,int i, int j)
    {
        System.out.println("In update");
        if(B.getText().toString().trim().equals("X") || B.getText().toString().trim().equals("O"))
        {
            Toast.makeText(Game.this, "Invalid", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(turn%2 == 0)
            {
                B.setText("X".trim());
                gameArray[i][j] = -1;
            }
            if(turn%2 == 1)
            {
                B.setText("O".trim());
                gameArray[i][j] = 1;
            }
            int player = won();
            if(player == 1)
            {
                Intent intent = new Intent(Game.this, com.example.tictactoe.Winner.class);
                intent.putExtra("winner", player1 + " Wins!");
                startActivity(intent);
            }
            if(player == 2)
            {
                Intent intent = new Intent(Game.this, com.example.tictactoe.Winner.class);
                intent.putExtra("winner", player2 + " Wins!");
                startActivity(intent);
            }
            turn += 1;
            if(turn==9 && player == 0)
            {
                Intent intent = new Intent(Game.this, com.example.tictactoe.Winner.class);
                intent.putExtra("winner", "Draw !");
                startActivity(intent);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        turn = 0;

        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                gameArray[i][j] = 0;
            }
        }

        tvPlayer1Name = findViewById(R.id.tvPlayer1Name);
        tvPlayer2Name = findViewById(R.id.tvPlayer2Name);

        player1 = getIntent().getStringExtra("player1");
        player2 = getIntent().getStringExtra("player2");
        tvPlayer1Name.setText(player1);
        tvPlayer2Name.setText(player2);
        //Game buttons
        btn00 = findViewById(R.id.btn00);
        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn20 = findViewById(R.id.btn20);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);

        //back button
        btnBack = findViewById(R.id.btnBack);
        outerlayout = findViewById(R.id.outerlayout);

        tvX = findViewById(R.id.tvX);
        tvO = findViewById(R.id.tvO);
        //check for dark theme application
        if (MainActivity.isDark)
        {
            tvPlayer1Name.setTextColor(getResources().getColor(R.color.colorAccent));
            tvPlayer2Name.setTextColor(getResources().getColor(R.color.colorAccent));
            tvPlayer1Name.setBackgroundColor(getResources().getColor(R.color.colorPrimaryText));
            tvPlayer2Name.setBackgroundColor(getResources().getColor(R.color.colorPrimaryText));
            tvX.setTextColor(getResources().getColor(R.color.colorAccent));
            tvO.setTextColor(getResources().getColor(R.color.colorAccent));
            tvX.setBackgroundColor(getResources().getColor(R.color.colorPrimaryText));
            tvO.setBackgroundColor(getResources().getColor(R.color.colorPrimaryText));
            outerlayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryText));
        }

        //set button clicks
        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButton(btn00, 0, 0);
            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButton(btn01, 0, 1);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButton(btn02, 0, 2);
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButton(btn20, 2, 0);
            }
        });

        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButton(btn21, 2, 1);
            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButton(btn22, 2, 2);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButton(btn10, 1, 0);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButton(btn11, 1, 1);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButton(btn12, 1, 2);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game.this, com.example.tictactoe.MainActivity.class);
                intent.putExtra("isDark", MainActivity.isDark);
                startActivity(intent);
                Game.this.finish();
            }
        });

    }
}