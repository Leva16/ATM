package com.exercise.atm;

import com.exercise.atm.Dispenser;

import java.util.*;

public class Atm {
    public static void main(String args[]) throws Exception {


        List<Notes> notes = new ArrayList<Notes>();

        Dispenser atm = new Dispenser();

        System.out.println(atm.atmSum());

    }
}
