package com.duckrace;

import java.util.Scanner;

/*
* Application Controller.
* Directs overall flow of the applications and prompts the user for inputs.
* Will add those inputs innto the system.
*/

public class DuckRaceApp {
    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);

    public void execute(){
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForRewrd();
        board.updateBoard(id, reward);
        showBoard();


    }

    private Reward promptForRewrd() {
        Reward reward = null;

        return reward;
    }

    private int promptForId() {
        int id = 0;

        return id;
    }

    private void showBoard() {
        board.show();

    }

    private void welcome() {
        System.out.println("Welcome to DuckRace!");
    }
}
