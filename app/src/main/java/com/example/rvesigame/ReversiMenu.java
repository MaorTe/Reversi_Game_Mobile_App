package com.example.rvesigame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class ReversiMenu extends AppCompatActivity {

    Button btnuservsuser,btnrule,btnuservspc,btnTableScore;
    Animation move,move1,slide;
    AlertDialog dialog;
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reversimenu);

        btnuservsuser = findViewById(R.id.uservsuser);
        btnuservspc=findViewById(R.id.uservspc);
        btnrule=findViewById(R.id.rules);
        btnTableScore=findViewById(R.id.tabletropie);
        move= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        move1=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_right_to_left);
        slide=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        btnuservspc.startAnimation(move1);
        btnuservsuser.startAnimation(move);
        btnrule.startAnimation(move);
        btnTableScore.startAnimation(move1);

        btnTableScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),ScoreTable.class);
                startActivity(intent);
            }
        });



        btnuservsuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder =new AlertDialog.Builder(ReversiMenu.this);//build dialog

                final View dialogView = getLayoutInflater().inflate(R.layout.playernames ,null);//inflate the dialog
               final AlertDialog dialog=builder.create();
                final EditText user1=dialogView.findViewById(R.id.editname1);//gets the edit text from the xml file

                final EditText user2=dialogView.findViewById(R.id.editname2);//gets the edit text from the xml file
                Button btn =dialogView.findViewById(R.id.btnok);//gets the button from the xml file
                dialog.setView(dialogView);//show the dialog window
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(user1.getText().toString().isEmpty())
                        {
                            user1.setError(getResources().getString(R.string.must));
                        }
                        else if(user2.getText().toString().isEmpty())
                        {
                            user2.setError(getResources().getString(R.string.must));
                        }

                        else
                        {
                            dialog.dismiss();
                            Intent intent =new Intent(getApplicationContext(),ReversiGame.class);
                            intent.putExtra("name1",user1.getText().toString());
                            intent.putExtra("name2",user2.getText().toString());
                            startActivity(intent);
                        }

                    }
                });dialog.show();
            }
        });

        btnrule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder =new AlertDialog.Builder(ReversiMenu.this);
                final View dialogView =getLayoutInflater().inflate(R.layout.rule,null);
                builder.setView(dialogView);
                Button btn =dialogView.findViewById(R.id.btnok1);
                final  AlertDialog dialog =builder.create();
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        btnuservspc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] difficult = {"easy"};
                final AlertDialog.Builder builder=new AlertDialog.Builder(ReversiMenu.this);
                final  View dialogView=getLayoutInflater().inflate(R.layout.playervspc,null);
                final AlertDialog dialog=builder.create();
                dialog.setView(dialogView);
                final EditText editText=dialogView.findViewById(R.id.editname1);
                final RadioGroup radioGroup=dialogView.findViewById(R.id.radiogroup);
                final Button btn=dialogView.findViewById(R.id.btnok3);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch(checkedId)
                        {
                            case R.id.radio1: difficult[0] ="easy"; break;
                            case R.id.radio2: difficult[0] ="meduim"; break;
                            case R.id.radio3: difficult[0] ="hard"; break;
                        }
                    }
                });
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(editText.getText().toString().isEmpty())
                        {
                            editText.setError(getResources().getString(R.string.field));
                        }
                        else
                        {
                            dialog.dismiss();
                            Intent intent =new Intent(ReversiMenu.this,UservsComputer.class);
                            intent.putExtra("difficult",difficult[0]);
                            intent.putExtra("name",editText.getText().toString());
                            startActivity(intent);
                        }

                    }
                });dialog.show();
            }
        });
    }
}
