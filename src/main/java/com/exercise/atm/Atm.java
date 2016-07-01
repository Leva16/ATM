package com.exercise.atm;

import java.util.*;

public class Atm {
    public static void main(String args[]) throws Exception {

        Map<Integer,Integer> map = new TreeMap<>();
        map.put(20, 100);
        map.put(500, 3);
        map.put(100,1);
        map.put(200,1);
        map.put(50,1);

        ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
        readPropertiesFile.setPropValues(map);

        Dispenser atm = new Dispenser();

        System.out.println(atm.atmCashSum());

        System.out.println("After take 50");
        atm.withdrawCash(600);
        System.out.println(atm.atmCashSum());
        atm.setCash();
        Map<Integer, Integer> nmap = new TreeMap<>(atm.getCash());
        for (Map.Entry<Integer, Integer> entry : nmap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println(nmap.size());
    }
}
