package com.duckrace;

import java.util.Collection;

public class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racerOne = new DuckRacer(1, "Amir");
        racerOne.win(Reward.DEBIT_CARD);
        racerOne.win(Reward.DEBIT_CARD);
        racerOne.win(Reward.PRIZES);
        racerOne.win(Reward.DEBIT_CARD);

        System.out.println(racerOne);

        Collection<Reward> rewards = racerOne.getRewards();
        System.out.println(rewards);


    }
}
