package com.duckrace;

public class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();
        //board.dumpStudentIdMap();

        board.updateBoard(2,Reward.DEBIT_CARD);
        board.updateBoard(3,Reward.PRIZES);
        board.updateBoard(4,Reward.DEBIT_CARD);
        board.updateBoard(9,Reward.PRIZES);

        board.dumpRacerMap();

        board.show();
    }
}
