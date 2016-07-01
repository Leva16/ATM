package com.exercise.atm;

import java.io.IOException;
import java.util.*;
import java.lang.Exception;

public class Dispenser {
    //Map<Integer, Integer> denom = new TreeMap<>();

    ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();

    private Map<Integer, Integer> cash = new TreeMap();

    Dispenser () {
        setCash();
    }

    public void setCash() {
        try {
            this.cash = readPropertiesFile.getPropValues();
        } catch (IOException e) {
            System.err.println("Error in ReadPropertiesFile class.");
        }
    }

    public Map<Integer, Integer> getCash() {
        return cash;
    }

    public int atmCashSum() {
        Map<Integer, Integer> money = new TreeMap<>();
        try {
            money = readPropertiesFile.getPropValues();
        } catch (IOException e) {
            System.err.println("Error in ReadPropertiesFile class.");
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : money.entrySet()) {
            sum += (entry.getKey() * entry.getValue());
        }
        return sum;
    }

    public boolean atmCashAvailable(int needCash) {
        return needCash <= atmCashSum();
    }

    public void addAtmCash(int denomination, int count){
        cash.put(denomination,count);
    }

    public boolean atmHasCash(){
        return cash.size() != 0;
    }

    public Map<Integer, Integer> withdrawCash(int expectedAmount)  {

        int sum = expectedAmount;
        HashMap <Integer, Integer> temp = new HashMap<>();
        temp.putAll(cash);

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            list.add(pair.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        for (Integer aList : list) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            System.out.println("No money");
        else
        {
            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                System.out.println("\t" + pair.getKey() + " - " + pair.getValue());

            cash.clear();
            cash.putAll(temp);
            System.out.println("Transaction complete successfully");
        }
        try {
            readPropertiesFile.setPropValues(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
