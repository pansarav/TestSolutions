package com.amdocs.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMerge implements Runnable {

    private static List<Map> globalList = new ArrayList<>();
    private List<Map> listOfMaps;

    private MapMerge(List<Map> list){
        this.listOfMaps = list;
    }

    private List getListOfMaps() {
        return listOfMaps;
    }

    public static void main(String[] args) {
        List<Map> list1 = new ArrayList<>();
        Map map1 = new HashMap<>();
        map1.put("key1", 30);
        map1.put("key2", 30);
        map1.put("key3", "30");

        Map map2 = new HashMap<>();
        map2.put("key1", 990);
        map2.put("key3", "30");

        list1.add(map1);
        list1.add(map2);

        List<Map> list2 = new ArrayList<>();
        Map map3 = new HashMap<>();
        map3.put(1, "30");
        map3.put(2, "30");
        map3.put(3, "30");

        Map map4 = new HashMap<>();
        map4.put(1, "990");
        map4.put(4, "30");

        list2.add(map1);
        list2.add(map2);
        list2.add(map3);
        list2.add(map4);

        long startTime = System.currentTimeMillis();

        Runnable thread1 = new MapMerge(list1);
        Runnable thread2 = new MapMerge(list2);

        thread1.run();
        thread2.run();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using threads - " + (endTime-startTime));

        System.out.println(processList(globalList));
    }

    @Override
    public void run() {
        globalList.addAll(processList(this.getListOfMaps()));
        System.out.println("globallist - " + globalList);
    }

    private static List<Map> processList(List<Map> list) {
        if (list.size() == 2) {
            list.set(0, mapMerge((Map) list.get(0), (Map) list.get(1)));
            list.remove(1);
        } else if (list.size() > 2) {
            while (list.size() != 1) {
                processList(list.subList(0, 2));
            }
        }
        return list;
    }

    private static Map mapMerge(Map map1, Map map2) {
        if (!isEmpty(map1) && isEmpty(map2)) {
            return map1;
        } else if (!isEmpty(map2) && isEmpty(map1)) {
            return map2;
        } else if (!isEmpty(map1) && !isEmpty(map2)) {
            if (map1.size() < map2.size()) {
                return merge(map1, map2);
            } else {
                return merge(map2, map1);
            }
        }
        return null;
    }

    private static Map merge(Map mapOne, Map mapTwo) {
        Map mergedMap = new HashMap(mapTwo);

        mapOne.forEach((k, v) -> {
            Object value = mergedMap.get(k);
            if (mergedMap.containsKey(k) && v instanceof Integer && value instanceof Integer) {
                mergedMap.put(k, (Integer) v + (Integer) value);
            } else if (mergedMap.containsKey(k) && v instanceof String && value instanceof String) {
                mergedMap.put(k, (String) v + (String) value);
            } else {
                mergedMap.put(k, v);
            }
        });

        return mergedMap;
    }

    private static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

}
