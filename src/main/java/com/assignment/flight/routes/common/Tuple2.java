package com.assignment.flight.routes.common;

public class Tuple2<K, V> {

    K k;
    V v;

    public Tuple2(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK(){
        return k;
    }
    public  V getV(){
        return v;
    }
}

