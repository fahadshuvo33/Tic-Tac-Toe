package com.uylab.tiktoktoegame;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.uylab.tiktoktoegame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mBinding;
    private int player1turn = 1;
    private char inputType;
    int roundCount = 0;
    private TextView[][] textId = new TextView[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        mBinding = DataBindingUtil.setContentView ( this, R.layout.activity_main );

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String idName = "text" + i + j;
                int resId = getResources ().getIdentifier ( idName, "id", getPackageName () ); //dynamically get id
                textId[i][j] = findViewById ( resId );
                textId[i][j].setOnClickListener ( this );

            }
        }
    }

    private void player1Win() {
        mBinding.resultText.setText ( "Player 1 Win" );
        mBinding.resultText.setVisibility ( View.VISIBLE );
        mBinding.playerText.setBackgroundResource ( R.drawable.player1_bg );
        mBinding.playerText.setTextColor ( Color.WHITE );
        mBinding.playerText2.setBackgroundResource ( R.drawable.player2_bg );
        mBinding.playerText2.setTextColor ( Color.BLACK );
    }

    private void player2Win() {
        mBinding.resultText.setText ( "Player 2 Win" );
        mBinding.resultText.setVisibility ( View.VISIBLE );
        mBinding.playerText2.setBackgroundResource ( R.drawable.player1_bg );
        mBinding.playerText2.setTextColor ( Color.WHITE );
        mBinding.playerText.setBackgroundResource ( R.drawable.player2_bg );
        mBinding.playerText.setTextColor ( Color.BLACK );
    }

    private void draw() {
        mBinding.resultText.setText ( "Match Draw" );
        mBinding.resultText.setVisibility ( View.VISIBLE );
        mBinding.playerText.setBackgroundResource ( R.drawable.player2_bg );
        mBinding.playerText.setTextColor ( Color.BLACK );
        mBinding.playerText2.setBackgroundResource ( R.drawable.player2_bg );
        mBinding.playerText2.setTextColor ( Color.BLACK );
    }

    public void nextPlayer() {
        if (player1turn == 1 && mBinding.resultText.getText ().toString ().trim ().isEmpty ()) {
            mBinding.playerText2.setBackgroundResource ( R.drawable.player1_bg );
            mBinding.playerText2.setTextColor ( Color.WHITE );
            mBinding.playerText.setBackgroundResource ( R.drawable.player2_bg );
            mBinding.playerText.setTextColor ( Color.BLACK );
            inputType = 'X';
            player1turn = 0;
        } else if (player1turn == 0 && mBinding.resultText.getText ().toString ().trim ().isEmpty ()) {
            mBinding.playerText.setBackgroundResource ( R.drawable.player1_bg );
            mBinding.playerText.setTextColor ( Color.WHITE );
            mBinding.playerText2.setBackgroundResource ( R.drawable.player2_bg );
            mBinding.playerText2.setTextColor ( Color.BLACK );
            inputType = 'O';
            player1turn = 1;
        }
    }

    public void cheakToWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String idName = "text" + i + j;
                int resId = getResources ().getIdentifier ( idName, "id", getPackageName () ); //dynamically get id
                textId[i][j] = findViewById ( resId );
                field[i][j] = textId[i][j].getText ().toString ().trim ();
            }
        }
        if (field[0][0].equals ( "X" ) && field[0][1].equals ( "X" ) && field[0][2].equals ( "X" )) {
            player1Win ();
            changeBG ( mBinding.text00, mBinding.text01, mBinding.text02 );
        } else if (field[0][0].equals ( "O" ) && field[0][1].equals ( "O" ) && field[0][2].equals ( "O" )) {
            player2Win ();
            changeBG ( mBinding.text00, mBinding.text01, mBinding.text02 );
        } else if (field[1][0].equals ( "O" ) && field[1][1].equals ( "O" ) && field[1][2].equals ( "O" )) {
            player2Win ();
            changeBG ( mBinding.text10, mBinding.text11, mBinding.text12 );
        } else if (field[1][0].equals ( "X" ) && field[1][1].equals ( "X" ) && field[1][2].equals ( "X" )) {
            player1Win ();
            changeBG ( mBinding.text10, mBinding.text11, mBinding.text12 );
        } else if (field[2][0].equals ( "X" ) && field[2][1].equals ( "X" ) && field[2][2].equals ( "X" )) {
            player1Win ();
            changeBG ( mBinding.text20, mBinding.text21, mBinding.text22 );
        } else if (field[2][0].equals ( "O" ) && field[2][1].equals ( "O" ) && field[2][2].equals ( "O" )) {
            player2Win ();
            changeBG ( mBinding.text20, mBinding.text21, mBinding.text22 );
        } else if (field[0][0].equals ( "X" ) && field[1][0].equals ( "X" ) && field[2][0].equals ( "X" )) {
            player1Win ();
            changeBG ( mBinding.text00, mBinding.text10, mBinding.text20 );
        } else if (field[0][0].equals ( "O" ) && field[1][0].equals ( "O" ) && field[2][0].equals ( "O" )) {
            player2Win ();
            changeBG ( mBinding.text00, mBinding.text10, mBinding.text20 );
        } else if (field[0][1].equals ( "O" ) && field[1][1].equals ( "O" ) && field[2][1].equals ( "O" )) {
            player2Win ();
            changeBG ( mBinding.text01, mBinding.text11, mBinding.text21 );
        } else if (field[0][1].equals ( "X" ) && field[1][1].equals ( "X" ) && field[2][1].equals ( "X" )) {
            player1Win ();
            changeBG ( mBinding.text01, mBinding.text11, mBinding.text21 );
        } else if (field[0][2].equals ( "X" ) && field[1][2].equals ( "X" ) && field[2][2].equals ( "X" )) {
            player1Win ();
            changeBG ( mBinding.text02, mBinding.text12, mBinding.text22 );
        } else if (field[0][2].equals ( "O" ) && field[1][2].equals ( "O" ) && field[2][2].equals ( "O" )) {
            player2Win ();
            changeBG ( mBinding.text02, mBinding.text12, mBinding.text22 );
        } else if (field[0][0].equals ( "X" ) && field[1][1].equals ( "X" ) && field[2][2].equals ( "X" )) {
            player1Win ();
            changeBG ( mBinding.text00, mBinding.text11, mBinding.text22 );
        } else if (field[0][0].equals ( "O" ) && field[1][1].equals ( "O" ) && field[2][2].equals ( "O" )) {
            player2Win ();
            changeBG ( mBinding.text00, mBinding.text11, mBinding.text22 );
        } else if (field[0][2].equals ( "O" ) && field[1][1].equals ( "O" ) && field[2][0].equals ( "O" )) {
            player2Win ();
            changeBG ( mBinding.text02, mBinding.text11, mBinding.text20 );
        } else if (field[0][2].equals ( "X" ) && field[1][1].equals ( "X" ) && field[2][0].equals ( "X" )) {
            player1Win ();
            changeBG ( mBinding.text02, mBinding.text11, mBinding.text20 );
        }
    }


    public void reset(TextView textView) {
        textView.setText ( "" );
        textView.setTextColor ( Color.BLACK );
        mBinding.resetBtn.setBackgroundResource ( R.drawable.player2_bg );
        textView.setBackgroundColor ( getResources ().getColor ( R.color.White ) );
    }

    public void clearAll(View view) {
        reset ( mBinding.text00 );
        reset ( mBinding.text01 );
        reset ( mBinding.text02 );
        reset ( mBinding.text10 );
        reset ( mBinding.text11 );
        reset ( mBinding.text12 );
        reset ( mBinding.text20 );
        reset ( mBinding.text21 );
        reset ( mBinding.text22 );
        mBinding.playerText.setBackgroundResource ( R.drawable.player1_bg );
        mBinding.playerText.setTextColor ( Color.WHITE );
        mBinding.playerText2.setBackgroundResource ( R.drawable.player2_bg );
        mBinding.playerText2.setTextColor ( Color.BLACK );
        mBinding.resultText.setText ( "" );
        mBinding.resultText.setVisibility ( View.GONE );
        player1turn = 1;
        roundCount = 0;
    }

    @Override
    public void onClick(View v) {
        mBinding.resetBtn.setBackgroundResource ( R.drawable.reset_bg );

        if (v.getId () == mBinding.text00.getId ()) {
            cheakValid ( mBinding.text00 );
        } else if (v.getId () == mBinding.text01.getId ()) {
            cheakValid ( mBinding.text01 );
        } else if (v.getId () == mBinding.text02.getId ()) {
            cheakValid ( mBinding.text02 );
        } else if (v.getId () == mBinding.text10.getId ()) {
            cheakValid ( mBinding.text10 );
        } else if (v.getId () == mBinding.text11.getId ()) {
            cheakValid ( mBinding.text11 );
        } else if (v.getId () == mBinding.text12.getId ()) {
            cheakValid ( mBinding.text12 );
        } else if (v.getId () == mBinding.text20.getId ()) {
            cheakValid ( mBinding.text20 );
        } else if (v.getId () == mBinding.text21.getId ()) {
            cheakValid ( mBinding.text21 );
        } else if (v.getId () == mBinding.text22.getId ()) {
            cheakValid ( mBinding.text22 );
        }
        if (roundCount == 9 && mBinding.resultText.getText ().toString ().trim ().isEmpty ()) {
            draw ();
        }
    }

    public void cheakValid(TextView textView) {
        if (textView.getText ().toString ().trim ().isEmpty () && mBinding.resultText.getText ().toString ().trim ().isEmpty ()) {
            nextPlayer ();
            textView.setText ( "" + inputType );
            cheakToWin ();
            roundCount++;
        } else if (!mBinding.resultText.getText ().toString ().trim ().isEmpty ()) {
            if (mBinding.resultText.getText ().toString ().equals ( "Player 1 Win" )) {
                showToast ( "Player 1 is already win, Reset to play again" );
            } else if (mBinding.resultText.getText ().toString ().equals ( "Player 2 Win" )) {
                showToast ( "Player 2 is already win, Reset to play again" );
            } else if (mBinding.resultText.getText ().toString ().equals ( "Match Draw" )) {
                showToast ( "Match is Draw, Reset to play again" );
            }
        }
    }

    public void changeBG(TextView t1, TextView t2, TextView t3) {
        t1.setBackgroundColor ( getResources ().getColor ( R.color.reset ) );
        t1.setTextColor ( Color.WHITE );
        t2.setBackgroundColor ( getResources ().getColor ( R.color.reset ) );
        t2.setTextColor ( Color.WHITE );
        t3.setBackgroundColor ( getResources ().getColor ( R.color.reset ) );
        t3.setTextColor ( Color.WHITE );
    }

    public void showToast(String str) {
        Toast toast = new Toast ( MainActivity.this );
        toast.setGravity ( Gravity.CENTER, 0, 0 );
        TextView t = new TextView ( getApplicationContext () );
        t.setBackgroundResource ( R.drawable.toast_bg );
        t.setTextColor ( Color.BLACK );
        t.setText ( str );
        t.setPadding ( 16, 8, 16, 8 );
        t.setTextSize ( 10 );
        toast.setView ( t );
        toast.show ();
    }
}