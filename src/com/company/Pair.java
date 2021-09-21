package com.company;

public class Pair {
    private Object key;
    private Object value;

    Pair(Object key){
        this.key=key;
        this.value = 0;
    }
    Pair(Object key, Object value){
        this.key=key;
        this.value = value;
    }
    Object getKey(){
        return key;
    }

    Object getValue(){
        return this.value;
    }

    void setValue(Object newValue){
        this.value= value;
    }

    void setKey(Object newKey){
        this.key=newKey;
    }

    void set(Object key, Object value){
        this.key=key;
        this.value = value;
    }

    boolean equal(Object key){
        return this.key == key;
    }


}
