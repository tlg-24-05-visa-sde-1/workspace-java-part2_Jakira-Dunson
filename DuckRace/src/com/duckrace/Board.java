package com.duckrace;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 *
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 *
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board {
    private static final String DATA_FILE_PATH = "DuckRace/data/board.dat";
    private static final String STUDENT_ID_FILE_PATH = "DuckRace/conf/student-ids.csv";
    /*
     * Read from binary file data/ board.dat or create new board (if file is not there)
     * NOTE: new Board object is created only when the first time the app is run
     */

    public static Board getInstance() {
        Board board = null;
        if(Files.exists(Path.of(DATA_FILE_PATH) )){
            try (ObjectInputStream in = new ObjectInputStream
                    (Files.newInputStream(Path.of(DATA_FILE_PATH)))){
                board = (Board) in.readObject();

            } catch (Exception e){
                e.printStackTrace();
            }

        }else { //only happens the first time
            board = new Board();
        }
        return board;
    }
    /*
    * Writes 'this' Board object to binary file data/board.dat
    * In more detail, we are using Java's built-in Object Serialization facility
    * to write the state of this object to the file
    */

    private void save(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))){
            out.writeObject(this); //write 'me' (I am the board object) to the file (as dust)

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private final Map<Integer, String> studentIdMap = loadStudentIdMap();
    private final Map<Integer, DuckRacer> racerMap = new TreeMap<>();
    /*
     * Updates the board (racerMap) by making a DuckRacer win.
     * This could mean fetvhing an existing DuckRacer form racerMap,
     * or we might need to  creat a new DuckRacer, put it in the map,
     * and then make it win.
     */

    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) {  // fetch existing DuckRacer
            racer = racerMap.get(id);
        } else {                           // create new DuckRacer
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);     // easy to forget this step
        }
        racer.win(reward);
    }

    public void show() {
        if (racerMap.isEmpty()) {
            System.out.println("No results to show");
        } else {
            Collection<DuckRacer> racers = racerMap.values();
            for (DuckRacer duckRacer : racers) {
                System.out.println(duckRacer);
            }
        }
    }

    public void updateBoard(int id, Reward reward) {
        if (racerMap.containsKey(id)) { //fetch existing DuckRacer
            DuckRacer duckRacer = racerMap.get(id);
            duckRacer.win(reward);
        } else { // creates a new DuckRacer
            DuckRacer racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
            racer.win(reward);
        }
    }

    //TESTING PURPOSES  ONLY
    void dumpRacerMap() {
        System.out.println(racerMap);
    }

    //TESTING PURPOSES ONLY
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }
    /*
     * This show the data to the human user
     * We need to show the right side of the map, ideally in an attractive way.
     */

    /*
     * Populates studentIdMap from file conf/student-ids.csv
     */

    public Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(STUDENT_ID_FILE_PATH));
            /*
             *For each line (string), we need go split it into 'tokens' based on the comma
             * 1,Amir
             */
            for (String line : lines) {
                String[] tokens = line.split(",");
//                //return from the array ["1","Amir"]
//                Integer studentId = Integer.parseInt(tokens[0]);
//                String studentName = tokens[1];
                //putting into idMap and put it back to those who called
                idMap.put(Integer.parseInt(tokens[0]), tokens[1]); //one line, shorter, clean code
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idMap;
    }

}