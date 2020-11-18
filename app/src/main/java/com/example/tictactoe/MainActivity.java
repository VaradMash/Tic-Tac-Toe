package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvName;
    Button btnNewGame, btnExit;
    Switch darkTheme;
    ConstraintLayout activityLayout;
    public static boolean isDark = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tvAppName);
        btnNewGame = findViewById(R.id.btnNewGame);
        btnExit = findViewById(R.id.btnExit);
        darkTheme = findViewById(R.id.darkTheme);
        darkTheme.setChecked(false);
        activityLayout = findViewById(R.id.activityLayout);
        //Jump to new activity. No result expected
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.tictactoe.PlayerNames.class);
                startActivity(intent);
            }
        });
        //Exit the application
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
        darkTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Switched to Dark Theme!", Toast.LENGTH_SHORT).show();
                    activityLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryText));
                    darkTheme.setText("Switch to Light Theme");
                    tvName.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
                    darkTheme.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
                    isDark = true;

                } else {
                    activityLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    tvName.setTextColor(getResources().getColor(R.color.colorPrimaryText));
                    darkTheme.setText("Switch to Dark Theme");
                    darkTheme.setTextColor(getResources().getColor(R.color.colorPrimaryText));
                    Toast.makeText(MainActivity.this, "Switched to Light Theme!", Toast.LENGTH_SHORT).show();
                    isDark = false;
                }
            }
        });

        if (MainActivity.isDark) {
            activityLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryText));
            tvName.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
            darkTheme.setTextColor(getResources().getColor(R.color.colorPrimaryLight));
            darkTheme.setChecked(true);
            darkTheme.setText("Switch to Light Theme");
        }
    }
}