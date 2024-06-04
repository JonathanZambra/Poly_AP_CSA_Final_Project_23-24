package com.poly.polyapcsafinalproject23_24;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameZambranoJonathan extends GameActivity {

    /**
     * player in game
     **/
    private ZambranoFisherman player;

    TextView tvHealthVal, tvBaitVal, tvFishVal, tvWalletVal, tvMain;
    Button btn1, btn2, btn3;
    ImageView ivMain;
    private int count;


    //write game down here
    //  use other void methods as nesssary
    //  use loops as nessesary

    /**
     * method that runs the game. calls createPlayer() and run game()
     **/
    public void run()
    {
        setContentView(R.layout.activity_zambrano_main);

        tvMain = findViewById(R.id.tv_main);
        tvHealthVal = findViewById(R.id.tv_health_val);
        tvBaitVal = findViewById(R.id.tv_lure_val);
        tvFishVal = findViewById(R.id.tv_fish_val);
        tvWalletVal = findViewById(R.id.tv_wallet_val);

        ivMain = findViewById(R.id.iv_main);

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);

        tvMain.setText("Welcome fisherman");

        ivMain.setImageResource(R.drawable.im_jonthanzambrano_starterisland);

        createPlayer();
        goFishing();
    }

    /**
     * method that creates the player.Method asks for the user name and uses it
     * to crate a Fisherman
     **/
    private void createPlayer()
    {
        player = new ZambranoFisherman("Fisherman Byron");
    }


    //method that runs the simulation

    /**
     * method that runs the simulation. The simulation runs in a loop where a player
     * goes fishing to catch fish. The simulation ends when the Fisherman's ship health,      * and money reach 0 or when the Fisherman is all out of bait.
     **/
    private void goFishing()
    {
        if (player.getShipHealth() >= 0 && player.getMoney() > 0 && player.getBait() > 0)
        {
            displayStats();
            chooseOption();
        }
        else {
            endOfFishing();
        }
    }



    /**
     * Displays the stats of the player before being given an option
     **/
    private void displayStats()
    {
        tvHealthVal.setText(""+player.getShipHealth());
        tvBaitVal.setText(""+player.getBait());
        tvWalletVal.setText(""+player.getMoney());
        tvFishVal.setText(""+player.getFishCaught());
    }

    /**
     * player chooses to buy bait, catch fish, or sell fish
     **/
    private void chooseOption()
    {
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);

        if (player.getMoney() < ZambranoFisherman.BAIT_COST) {
            btn1.setVisibility(View.INVISIBLE);
        } else {
            btn1.setVisibility(View.VISIBLE);
        }

        if (player.getBait() <= 0) {
            btn2.setVisibility(View.INVISIBLE);
        } else {
            btn2.setVisibility(View.VISIBLE);
        }

        if (player.getFishCaught() <= 0) {
            btn3.setVisibility(View.INVISIBLE);
        } else {
            btn3.setVisibility(View.VISIBLE);
        }

        btn1.setText("Head to shop and buy bait");
        btn2.setText("Set sail and catch fish?");
        btn3.setText("Head to Fishmonger to sell your fish?");



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMain.setText("Here is your bait fellow fisher");
                ivMain.setImageResource(R.drawable.im_jonathanzambrano_fishmonger);
                player.buyBait();
                goFishing();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player.getBait() > 0) {
                    if (Math.random() < 0.6)
                    {
                        ivMain.setImageResource(R.drawable.im_jonathanzambrano_fishcaught);
                        tvMain.setText("You caught a fish!!");
                        player.catchFish();
                    }
                    else
                    {
                        ivMain.setImageResource(R.drawable.im_jonathanzambrano_snugged);
                        player.snugged();
                        tvMain.setText("Darn! You've been snugged!!");
                    }
                    goFishing();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMain.setText("Pleasure doing business.");
                ivMain.setImageResource(R.drawable.im_jonathanzambrano_fishermanshop);
                player.sellFish();
                goFishing();
            }
        });
    }

    /**
     * After player's ship health and money equal 0, the simulation ends. Messages are
     * displayed to indicate that the simulation has ended.
     **/
    private void endOfFishing()
    {
        tvMain.setText("Womp Womp you lost, Game Over!!");
        btn1.setText("Play again");
        btn2.setText("Don't play again");
        btn3.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                run();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameZambranoJonathan.this, MainActivity.class));
            }
        });

    }
}