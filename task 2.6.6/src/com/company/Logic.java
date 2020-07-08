package com.company;

import ru.vsu.cs.util.SimpleBSTree;
import ru.vsu.cs.util.SimpleBSTreeMap;

import java.util.*;

public class Logic {

    public static String findPairString(String string, int s) {
        return TreeToString(findPair(splitToInt(string), s));
    }

    public static SimpleBSTree<Pair> findPair(int[] array, int s){
        SimpleBSTreeMap<Integer, Integer> treeMap = new SimpleBSTreeMap<>();
        for (int value : array) {
            if(treeMap.get(value) == null)treeMap.put(value, 1);
            else{
                int x = treeMap.get(value);
                x++;
                treeMap.put(value, x);
            }
        }
        SimpleBSTree<Pair> answer = new SimpleBSTree<>();
        for (int key :
                treeMap.keySet()) {
            if(key * 2 == s && treeMap.get(key) > 1){
                answer.put(new Pair(key, key));
            }
            else if(treeMap.containsKey(s - key) && key * 2 != s){
                answer.put(new Pair(key, s - key));
            }
        }
        return answer;
    }

    private static String TreeToString(SimpleBSTree<Pair> pairs){
        StringBuilder result = new StringBuilder("PAIR \n");
        for (Pair p : pairs) {
            result.append("(").append(p.getFirst()).append(", ").append(p.getSecond()).append(")\n");
        }
        return result.toString();
    }
    private static int[] splitToInt(String text){
        String[] newText = text.split("[.!?,; ]");
        ArrayList list = new ArrayList();
        Collections.addAll(list, newText);
        for (int i = 0; i < list.size(); i++) {
            String s = (String) list.get(i);
            s = s.replaceAll("\n", " ");
            s = s.trim();
            if(s.equals("")){
                list.remove(i);
                i--;
                continue;
            }
            list.remove(i);
            list.add(i, s);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt((String) list.get(i));
        }
        return res;
    }

    }
