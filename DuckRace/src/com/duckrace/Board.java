package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    /*
     * Updates the board (racerMap) by making a DuckRacer win.
     * This could mean fetvhing an existing DuckRacer form racerMap,
     * or we might need to  creat a new DuckRacer, put it in the map,
     * and then make it win.
     */
    public void updateBoard(int id, Reward reward){
        if (racerMap.containsKey(id)){ //fetch existing DuckRacer
            DuckRacer duckRacer = racerMap.get(id);
            duckRacer.win(reward);
        } else { // creates a new DuckRacer
            DuckRacer racer = new DuckRacer(id,studentIdMap.get(id));
            racerMap.put(id,racer);
            racer.win(reward);
        }
    }
    //TESTING PURPOSES  ONLY
    void dumpRacerMap(){
        System.out.println(racerMap);
    }


    //TESTING PURPOSES ONLY
    void dumpStudentIdMap(){
        System.out.println(studentIdMap);
    }
    /*
    * Populates studentIdMap from file conf/student-ids.csv
    */

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("DuckRace/conf/student-ids.csv"));
            /*
             *For each line (string), we need go split it into 'tokens' based on the comma
             * 1,Amir
             */
            for (String line : lines){
                String[] tokens = line.split(",");
//                //return from the array ["1","Amir"]
//                Integer studentId = Integer.parseInt(tokens[0]);
//                String studentName = tokens[1];
                //putting into idMap and put it back to those who called
                idMap.put(Integer.parseInt(tokens[0]),tokens[1]); //one line, shorter, clean code
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return idMap;
    }

}