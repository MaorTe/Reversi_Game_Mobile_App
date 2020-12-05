package com.example.rvesigame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ScoreTableAdapter extends BaseAdapter {
    private List<Score> scoreList;
    private Context context;

    public ScoreTableAdapter(List<Score> scores,Context context)
    {
        this.scoreList=scores;
        this.context=context;
    }
    @Override
    public int getCount() {
        return scoreList.size();
    }

    @Override
    public Object getItem(int position) {
        return scoreList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView ==null)
       {
           LayoutInflater layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView =layoutInflater.inflate(R.layout.tablescoreadapt,parent,false);
       }
       Score score =scoreList.get(position);
        TextView textViewPlayers = convertView.findViewById(R.id.players);
        textViewPlayers.setText(score.getPlayers());
        TextView textViewPlayerWin = convertView.findViewById(R.id.playerwin);
        textViewPlayerWin.setText(score.getPlayerwin());
        TextView textViewPlayerLose = convertView.findViewById(R.id.playerlose);
        textViewPlayerLose.setText(score.getPlayerlose());
        TextView textViewScore= convertView.findViewById(R.id.score);
        textViewScore.setText(score.getScore());
        return convertView;
    }
}
