package com.example.ben.fitordie.Login;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * Logbook class
 */

public class LogBook {
    private ArrayList<Log> logList = new ArrayList<Log>();
    private String logData = "logs.ser";


    public boolean loadDatabase() throws Exception {

        // load file if it exists
        try {
            FileInputStream inFile = new FileInputStream(logData);
            ObjectInputStream in = new ObjectInputStream(inFile);
            logList = (ArrayList) in.readObject();
            in.close();
            inFile.close();
            return true;

        } catch (Exception ex) {
            refreshDatabase();
            return true;
        }
    }


    // return the data structure
    public ArrayList<Log> getLogBook() {
        return logList;
    }

    public void refreshDatabase() throws Exception {
        // iterate through logList
        FileOutputStream outFile = new FileOutputStream(logData);
        ObjectOutputStream out = new ObjectOutputStream(outFile);
        out.writeObject(logList);
        out.close();
        outFile.close();
    }

    // search for a log by its date
    // this will help us auto-fill our form in the app
    public int searchByDate(Date date) {

        // local variables to help
        boolean found = false;
        int index = 0;


        for (Log log : logList) {
            if (date.equals(log.getDate())) {
                found = true;
                break;
            }
            index++;

        }
        // output
        if (!found) {
            index = -1; // return -1 if not found.
        }

        return index;
    }
}