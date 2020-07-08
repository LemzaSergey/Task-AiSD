package com.company;

public class Pair implements Comparable<Pair> {
    private int first;
    private int second;

    Pair (int first, int second){
        this.first = first;
        this.second = second;
    }
    public void add(int first, int second){
        this.first = first;
        this.second = second;
    }
    public int[] get(){
        return new int[] {first, second};
    }
    public int getFirst(){
        return first;
    }
    public int getSecond(){return second;}
    public boolean equals(Pair pair){
        return (first == pair.first && second == pair.second || first == pair.second && second == pair.first);

    }

    @Override
    public int compareTo(Pair pair) {
        if (equals(pair))return 0;
        else if(first - pair.first > 0) return 1;
        else return -1;
    }
}


