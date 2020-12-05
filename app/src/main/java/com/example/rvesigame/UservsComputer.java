package com.example.rvesigame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class UservsComputer extends AppCompatActivity implements View.OnClickListener {

    String win,lose;
    SharedPreferences sp;
    Button[][] buttons = new Button[8][8];
    List<Integer> buttons1 = new LinkedList<>();
     int btn;
    String stringname1,stringname2,name1,name2;
    TextView textView1,textView2;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView1 = findViewById(R.id.text_play1);
         textView2 = findViewById(R.id.text_play2);
         name1=getIntent().getStringExtra("name");
         name2=getResources().getString(R.string.PC);
        textView1.setText(textView1.getText().toString() + " " + getIntent().getStringExtra("name"));
        textView2.setText(textView2.getText().toString() + " " + getResources().getString(R.string.PC));
        textView1=findViewById(R.id.text_play1);
        textView2=findViewById(R.id.text_play2);
        stringname1=textView1.getText().toString();
        stringname2=textView2.getText().toString();
        textView1.setText( " " + stringname1 +" " +"2" );
        textView2.setText( " " + stringname2 +" "+ "2");
        sp =getSharedPreferences("score details",MODE_PRIVATE);
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

    public void Setonbutton() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    public boolean PlaceToEatOpponent(Drawable i_drawableEat, Drawable i_mustEat) {
        final int limitdown = -1;
        final int limitTop = 8;
        int bordRow, bordCol;
        boolean flag=false;
        Drawable drawable1;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                drawable1 = buttons[i][j].getCompoundDrawables()[0];
                if (drawable1 == null)
                    continue;
                if (drawable1.getConstantState().equals(i_drawableEat.getConstantState()))//i have the sigan
                {
                    if (i - 1 > limitdown && buttons[i - 1][j].getCompoundDrawables()[0] != null/*is nothing*/ /*&& buttons[i-1][j].getCompoundDrawables()[0].equals(i_mustEat.getConstantState())*/) {
                        bordRow = i - 1;
                        bordCol = j;
                        while (bordRow > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] != null && buttons[bordRow][bordCol].getCompoundDrawables()[0].getConstantState().equals(i_mustEat.getConstantState())) {
                            bordRow--;
                        }
                        if (bordRow > limitdown && buttons[bordRow][bordCol].getCompoundDrawables()[0] == null) {
                            buttons[bordRow][bordCol].setBackgroundResource(R.drawable.shapeyellow);
                            buttons[bordRow][bordCol].setTag("yellow");
                            flag=true;
                            if (i_drawableEat.getConstantState().equals(getResources().getDrawable(R.drawable.white).getConstantState())) {
                                buttons1.add(buttons[bordRow][bordCol].getId());
                            }
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
                            flag=true;
                            buttons[bordRow][bordCol].setTag("yellow");
                            if (i_drawableEat.getConstantState().equals(getResources().getDrawable(R.drawable.white).getConstantState())) {
                                buttons1.add(buttons[bordRow][bordCol].getId());
                            }
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
                            flag=true;
                            if (i_drawableEat.getConstantState().equals(getResources().getDrawable(R.drawable.white).getConstantState())) {
                                buttons1.add(buttons[bordRow][bordCol].getId());
                            }
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
                            flag=true;
                            buttons[bordRow][bordCol].setTag("yellow");
                            if (i_drawableEat.getConstantState().equals(getResources().getDrawable(R.drawable.white).getConstantState())) {
                                buttons1.add(buttons[bordRow][bordCol].getId());
                            }
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
                            flag=true;
                            if (i_drawableEat.getConstantState().equals(getResources().getDrawable(R.drawable.white).getConstantState())) {
                                buttons1.add(buttons[bordRow][bordCol].getId());
                            }
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
                            flag=true;
                            if (i_drawableEat.getConstantState().equals(getResources().getDrawable(R.drawable.white).getConstantState())) {
                                buttons1.add(buttons[bordRow][bordCol].getId());
                            }
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
                            flag=true;
                            if (i_drawableEat.getConstantState().equals(getResources().getDrawable(R.drawable.white).getConstantState())) {
                                buttons1.add(buttons[bordRow][bordCol].getId());
                            }
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
                            flag=true;
                            if (i_drawableEat.getConstantState().equals(getResources().getDrawable(R.drawable.white).getConstantState())) {
                                buttons1.add(buttons[bordRow][bordCol].getId());
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public void EatSoldgier(Drawable i_put_sigan, int row, int col, Drawable i_eat_sigan) {
        final int limitdown = -1;
        final int limitTop = 8;
        int bordrow, bordcol;
        if (row - 1 > limitdown && buttons[row - 1][col].getCompoundDrawables()[0] != null && buttons[row - 1][col].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
            bordrow = row - 1;
            bordcol = col;
            while (bordrow > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_eat_sigan.getConstantState())) {
                bordrow--;
            }
            if (bordrow > limitdown && buttons[bordrow][bordcol].getCompoundDrawables()[0] != null && buttons[bordrow][bordcol].getCompoundDrawables()[0].getConstantState().equals(i_put_sigan.getConstantState())) {
                while (bordrow < row) {
                    bordrow++;
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
                while (bordrow < row && bordcol < col) {
                    bordrow++;
                    bordcol++;
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
                while (bordrow < row && bordcol > col) {
                    bordrow++;
                    bordcol--;
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
                while (bordcol > col) {
                    bordcol--;
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
                while (bordcol < col) {
                    bordcol++;
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
                while (bordrow > row && bordcol > col) {
                    bordrow--;
                    bordcol--;
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
                while (bordrow > row && bordcol < col) {
                    bordrow--;
                    bordcol++;
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
                while (bordrow > row) {
                    bordrow--;
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
        buttons1.clear();
    }

    public int count_number(int num)
    {int count=0;
      for(int j=0;j<buttons1.size();j++)
      {
          if(buttons1.get(j)==num) {
              count++;
          }
      }
      return count;
    }
    public int easy()
    {
        if(buttons1.isEmpty()) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.movelineblack), Toast.LENGTH_SHORT).show();
            return -1;
        }
        boolean begin=false;
        int showtime=1;
        int min=buttons1.get(0);
        for(int i=0; i < buttons1.size();i++) {
            if(!begin)
            {
                showtime=count_number(buttons1.get(i));
                begin=true;
            }
            else
            {
                int counter = count_number(buttons1.get(i));
                if(showtime > counter)
                {
                    min=buttons1.get(i);
                    showtime= counter;
                }
            }
        }
        return min;
    }

    public int meduim()
    {
        if(buttons1.isEmpty()) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.movelineblack), Toast.LENGTH_SHORT).show();
            return -1;
        }
        int size=buttons1.size();
        Random rnd=new Random();
        int number;
        number = rnd.nextInt(size);
        return buttons1.get(number);
    }

    public int hard()
    {
    boolean begin=false;
    int showtime=1;
        if(buttons1.isEmpty()) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.movelineblack), Toast.LENGTH_SHORT).show();
            return -1;
        }
    int max=buttons1.get(0);
        for(int i=0; i < buttons1.size();i++) {
        if(!begin)
        {
            showtime=count_number(buttons1.get(i));
            begin=true;
        }
        else
        {
            int counter = count_number(buttons1.get(i));
            if(showtime < counter)
            {
                max=buttons1.get(i);
                showtime = counter;
            }
        }
    }
        return max;
}


    public void GameOver()
    {

        Drawable Drawableblack = getResources().getDrawable(R.drawable.black1);
        Drawable Drawablewhite = getResources().getDrawable(R.drawable.white);
        boolean flag3=true;
        for(int i=0 ;i<buttons.length;i++)
        {
            for(int j=0; j <buttons[i].length;j++){
                if(buttons[i][j].getTag()!="green")
                {
                    flag3=false;
                    break;
                }
            }
        }
        if(flag3)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(UservsComputer.this);
            final  View dialogView=getLayoutInflater().inflate(R.layout.gameover,null);
            final AlertDialog dialog=builder.create();
            dialog.setView(dialogView);
            dialog.setCanceledOnTouchOutside(false);
            TextView textView= dialogView.findViewById(R.id.gametext);
            final int [] s=Score();
            if(s[0]>s[1]) {
                win=name1;
                lose=name2;
                textView.setText(getResources().getString(R.string.winner) + " " + name1);}
            if(s[1]>s[0]) {
                 win=name2;
                 lose=name1;
                textView.setText(getResources().getString(R.string.winner) + " " + name2);
            }
            if(s[0]==s[1]){
                win="-";
                lose="-";
                textView.setText(getResources().getString(R.string.equal));}
            Button btn = dialogView.findViewById(R.id.btn_again);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(UservsComputer.this,UservsComputer.class);
                    intent.putExtra("name",name1);
                    intent.putExtra("difficult",getIntent().getStringExtra("difficult"));
                    startActivity(intent);
                    finish();
                }
            });
            Button btn2 =dialogView.findViewById(R.id.savescore);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(getApplicationContext(),ScoreTable.class);
                    intent.putExtra("finish","true");
                    intent.putExtra("players",name1 +" vs " +name2);
                    intent.putExtra("win",win);
                    intent.putExtra("lose",lose);
                    intent.putExtra("score",s[0] +":" +s[1]);
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

    public void computerplay()
    {
        int row=0,col=0;
        Drawable Drawableblack = getResources().getDrawable(R.drawable.black1);
        Drawable Drawablewhite = getResources().getDrawable(R.drawable.white);
        String string=getIntent().getStringExtra("difficult");
        switch (string)
        {
            case "easy": btn = easy();break;
            case "meduim":btn = meduim(); break;
            default:btn = hard(); break;
        }
        if(btn != -1)
        {
            for (int i = 0; i < buttons.length; i++) {//find the button
                for (int j = 0; j < buttons[i].length; j++) {
                    if (buttons[i][j].getId() == btn) {
                        row = i;
                        col = j;
                    }
                }
            }
            buttons[row][col].setCompoundDrawablesWithIntrinsicBounds(Drawablewhite, null, null, null);//put white soldgier
            EatSoldgier(Drawablewhite, row, col, Drawableblack);//eat the soldgier
        }
        CleanYellowBox();//clean all the yellow box
        int[]Score= Score();
        textView1.setText(" "+stringname1 +" " +Score[0]);
        textView2.setText(" "+stringname2 + " "+Score[1]);
    }

    @Override
    public void onClick(View v) {
        int row = 0, col = 0, tor = 0,first=0;
        boolean flag = true;
        Drawable Drawableblack = getResources().getDrawable(R.drawable.black1);
        Drawable Drawablewhite = getResources().getDrawable(R.drawable.white);
        for (int i = 0; i < buttons.length; i++) {//get the id of a button that the user push
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getId() == v.getId()) {
                    row = i;
                    col = j;
                }
            }
        }
        if (buttons[row][col].getTag() == "yellow") {//can eat oppent
            if (tor == 0) {
                buttons[row][col].setCompoundDrawablesWithIntrinsicBounds(Drawableblack, null, null, null);
                EatSoldgier(Drawableblack, row, col, Drawablewhite);
                CleanYellowBox();
                flag = PlaceToEatOpponent(Drawablewhite, Drawableblack);
                tor = 1;
            }
            if (tor == 1) {
                if (flag) {
                    computerplay();
                    tor=0;
                } else if (!flag) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.movelineblack), Toast.LENGTH_SHORT).show();
                }
                boolean flag2 = PlaceToEatOpponent(Drawableblack, Drawablewhite);
                boolean flag1=true;
                while (!flag2 && flag1==true) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.movelinewhite), Toast.LENGTH_SHORT).show();
                    flag1 = PlaceToEatOpponent(Drawablewhite, Drawableblack);
                    computerplay();
                    flag2 = PlaceToEatOpponent(Drawableblack, Drawablewhite);
                }
                GameOver();
            } else if (buttons[row][col].getTag() == "green")
                Toast.makeText(this, "you do unvalid move", Toast.LENGTH_SHORT).show();
        }
    }
}
