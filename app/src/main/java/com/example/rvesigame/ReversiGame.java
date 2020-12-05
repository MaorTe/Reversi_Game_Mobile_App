package com.example.rvesigame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageButton;

public class ReversiGame extends AppCompatActivity  implements View.OnClickListener{
    Button[][] buttons = new Button[8][8];
    Animation animation;
    String win,lose;
    int tor = 0;
    String stringname1,stringname2,name1,name2;
    TextView textView1,textView2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.text_play1);
        textView2=findViewById(R.id.text_play2);
        name1=getIntent().getStringExtra("name1");
        name2=getIntent().getStringExtra("name2");
        stringname1=textView1.getText().toString()+getIntent().getStringExtra("name1");
        stringname2=textView2.getText().toString()+getIntent().getStringExtra("name2");
        textView1.setText( " " + stringname1 +" " +"2" );
        textView2.setText( " " + stringname2 +" "+ "2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        getButtomid();
        putTag();
        Setonbutton();
        Drawable Drawableblack = getResources().getDrawable(R.drawable.black1);
        Drawable Drawablewhite = getResources().getDrawable(R.drawable.white);
        PlaceToEatOpponent(Drawableblack, Drawablewhite);
    }

    public void putTag() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setTag("green");
            }
        }
    }

    public void getButtomid() {
        buttons[0][0] = findViewById(R.id.btn1);
        buttons[0][1] = findViewById(R.id.btn2);
        buttons[0][2] = findViewById(R.id.btn3);
        buttons[0][3] = findViewById(R.id.btn4);
        buttons[0][4] = findViewById(R.id.btn5);
        buttons[0][5] = findViewById(R.id.btn6);
        buttons[0][6] = findViewById(R.id.btn7);
        buttons[0][7] = findViewById(R.id.btn8);
        buttons[1][0] = findViewById(R.id.btn9);
        buttons[1][1] = findViewById(R.id.btn10);
        buttons[1][2] = findViewById(R.id.btn11);
        buttons[1][3] = findViewById(R.id.btn12);
        buttons[1][4] = findViewById(R.id.btn13);
        buttons[1][5] = findViewById(R.id.btn14);
        buttons[1][6] = findViewById(R.id.btn15);
        buttons[1][7] = findViewById(R.id.btn16);
        buttons[2][0] = findViewById(R.id.btn17);
        buttons[2][1] = findViewById(R.id.btn18);
        buttons[2][2] = findViewById(R.id.btn19);
        buttons[2][3] = findViewById(R.id.btn20);
        buttons[2][4] = findViewById(R.id.btn21);
        buttons[2][5] = findViewById(R.id.btn22);
        buttons[2][6] = findViewById(R.id.btn23);
        buttons[2][7] = findViewById(R.id.btn24);
        buttons[3][0] = findViewById(R.id.btn25);
        buttons[3][1] = findViewById(R.id.btn26);
        buttons[3][2] = findViewById(R.id.btn27);
        buttons[3][3] = findViewById(R.id.btn28);
        buttons[3][4] = findViewById(R.id.btn29);
        buttons[3][5] = findViewById(R.id.btn30);
        buttons[3][6] = findViewById(R.id.btn31);
        buttons[3][7] = findViewById(R.id.btn32);
        buttons[4][0] = findViewById(R.id.btn33);
        buttons[4][1] = findViewById(R.id.btn34);
        buttons[4][2] = findViewById(R.id.btn35);
        buttons[4][3] = findViewById(R.id.btn36);
        buttons[4][4] = findViewById(R.id.btn37);
        buttons[4][5] = findViewById(R.id.btn38);
        buttons[4][6] = findViewById(R.id.btn39);
        buttons[4][7] = findViewById(R.id.btn40);
        buttons[5][0] = findViewById(R.id.btn41);
        buttons[5][1] = findViewById(R.id.btn42);
        buttons[5][2] = findViewById(R.id.btn43);
        buttons[5][3] = findViewById(R.id.btn44);
        buttons[5][4] = findViewById(R.id.btn45);
        buttons[5][5] = findViewById(R.id.btn46);
        buttons[5][6] = findViewById(R.id.btn47);
        buttons[5][7] = findViewById(R.id.btn48);
        buttons[6][0] = findViewById(R.id.btn49);
        buttons[6][1] = findViewById(R.id.btn50);
        buttons[6][2] = findViewById(R.id.btn51);
        buttons[6][3] = findViewById(R.id.btn52);
        buttons[6][4] = findViewById(R.id.btn53);
        buttons[6][5] = findViewById(R.id.btn54);
        buttons[6][6] = findViewById(R.id.btn55);
        buttons[6][7] = findViewById(R.id.btn56);
        buttons[7][0] = findViewById(R.id.btn57);
        buttons[7][1] = findViewById(R.id.btn58);
        buttons[7][2] = findViewById(R.id.btn59);
        buttons[7][3] = findViewById(R.id.btn60);
        buttons[7][4] = findViewById(R.id.btn61);
        buttons[7][5] = findViewById(R.id.btn62);
        buttons[7][6] = findViewById(R.id.btn63);
        buttons[7][7] = findViewById(R.id.btn64);
    }

    public Boolean PlaceToEatOpponent(Drawable i_drawableEat, Drawable i_mustEat) {
        final int limitdown = -1;
        final int limitTop = 8;
        int bordRow, bordCol;
        List<Button> buttons1 = new LinkedList<Button>();
        Drawable drawable1;
        Boolean havetor=false;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                drawable1 = buttons[i][j].getCompoundDrawables()[0];
                if (drawable1 == null)
                    continue;
                if (drawable1.getConstantState().equals(i_drawableEat.getConstantState()))//i have the sigan
                {
                    if (i - 1 > limitdown && buttons[i - 1][j].getCompoundDrawables()[0] != null) {
                        bordRow = i - 1;
                        bordCol = j;
                        while (bordRow > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] != null && buttons[bordRow][bordCol].getCompoundDrawables()[0].getConstantState().equals(i_mustEat.getConstantState())) {
                            bordRow--;
                        }
                        if (bordRow > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] == null) {
                            buttons[bordRow][bordCol].setBackgroundResource(R.drawable.shapeyellow);
                            buttons[bordRow][bordCol].setTag("yellow");
                            havetor=true;
                        }
                    }

                    if (i - 1 > limitdown && j - 1 > limitdown && buttons[i - 1][j - 1].getCompoundDrawables()[0] != null) {
                        bordRow = i - 1;
                        bordCol = j - 1;
                        while (bordRow > limitdown && bordCol > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] != null && buttons[bordRow][bordCol].getCompoundDrawables()[0].getConstantState().equals(i_mustEat.getConstantState())) {
                            bordRow--;
                            bordCol--;
                        }
                        if (bordRow > limitdown && bordCol > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] == null) {
                            buttons[bordRow][bordCol].setBackgroundResource(R.drawable.shapeyellow);
                            buttons[bordRow][bordCol].setTag("yellow");
                            havetor=true;
                        }
                    }

                    if (i - 1 > limitdown && j + 1 < limitTop && buttons[i - 1][j + 1].getCompoundDrawables()[0] != null) {
                        bordRow = i - 1;
                        bordCol = j + 1;

                        while (bordRow > limitdown && bordCol < limitTop && buttons[bordRow][bordCol].getCompoundDrawables()[0] != null && buttons[bordRow][bordCol].getCompoundDrawables()[0].getConstantState().equals(i_mustEat.getConstantState())) {
                            bordRow--;
                            bordCol++;
                        }
                        if (bordRow > limitdown && bordCol < limitTop && buttons[bordRow][bordCol].getCompoundDrawables()[0] == null) {
                            buttons[bordRow][bordCol].setBackgroundResource(R.drawable.shapeyellow);
                            buttons[bordRow][bordCol].setTag("yellow");
                            havetor=true;
                        }
                    }

                    if (j + 1 < limitTop && buttons[i][j + 1].getCompoundDrawables()[0] != null) {
                        bordRow = i;
                        bordCol = j + 1;
                        while (bordCol < limitTop && buttons[bordRow][bordCol].getCompoundDrawables()[0] != null && buttons[bordRow][bordCol].getCompoundDrawables()[0].getConstantState().equals(i_mustEat.getConstantState())) {
                            bordCol++;
                        }
                        if (bordCol < limitTop && buttons[bordRow][bordCol].getCompoundDrawables()[0] == null) {
                            buttons[bordRow][bordCol].setBackgroundResource(R.drawable.shapeyellow);
                            buttons[bordRow][bordCol].setTag("yellow");
                            havetor=true;
                        }
                    }

                    if (j - 1 > limitdown && buttons[i][j - 1].getCompoundDrawables()[0] != null /*buttons[i-1][j].getCompoundDrawables()[0].equals(i_mustEat.getConstantState()*/) {
                        bordRow = i;
                        bordCol = j - 1;
                        while (bordCol > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] != null && buttons[bordRow][bordCol].getCompoundDrawables()[0].getConstantState().equals(i_mustEat.getConstantState())) {
                            bordCol--;
                        }
                        if (bordCol > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] == null) {
                            buttons[bordRow][bordCol].setBackgroundResource(R.drawable.shapeyellow);
                            buttons[bordRow][bordCol].setTag("yellow");
                            havetor=true;
                        }
                    }

                    if (i + 1 < limitTop && buttons[i + 1][j].getCompoundDrawables()[0] != null) {
                        bordRow = i + 1;
                        bordCol = j;
                        while (bordRow < limitTop && buttons[bordRow][bordCol].getCompoundDrawables()[0] != null && buttons[bordRow][bordCol].getCompoundDrawables()[0].getConstantState().equals(i_mustEat.getConstantState())) {
                            bordRow++;
                        }
                        if (bordRow < limitTop && buttons[bordRow][bordCol].getCompoundDrawables()[0] == null) {
                            buttons[bordRow][bordCol].setBackgroundResource(R.drawable.shapeyellow);
                            buttons[bordRow][bordCol].setTag("yellow");
                            havetor=true;
                        }

                    }

                    if (i + 1 < limitTop && j + 1 < limitTop && buttons[i + 1][j + 1].getCompoundDrawables()[0] != null) {
                        bordRow = i + 1;
                        bordCol = j + 1;
                        while (bordRow < limitTop && bordCol < limitTop && buttons[bordRow][bordCol].getCompoundDrawables()[0] != null && buttons[bordRow][bordCol].getCompoundDrawables()[0].getConstantState().equals(i_mustEat.getConstantState())) {
                            bordRow++;
                            bordCol++;
                        }
                        if (bordRow < limitTop && bordCol < limitTop && buttons[bordRow][bordCol].getCompoundDrawables()[0] == null) {
                            buttons[bordRow][bordCol].setBackgroundResource(R.drawable.shapeyellow);
                            buttons[bordRow][bordCol].setTag("yellow");
                            havetor=true;
                        }
                    }
                    if (i + 1 < limitTop && j - 1 > limitdown && buttons[i + 1][j - 1].getCompoundDrawables()[0] != null) {
                        bordRow = i + 1;
                        bordCol = j - 1;

                        while (bordRow < limitTop && bordCol > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] != null && buttons[bordRow][bordCol].getCompoundDrawables()[0].getConstantState().equals(i_mustEat.getConstantState())) {
                            bordRow++;
                            bordCol--;
                        }
                        if (bordRow < limitTop && bordCol > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] == null) {
                            buttons[bordRow][bordCol].setBackgroundResource(R.drawable.shapeyellow);
                            buttons[bordRow][bordCol].setTag("yellow");
                            havetor=true;
                        }
                    }
                }
            }
        }
        return havetor;
    }

    public void Setonbutton() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setOnClickListener(this);
            }
        }
    }


    public void EatSoldgier(Drawable i_put_sigan, int row, int col, Drawable i_eat_sigan) {

        final int limitdown = -1;
        final int limitTop = 8;
        int bordrow, bordcol;
        ArrayList<String>n_place=new ArrayList<>();
        if(i_put_sigan.getConstantState().equals(getResources().getDrawable(R.drawable.black1).getConstantState()))
        {
            n_place.add("black");
        }
        else if(i_put_sigan.getConstantState().equals(getResources().getDrawable(R.drawable.white).getConstantState()))
        {
            n_place.add("white");
        }
        if (row - 1 > limitdown && buttons[row - 1][col].getCompoundDrawables()[0] != null && buttons[row - 1][col].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
            bordrow = row - 1;
            bordcol = col;
            while (bordrow > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
                bordrow--;
            }
            if (bordrow > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_put_sigan.getConstantState())) {
                while (bordrow < row - 1) {
                    bordrow++;
                    n_place.add(bordrow + ","+ bordcol);

                    buttons[bordrow][bordcol].setCompoundDrawablesWithIntrinsicBounds(i_put_sigan, null, null, null);
                }
            }
        }

        if (row - 1 > limitdown && col - 1 > limitdown && buttons[row - 1][col - 1].getCompoundDrawables()[0] != null && buttons[row - 1][col - 1].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
            bordrow = row - 1;
            bordcol = col - 1;
            while (bordrow > limitdown && bordcol > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
                bordrow--;
                bordcol--;
            }
            if (bordrow > limitdown && bordcol > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_put_sigan.getConstantState())) {
                while (bordrow < row - 1 && bordcol < col - 1) {
                    bordrow++;
                    bordcol++;
                    n_place.add(bordrow + ","+ bordcol);
                    buttons[bordrow][bordcol].setCompoundDrawablesWithIntrinsicBounds(i_put_sigan, null, null, null);
                }
            }
        }

        if (row - 1 > limitdown && col + 1 < limitTop && buttons[row - 1][col + 1].getCompoundDrawables()[0] != null && buttons[row - 1][col + 1].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
            bordrow = row - 1;
            bordcol = col + 1;
            while (bordrow > limitdown && bordcol < limitTop && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
                bordrow--;
                bordcol++;
            }
            if (bordrow > limitdown && bordcol < limitTop && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_put_sigan.getConstantState())) {
                while (bordrow+1 < row && bordcol-1 > col) {
                    bordrow++;
                    bordcol--;
                    n_place.add(bordrow + ","+ bordcol);
                    buttons[bordrow][bordcol].setCompoundDrawablesWithIntrinsicBounds(i_put_sigan, null, null, null);
                }
            }
        }

        if (col + 1 < limitTop && buttons[row][col + 1].getCompoundDrawables()[0] != null && buttons[row][col + 1].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
            bordrow = row;
            bordcol = col + 1;
            while (bordcol < limitTop && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
                bordcol++;
            }
            if (bordcol < limitTop && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_put_sigan.getConstantState())) {
                while (bordcol-1 > col) {
                    bordcol--;
                    n_place.add(bordrow + ","+ bordcol);
                    buttons[bordrow][bordcol].setCompoundDrawablesWithIntrinsicBounds(i_put_sigan, null, null, null);
                }
            }
        }

        if (col - 1 > limitdown && buttons[row][col - 1].getCompoundDrawables()[0] != null && buttons[row][col - 1].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
            bordrow = row;
            bordcol = col - 1;
            while (bordcol > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
                bordcol--;
            }
            if (bordcol > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_put_sigan.getConstantState())) {
                while (bordcol < col-1) {
                    bordcol++;
                    n_place.add(bordrow + ","+ bordcol);
                    buttons[bordrow][bordcol].setCompoundDrawablesWithIntrinsicBounds(i_put_sigan, null, null, null);
                }
            }
        }

        if (row + 1 < limitTop && col + 1 < limitTop && buttons[row + 1][col + 1].getCompoundDrawables()[0] != null && buttons[row + 1][col + 1].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
            bordrow = row + 1;
            bordcol = col + 1;
            while (bordrow < limitTop && bordcol < limitTop && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
                bordrow++;
                bordcol++;
            }
            if (bordrow < limitTop && bordcol < limitTop && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_put_sigan.getConstantState())) {
                while (bordrow - 1 > row && bordcol - 1 > col) {
                    bordrow--;
                    bordcol--;
                    n_place.add(bordrow + ","+ bordcol);
                    buttons[bordrow][bordcol].setCompoundDrawablesWithIntrinsicBounds(i_put_sigan, null, null, null);
                }
            }
        }

        if (row + 1 < limitTop && col - 1 > limitdown && buttons[row + 1][col - 1].getCompoundDrawables()[0] != null && buttons[row + 1][col - 1].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
            bordrow = row + 1;
            bordcol = col - 1;
            while (bordrow < limitTop && bordcol > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
                bordrow++;
                bordcol--;
            }
            if (bordrow < limitTop && bordcol > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_put_sigan.getConstantState())) {
                while (bordrow - 1 > row && bordcol < col - 1) {
                    bordrow--;
                    bordcol++;
                    n_place.add(bordrow + ","+ bordcol);
                    buttons[bordrow][bordcol].setCompoundDrawablesWithIntrinsicBounds(i_put_sigan, null, null, null);
                }
            }
        }

        if (row + 1 < limitTop && buttons[row + 1][col].getCompoundDrawables()[0] != null && buttons[row + 1][col].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
            bordrow = row + 1;
            bordcol = col;
            while (bordrow < limitTop && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
                bordrow++;
            }
            if (bordrow < limitTop && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_put_sigan.getConstantState())) {
                while (bordrow - 1 > row) {
                    bordrow--;
                    n_place.add(bordrow + ","+ bordcol);
                    buttons[bordrow][bordcol].setCompoundDrawablesWithIntrinsicBounds(i_put_sigan, null, null, null);
                }
            }
        }
    }

    public void CleanYellowBox() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setBackgroundResource(R.drawable.shape);
                buttons[i][j].setTag("green");
            }
        }
    }

    public void GameOver()
    {
        boolean flag3=false;
        Drawable Drawableblack = getResources().getDrawable(R.drawable.black1);
        Drawable Drawablewhite = getResources().getDrawable(R.drawable.white);
        boolean flag= PlaceToEatOpponent(Drawableblack,Drawablewhite);
        boolean flag2=PlaceToEatOpponent(Drawablewhite,Drawableblack);
        for(int i=0;i<buttons.length;i++)
        {
            for(int j=0; j<buttons[i].length;j++)
            {
                if(buttons[i][j].getTag()=="yellow")
                { flag3=true; break;}
            }
        }
        CleanYellowBox();
        if (!flag && flag2)
        {
            Toast.makeText(this,getResources().getString(R.string.movelinewhite),Toast.LENGTH_SHORT).show();
            PlaceToEatOpponent(Drawablewhite,Drawableblack);
            tor=1;
        }
        if (flag &&!flag2)
        {
            Toast.makeText(this,getResources().getString(R.string.movelineblack),Toast.LENGTH_SHORT).show();
            PlaceToEatOpponent(Drawableblack,Drawablewhite);
            tor=0;
        }
        if((!flag && !flag2)|| !flag3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ReversiGame.this);
            final View dialogView = getLayoutInflater().inflate(R.layout.gameover, null);
            final AlertDialog dialog=builder.create();
            dialog.setView(dialogView);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setView(dialogView);
            TextView textView = dialogView.findViewById(R.id.gametext);
            final int[] s = Score();
            if (s[0] > s[1]) {
                win = name1;
                lose = name2;
                textView.setText(getResources().getString(R.string.winner) + " " + textView1.getText().toString().split(":")[1].split(" ")[0]);
            }
            if (s[1] > s[0]) {
                win=name2;
                lose =name1;
                textView.setText(getResources().getString(R.string.winner) + " " + textView2.getText().toString().split(":")[1].split(" ")[0]);
            } if(s[0]==s[1]) {
                win="-";
                lose="-";
                textView.setText(getResources().getString(R.string.equal));
            }
            Button btn =dialogView.findViewById(R.id.btn_again);
            Button btn2 =dialogView.findViewById(R.id.savescore);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(ReversiGame.this,ReversiGame.class);
                    intent.putExtra("name1",textView1.getText().toString().split(":")[0]);
                    intent.putExtra("name2",textView2.getText().toString().split(":")[0]);
                    startActivity(intent);
                    finish();

                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(getApplicationContext(),ScoreTable.class);
                    intent.putExtra("finish","true");
                    intent.putExtra("difficult","user");
                    intent.putExtra("players",name1 +" vs "+name2);
                    intent.putExtra("win",win);
                    intent.putExtra("lose",lose);
                    intent.putExtra("score",s[0]+ ":" +s[1]);
                    startActivity(intent);
                    finish();
                }
            });dialog.show();
        }
    }
    public int[] Score() {
        Drawable Drawableblack = getResources().getDrawable(R.drawable.black1);
        Drawable Drawablewhite = getResources().getDrawable(R.drawable.white);
        int[] Score = new int[2];
        Score[0] = 0;
        Score[1] = 0;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getCompoundDrawables()[0] != null && buttons[i][j].getCompoundDrawables()[0].getConstantState().equals(Drawableblack.getConstantState()))
                    Score[0]++;
                else if (buttons[i][j].getCompoundDrawables()[0] != null && buttons[i][j].getCompoundDrawables()[0].getConstantState().equals(Drawablewhite.getConstantState()))
                    Score[1]++;
            }
        }
        return Score;
    }
    @Override
    public void onClick(View v) {
        int row = 0, col = 0;

        Drawable Drawableblack = getResources().getDrawable(R.drawable.black1);
        Drawable Drawablewhite = getResources().getDrawable(R.drawable.white);
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getId() == v.getId()) {
                    row = i;
                    col = j;
                }
            }
        }
        if (tor == 0) {
            if (buttons[row][col].getTag() == "yellow") {
                buttons[row][col].setCompoundDrawablesWithIntrinsicBounds(Drawableblack, null, null, null);
                EatSoldgier(Drawableblack, row, col, Drawablewhite);

                CleanYellowBox();
                GameOver();
                int[]Score= Score();
                textView1.setText(" "+stringname1 +" " +Score[0]);
                textView2.setText(" "+stringname2 + " "+Score[1]);
                PlaceToEatOpponent(Drawablewhite, Drawableblack);
                tor = 1;
            } else if (buttons[row][col].getTag() == "green") {
                tor = 0;
                Toast.makeText(this, "you do unvalid move", Toast.LENGTH_SHORT).show();
            }
        } else if (tor == 1) {
            tor = 0;
            if (buttons[row][col].getTag() == "yellow") {
                buttons[row][col].setCompoundDrawablesWithIntrinsicBounds(Drawablewhite, null, null, null);
                EatSoldgier(Drawablewhite, row, col, Drawableblack);
                CleanYellowBox();
                GameOver();
                int[]Score= Score();
                textView1.setText(" "+stringname1 +" " +Score[0]);
                textView2.setText(" "+stringname2 + " "+Score[1]);
                PlaceToEatOpponent(Drawableblack, Drawablewhite);
            }
            else if (buttons[row][col].getTag() == "green") {
                tor = 1;
                Toast.makeText(this, "you do unvalid move", Toast.LENGTH_SHORT).show();
            }
        }
    }

}





