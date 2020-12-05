package com.example.rvesigame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreTable extends AppCompatActivity {
    ListView listView;
    Button btn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static ArrayList<Score> scores = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablescore);
        listView=findViewById(R.id.list_score);
        btn=findViewById(R.id.back);
        if(getIntent().getStringExtra("finish") != null &&getIntent().getStringExtra("finish").equals("true")) {
            SharedPreferences sp = getSharedPreferences("score details", MODE_PRIVATE);
            String players = getIntent().getStringExtra("players");
            String win = getIntent().getStringExtra("win");
            String lose = getIntent().getStringExtra("lose");
            String score = getIntent().getStringExtra("score");
            scores.add(new Score(players, win, lose, score));
            ScoreTableAdapter scoreTableAdapter = new ScoreTableAdapter(scores, this);
            listView.setAdapter(scoreTableAdapter);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),ReversiMenu.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences = getSharedPreferences("save table", MODE_PRIVATE);
        String[] gameplay = sharedPreferences.getString("score", "").split("!");
        ArrayList<Score> scores1 = new ArrayList<>();
        if (!gameplay[0].equals("")) {
            for (int i = 0; i < gameplay.length; i++) {
                String[] strings = gameplay[i].split(",");
                scores1.add(new Score(strings[0], strings[1], strings[2], strings[3]));
            }
            ScoreTableAdapter scoreTableAdapter = new ScoreTableAdapter(scores1, this);
            listView.setAdapter(scoreTableAdapter);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences =getSharedPreferences("save table",MODE_PRIVATE);
        editor =sharedPreferences.edit();
        StringBuilder games=new StringBuilder();
        for(int i = 0 ; i < scores.size(); i++)
        {
            games.append(scores.get(i).getPlayers()).append(",");
            games.append(scores.get(i).getPlayerwin()).append(",");
            games.append(scores.get(i).getPlayerlose()).append(",");
            games.append(scores.get(i).getScore()).append("!");
        }
        editor.putString("score", games.toString());
        editor.commit();

    }
}
