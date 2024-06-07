package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DuckRacer {
    private final int id;
    private String name;
    private int wins;
    private final Collection<Reward> rewards = new ArrayList<>();

    //constructors
     public DuckRacer(int id, String name){
         this.id = id;
         setName(name); //call setter in-case you want to validate name
     }
     //business or action methods
    public void win(Reward reward){
         rewards.add(reward);

    }

     //accessor methods
    public int getId(){
         return id;
    }
    public String getName(){
         return name;
    }

    public void setName(String name){
         this.name = name;
    }

    public int getWins(){
         return rewards.size();
    }

    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s", getClass().getSimpleName(), getId(), getName(), getWins()
        , getRewards());

    }
}