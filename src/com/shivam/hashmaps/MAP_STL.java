package com.shivam.hashmaps;

import java.util.HashMap;

public class MAP_STL {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Shivam", 20); /// add
        map.put("Raghava", 25);
        map.put("Vivek", 29);
        map.put("Haaland", 25);

        System.out.println(map + " size: " + map.size());

        System.out.println(map.remove("Vivek")); /// removed

        System.out.println(map.get("Raghava"));

        map.put("Raghava", 20); /// will replace previous thing entirely, adding this thing.

        System.out.println(map + " size: " + map.size());


        System.out.println(map.containsKey("Vivek")); /// check is this key there ?

        /// 🌟🌟 Traverse over Map => key wise Traversal
        for(String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
