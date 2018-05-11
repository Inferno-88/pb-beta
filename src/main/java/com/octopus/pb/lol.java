package com.octopus.pb;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class lol {

    public static void main (String [] args) {

        SortedSet ss = Collections.unmodifiableSortedSet(new TreeSet<>());

        List<Integer> list = new CopyOnWriteArrayList<>();
        list = Arrays.asList(1, 2, 3, 4, 5);

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
//            System.out.println(listIterator.next());
//            System.out.println(listIterator.previous());
//            System.out.println(listIterator.previous());
        }

        for (int i = 0; i < list.size(); i++) {

        }



    }

}
