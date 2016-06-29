package com.exercise.atm;

import java.util.*;
import java.io.*;
import java.lang.Exception;

public class Dispenser {

    ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
    private Map<Integer, Integer> cash = new TreeMap();
    public void setCash() throws Exception{
        this.cash = readPropertiesFile.getPropValues();
    }

    private List<Notes> notes = new ArrayList<Notes>();

    public void setNotes(List<Notes> notes) throws Exception{
        setCash();
        for (Map.Entry<Integer, Integer> entry : cash.entrySet()) {
            notes.add(new Notes(entry.getKey(), entry.getValue()));
        }

        this.notes = notes;
    }

    private Map<Integer, Integer> dispenser = new LinkedHashMap<Integer, Integer>();
    public Map<Integer, Integer> getDispenser() {
        return dispenser;
    }

    public void setDispenser(Map<Integer, Integer> dispenser) {
        this.dispenser = dispenser;
    }

    /**
     *
     * @atmSum
     * returm amount of money in ATM.
     */
    public int atmSum() throws Exception {
        Map<Integer, Integer> money = readPropertiesFile.getPropValues();
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : money.entrySet()) {
            sum += (entry.getKey() * entry.getValue());
        }
        return sum;
    }

}
