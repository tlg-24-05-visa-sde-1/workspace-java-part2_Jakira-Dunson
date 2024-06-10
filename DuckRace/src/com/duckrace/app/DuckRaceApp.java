package com.duckrace.app;

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Scanner;

/*
 * Application Controller.
 * Directs overall flow of the applications and prompts the user for inputs.
 * Will add those inputs innto the system.
 */

public class DuckRaceApp {
    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForRewrd();
        board.updateBoard(id, reward);
        showBoard();


    }

    private Reward promptForRewrd() {
        Reward reward = null;

        boolean validInput = false;
        while (!validInput){
            System.out.print("Please enter a [D]ebit card or [P]rizes: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("D|P")) {
                validInput = true;
                //ternary (Condition, True value
                //the false value
                //reward = (input.equals("D")) ? DEBIT_CARD : PRIZES;
            }
            if (input.equals("D")) {
                reward = Reward.DEBIT_CARD;
            } else {
                reward = Reward.PRIZES;
            }
        }
        return reward;
    }

    private int promptForId() {
        int id = 0;

        boolean validIput = false;
        while (!validIput) {
            System.out.println("Please enter a valid ID [1-16]");
            String input = scanner.nextLine();
            if (input.matches("\\d{1,2}")) { //any digit, one or two times
                id = Integer.parseInt(input);
                if(id >=1 && id <= 16){
                    validIput = true;
                }
            }
        }
        return id;
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println("Welcome to DuckRace!");
    }
}
