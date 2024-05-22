package com.poly.polyapcsafinalproject23_24;

public class GameZambranoJonathan extends GameActivity {

    /**
     * player in game
     **/
    private ZambranoFisherman player;


    //write game down here
    //  use other void methods as nesssary
    //  use loops as nessesary

    /**
     * method that runs the game. calls createPlayer() and run game()
     **/
    public void run()
    {
        createPlayer();
        goFishing();
    }

    /**
     * method that creates the player.Method asks for the user name and uses it
     * to crate a Fisherman
     **/
    private void createPlayer()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("whats your name?");
        String name = scan.nextLine();
        player = new ZambranoFisherman(name);
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
        System.out.println("Ship Health:\t" + player.getShipHealth());
        System.out.println("Bait Available:\t" + player.getBait());
        System.out.println("Wallet:\t\t\t$" + player.getMoney());
        System.out.println("Fish caught:\t" + player.getFishCaught());
    }

    /**
     * player chooses to buy bait, catch fish, or sell fish
     **/
    private void chooseOption()
    {
        System.out.println("1.Head to shop and buy bait?\n2.set sail and catch fish?\n3.head to Fishmonger to sell your fish?");
        if (option == 1)
        {
            System.out.println(" How much bait do you want to purchase?");
            player.buyBait(amount);
        }
        else if (option == 2)
        {
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
        else if (option == 3)
        {
            System.out.println("How many fish do you want to sell?");
            player.sellFish(amount);
        }
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