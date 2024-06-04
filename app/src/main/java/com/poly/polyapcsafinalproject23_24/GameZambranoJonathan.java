package com.poly.polyapcsafinalproject23_24;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameZambranoJonathan extends GameActivity {

    /**
     * player in game
     **/
    private ZambranoFisherman player;

    TextView tvHealthVal, tvBaitVal, tvFishVal, tvWalletVal, tvMain;
    Button btn1, btn2, btn3, btn4;


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

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);

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
        setSail();
        while (player.getShipHealth() >= 0 || (player.getMoney() <= 0 && player.getBait() <= 0 && player.getFishCaught() <= 0))
        {
            displayStats();
            chooseOption();
        }
        endOfFishing();
    }

    /**
     * method that starts the fishermans fishing and allows the fisherman to catch fish
     **/
    private void setSail()
    {
        System.out.println("Sea looks full today, shall we set sail?");
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
        System.out.println("1.Head to shop and buy bait?\n2.set sail and catch fish?\n3.head to Fishmonger to sell your fish?");

        btn1.setText("Head to shop and buy bait");
        btn2.setText("set sail and catch fish?");



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.buyBait();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Math.random() < (.6))
                {
                    System.out.println("You caught a fish!!");
                    player.catchFish();
                }
                else
                {
                    player.snugged();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("How many fish do you want to sell?");
                player.sellFish();
            }
        });
    }

    /**
     * After player's ship health and money equal 0, the simulation ends. Messages are
     * displayed to indicate that the simulation has ended.
     **/
    private void endOfFishing()
    {
        System.out.println(" Womp Womp you lost, Game Over!!,");
        run();

    }
}