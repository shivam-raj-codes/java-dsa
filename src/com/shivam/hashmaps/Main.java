package com.shivam.hashmaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        String name = "Shivam";
//
//        int code = name.hashCode();
//        System.out.println(code);

        HashMap<String, Integer> map = new HashMap<>();

        map.put("Kunal", 89);
        map.put("Shivam", 99);
        map.put("Rahul", 78);

        System.out.println(map.get("Shivam"));
//        System.out.println(map.getOrDefault("appu", 34));

        System.out.println(map.containsKey("Shivam"));


        ///  will only contains unique value
        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(5);
        set.add(6);
        set.add(96);
        set.add(56);
        set.add(12);

        System.out.println(set);


        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(56, "A");
        treeMap.put(5, "B");
        treeMap.put(6, "C");
        treeMap.put(96, "D");
        treeMap.put(12, "E");

        System.out.println(treeMap);
    }
}

/*
  Note: -->
  HashMap vs Hashtable :---
  HashMap is not Synchronized => Not Thread Safe & can't be shared b/w many thread
  whereAs, HashTable is Synchronized.

  HashMap allow one Null - Key and Multiples Null - values.
  HashTable doesn't allow any Null - key or Value.

  🌟HashMap  prefers over HashTable if No Synchronization needed.

 */

  /// Why HashTable doesn't allow Null and HashMap does ?
  /// Because, if U want to successfully store and retrieve "OBJECTS" from a HashTable the "OBJECTS" used as KEYS must
  ///implement HashCode-method & the equals-method. Since, NULL is not an OBJECT it cannot IMPLEMENT these methods
  /// HAshMap is Advance Version & improvement of HashTAble