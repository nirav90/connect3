package com.example.connect3game

import android.icu.text.Edits
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.children
import androidx.gridlayout.widget.GridLayout


class MainActivity : AppCompatActivity() {

    var activePlayer: Int = 0;
    var gameActive:Boolean=true;
    var gameDraw:Boolean=false;

    var gameState: IntArray = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    val winningPosition1: IntArray = intArrayOf(0, 1, 2)
    val winningPosition2: IntArray = intArrayOf(3, 4, 5)
    val winningPosition3: IntArray = intArrayOf(6, 7, 8)
    val winningPosition4: IntArray = intArrayOf(0, 3, 6)
    val winningPosition5: IntArray = intArrayOf(1, 4, 7)
    val winningPosition6: IntArray = intArrayOf(2, 5, 8)
    val winningPosition7: IntArray = intArrayOf(0, 4, 8)
    val winningPosition8: IntArray = intArrayOf(2, 4, 6)

    val winningPositions = arrayOf(
        winningPosition1,
        winningPosition2,
        winningPosition3,
        winningPosition4,
        winningPosition5,
        winningPosition6,
        winningPosition7,
        winningPosition8
    );



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<ImageView>(R.id.imageViewRed1).setOnClickListener {
            var imageView = findViewById<ImageView>(R.id.imageViewRed1) as ImageView;
            dropIn(imageView)
        }

        findViewById<ImageView>(R.id.imageViewRed2).setOnClickListener {
            var imageView = findViewById<ImageView>(R.id.imageViewRed2) as ImageView;
            dropIn(imageView)
        }

        findViewById<ImageView>(R.id.imageViewRed3).setOnClickListener {
            var imageView = findViewById<ImageView>(R.id.imageViewRed3) as ImageView;
            dropIn(imageView)
        }

        findViewById<ImageView>(R.id.imageViewRed4).setOnClickListener {
            var imageView = findViewById<ImageView>(R.id.imageViewRed4) as ImageView;
            dropIn(imageView)
        }

        findViewById<ImageView>(R.id.imageViewRed5).setOnClickListener {
            var imageView = findViewById<ImageView>(R.id.imageViewRed5) as ImageView;
            dropIn(imageView)
        }

        findViewById<ImageView>(R.id.imageViewRed6).setOnClickListener {
            var imageView = findViewById<ImageView>(R.id.imageViewRed6) as ImageView;
            dropIn(imageView)
        }

        findViewById<ImageView>(R.id.imageViewRed7).setOnClickListener {
            var imageView = findViewById<ImageView>(R.id.imageViewRed7) as ImageView;
            dropIn(imageView)
        }

        findViewById<ImageView>(R.id.imageViewRed8).setOnClickListener {
            var imageView = findViewById<ImageView>(R.id.imageViewRed8) as ImageView;
            dropIn(imageView)
        }

        findViewById<ImageView>(R.id.imageViewRed9).setOnClickListener {
            var imageView = findViewById<ImageView>(R.id.imageViewRed9) as ImageView;
                dropIn(imageView)
        }

        findViewById<Button>(R.id.reset).setOnClickListener {
            playAgain();
        }
    }

    private fun dropIn(view: ImageView) {

        var tappedCounte:Int = Integer.parseInt(view.getTag().toString())
        if(gameState[tappedCounte]==2 && gameActive){
            gameState[tappedCounte] = activePlayer;

            //code to add connect in box
            if (activePlayer == 0) {
                view.setImageResource(R.drawable.yellow);
                view.animate().rotation(1800f).setDuration(300L)
                activePlayer = 1;
            } else {
                view.setImageResource(R.drawable.red);
                view.animate().rotation(1800f).setDuration(300L)
                activePlayer = 0
            }

            //code to decide winner
            for (winningPosition: IntArray in winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    var winner:String="";
                    if(activePlayer==1){
                        winner="Yellow Player"
                        gameActive=false;
                    }else{
                        winner="Red Player"
                        gameActive=false;
                    }
                    //Toast.makeText(this, winner + "Won the game", Toast.LENGTH_LONG).show();

                    var winnerTextView:TextView = findViewById<TextView>(R.id.winnerTextView);
                    var reset:Button = findViewById<Button>(R.id.reset);
                    winnerTextView.setText(winner+ " Won the game" );
                    winnerTextView.visibility=View.VISIBLE;
                    reset.visibility=View.VISIBLE;
                }

            }

            //code to check isMatch is draw
            var allBoxTapped = true;
            for (i in 0..gameState.size-1){
                if(gameState[i]==2){
                    allBoxTapped=false;
                }
            }
            if(gameActive && allBoxTapped){
                var winnerTextView:TextView = findViewById<TextView>(R.id.winnerTextView);
                var reset:Button = findViewById<Button>(R.id.reset);
                winnerTextView.setText(" Game Draw. Play Again!!" );
                winnerTextView.visibility=View.VISIBLE;
                reset.visibility=View.VISIBLE;
            }
        }
    }

    private fun playAgain() {
        var gridLayout = findViewById(R.id.gridLayout) as GridLayout;
        for(i in 0..gridLayout.childCount-1){
            var imageView = gridLayout.getChildAt(i) as ImageView;
            imageView.setImageDrawable(null);
        }
        var winnerTextView:TextView = findViewById<TextView>(R.id.winnerTextView);
        var reset:Button = findViewById<Button>(R.id.reset);
        winnerTextView.visibility=View.GONE;
        reset.visibility=View.GONE;
        //reseting game variables
        activePlayer= 0;
        gameActive=true;
        gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)

    }
}
