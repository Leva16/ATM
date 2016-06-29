package com.exercise.atm;

import com.exercise.atm.Dispenser;

import java.util.LinkedHashMap;
import java.util.Map;

public class Atm {
    public static void main(String args[]) {
        Dispenser atm = new Dispenser();
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        map.put(20, 13);
        map.put(50, 9);
        map.put(100, 15);
        map.put(200, 11);
        map.put(500, 7);
        atm.setDispenser(map);
        //System.out.println(atm.atmSum());
        ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
        try {
            System.out.println(readPropertiesFile.getPropValues());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
