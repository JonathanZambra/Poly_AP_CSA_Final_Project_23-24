package com.poly.polyapcsafinalproject23_24;

/**
 * Fisherman going fishing to make a living
 * @author Jonathan Zambrano
 * @since 1/10/24
 * @ version 1.0
 */
public class ZambranoFisherman {

    /**
     * Fisherman's name
     */
    private String name;
    /**
     * Amount of helath the ship has
     */
    private double shipHealth;
    /**
     * Amount of bait you have
     **/
    private int bait;
    /**
     * Amount of fish caught
     */
    private int fishCaught;
    /**
     * amount of money in your wallet
     **/
    private double money;
    /**
     * ID of the Fisherman, assigned in constructor
     **/
    private final int ID;
    /**
     * tracks number of Fisherman created
     **/
    private static int numFisherman;

    public static final double BAIT_COST = 1.25;
    public static final double FISH_VALUE = 5.00;

    /**
     *constructor that initizalizes all attributes
     * <br>Preconditions : name must be nonnull, all other values must be non-negative
     * <br>Postcondition: Fisherman with given name
     *      shipHealth,  bait,  fishCaught,  money,  ID assigned
     * @param  name                 name of Fisherman
     * @param  shipHealth           amount of health the ship has ( >= 0)
     * @param  bait                 amount of bait you have ( >= 0)
     * @param  fishCaught           amount of fishCaught ( >= 0)
     * @param  money                amount of money you have ( >= 0)
     */
    public ZambranoFisherman(String name, double shipHealth, int bait, int fishCaught, double money, int ID, int numFisherman)
    {
        this.name = name;
        this.shipHealth = shipHealth;
        this.bait = bait;
        this.fishCaught = fishCaught;
        this.money = money;
        numFisherman++;
        this.ID = numFisherman;
    }

    /**
     * default constructor
     * <br>Postcondition: Fisherman with an empty string
     *     shipHealth,  bait,  fishCaught,  money set to 4.00,  ID assigned
     */
    public ZambranoFisherman()
    {
        this.name = " ";
        this.shipHealth = 200.00;
        this.bait = 5;
        this.fishCaught = 0;
        this.money = 4.00;
        this.ID = numFisherman;
    }

    /**
     *constructor that initializes name
     * <br>Precondition: name must be nonnull
     * <br>Postconditions:  Fisherman with given name
     *     shipHealth,  bait,  fishCaught,  money set to 4.00,  ID assigned
     * @param  name  name of Fisherman
     **/
    public ZambranoFisherman(String name)
    {
        this.name = name;
        this.shipHealth = 200.00;
        this.bait = 5;
        this.fishCaught = 0;
        this.money = 4.00;
        numFisherman++;
        this.ID = numFisherman;
    }

    //getters
    /**
     * sets the contestant's name
     * <br>Precondition:  bewBane is a non-empty string
     * <br>Postcondition: name set to newName
     * @param    newName    new name for the Fisherman
     **/
    public void setName(String newName)
    {
        this.name = newName;
    }

    /**
     * gets the Fisherman's name
     * @return  name of Fisherman
     **/
    public String getName()
    {
        return name;
    }

    /**
     * gets the ampount of health your ship has
     * @return    amount of health your ship has
     **/
    public double getShipHealth()
    {
        return shipHealth;
    }

    /**
     * gets the ampount of bait have
     * @return    gets the ampount of bait have
     **/
    public int getBait()
    {
        return bait;
    }

    /**
     * gets the ampount of fish you've caught
     * @return    gets the amount of fish you've caught
     **/
    public int getFishCaught()
    {
        return fishCaught;
    }

    /**
     * gets the ampount of money you have
     * @return    gets the amount of money you have
     **/
    public double getMoney()
    {
        return money;
    }

    /**
     * gets the ID
     * @return  gets the ID
     **/
    public int getID()
    {
        return ID;
    }

    /**
     * gets the number of Fisherman
     * @retu8rn gets the number of Fisherman
     **/
    public static int getNumFisherman()
    {
        return numFisherman;
    }

    //Setters
    /**
     * sets the ampount of health your ship has
     * <br>Precondition: shipHealth greater than or equal to 200
     * <br>Postcondition: shipHealth set
     * @param    shipHealth   amount of ship health you have (>=200)
     **/
    public void setShipHealth(int shipHealth)
    {
        this.shipHealth = shipHealth;
    }

    /**
     * sets the ampount of bait you have
     * <br>Precondition: bait greater than or equal to 5
     * <br>Postcondition: bait set
     * @param    bait   amount of bait you have (>=5)
     **/
    public void setBait(int bait)
    {
        this.bait = bait;
    }

    /**
     * sets the ampount of fish you've caught
     * <br>Precondition: fishCaught greater than or equal to 0
     * <br>Postcondition: fishCaught set
     * @param    fishCaught   amount of fish you've caught (>=0)
     **/
    public void setFishCaught(int fishCaught)
    {
        this.fishCaught = fishCaught;
    }

    /**
     * sets the ampount of money you have
     * <br>Precondition: money greater than or equal to 4
     * <br>Postcondition: money set
     * @param    money   amount of money you have (>=4)
     **/
    public void setMoney(int money)
    {
        this.money = money;
    }

    /**
     * toString method
     * @return    Fisherman as a string
     */
    @Override
    public String toString()
    {
        return
                "Fisherman name:\t" + name +
                        "\nShip health:\t\t" + shipHealth +
                        "\nBaits available:\t\t" + bait +
                        "\nNumber of fish caught:\t" + fishCaught +
                        "\nMoney amount:\t\t" + money +
                        "\n Fisherman ID:\t" + ID;
    }


    /**
     * returns true if all attributes match between two Fisherman
     * <br>Precondition: anotherFisherman must be nonnull
     * @param    anotherFisherman    another Fisherman object
     * @return   true if Fisherman are equal
     **/
    public boolean equals(ZambranoFisherman anotherFisherman)
    {
        if(this.name.equals(anotherFisherman.name) &&
                this.shipHealth == anotherFisherman.shipHealth &&
                this.bait == anotherFisherman.bait &&
                this.fishCaught == anotherFisherman.fishCaught &&
                this.money == anotherFisherman.money &&
                this.ID == anotherFisherman.ID
        )
        {
            return true;
        }
        return false;
    }


    //Mutator methods
    /**
     * run this method when the  Fisherman buys bait
     * <br>Precondition: amount is greater than 0
     * <br>Postcondition:
     * <br>money decreadsed by amount * 2
     * <br>bait increased by 1
     **/
    public void buyBait()
    {
        if (money >= BAIT_COST)
        {
            money-= BAIT_COST;
            bait++;
        }

    }

    /**
     * run this method when the Fisherman casts his bait
     * <br>Postcondition:
     * <br>fishCaught decreased by amount * 2
     * <br>bait decreased by 1
     * <br>shipHealth deacreased by amount
     **/
    public void catchFish()
    {
        fishCaught++;
        bait--;
        if (fishCaught > 3)
        {
            shipHealth -= (20.00 + 10.00 * (fishCaught - 5));
        }
    }

    /**
     * run this method when the Fisherman casts his bait
     * <br>Postcondition:
     * <br>bait decreased by 1
     * <br>fishCaught increased by 0
     **/
    public void snugged()
    {
        bait--;
    }



    /**
     * run this method when the Fisherman sells fishCaught
     * <br>Postcondition:
     * <br>money increased by 5
     * <br>fishCaught decreased by 1
     **/
    public void sellFish()
    {
        money += (fishCaught * FISH_VALUE);
        fishCaught = 0;


    }

}