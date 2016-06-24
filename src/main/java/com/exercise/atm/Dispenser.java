package com.exercise.atm;

import java.util.*;

public class Dispenser {
    private Map<Integer, Integer> dispenser = new LinkedHashMap<Integer, Integer>();

    public static List<Integer> list = new ArrayList<Integer>();
    Notes A20 = new Notes(20, 13);



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
    public int atmSum() {
        int sum = 0;
        for (Map.Entry entry : getDispenser().entrySet()) {
            sum += ((Integer) entry.getKey() * (Integer) entry.getValue());
        }
        return sum;
    }

}
