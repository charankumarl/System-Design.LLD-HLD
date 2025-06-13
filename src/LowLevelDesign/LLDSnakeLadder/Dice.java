package LowLevelDesign.LLDSnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount){  // Scalable. Upto any number of dice.

        this.diceCount = diceCount;
    }

    public int rollDice(){

        int totalSum=0;
        int diceUsed=0;

        while(diceUsed < diceCount){  // roll for 1 time, if n times, then roll n times.

            totalSum += ThreadLocalRandom.current().nextInt(min,max+1);
            diceUsed++;
        }

        return totalSum;
    }
}
