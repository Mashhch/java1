package com.company;



public class Map {

    MyList Keys = new MyList();
    MyList Values = new MyList();

    Map(Object key, Object value){
        Keys.add(key);
        Values.add(value);
    }

    public void put(Object key, Object value) {
        for (int i = 0; i < Keys.Size(); i++) {
            if ((Keys.get(i) == key)) {
                Values.set(i, value);
                return;
            }
        }
        Keys.add(key);
        Values.add(value);
        return;
    }

    public Object get(Object key) {
        for (int i = 0; i < Keys.Size(); i++) {
            if ((Keys.get(i).equals(key))) {
                return Values.get(i);
            }
        }
        return null;
    }

    public Object get(Object key, Object byDefault) {
        for (int i = 0; i < Keys.Size(); i++) {
            if ((Keys.get(i).equals(key))) {
                return Values.get(i);
            }
        }
        Keys.add(key);
        Values.add(byDefault);
        return byDefault;
    }

    public boolean keyContains(Object key){
        for (int i = 0; i < Keys.Size(); i++) {
            if ((Keys.get(i) == key)) {
                return true;
            }
        }
        return false;
    }

    public Object remove(Object key){
        for (int i = 0; i < Keys.Size(); i++) {
            if ((Keys.get(i)==key)) {
                Object oldValue = Values.get(i);
                Values.remove(i);
                Keys.remove(i);
                return oldValue;
            }
        }
        return 0;
    }

    public MyList getKeys(){
        return Keys;
    }

    public MyList getValues(){
        return Values;
    }

    public int Size(){
        return Keys.Size();
    }

    public boolean isEmpty(){
        return Keys.isEmpty();
    }


    public MyList getEntries(){
        if (Keys.isEmpty()) return null;
        Pair newPair = new Pair(Keys.get(0), Values.get(0));
        MyList PairMyList = new MyList(newPair);
        for(int i =1; i< Keys.Size();i++) {
            newPair.set(Keys.get(i), Values.get(i));
            PairMyList.add(newPair);
        }
        return PairMyList;
    }



    /*MyList<Pair> Keys;


   // boolean existence(Object key){}

    public void put( Object key, Object value){
        for(int i =0; i< Keys.size();i++) {
           if((Keys.get(i).equal(key))){
                Keys.get(i).setValue(value);
                return;
            }
        }
        Pair newValue = new Pair(key, value);
        Keys.add(newValue);
    }
    public Object get( Object key) {
        for (int i = 0; i < Keys.size(); i++) {
            if ((Keys.get(i).equal(key))) {
                return Keys.get(i).getValue();
            }
        }
        Pair newValue = new Pair(key);
        Keys.add(newValue);
        return 0;
    }

    public boolean keyContains(Object key){
        for (int i = 0; i < Keys.size(); i++) {
            if ((Keys.get(i).equal(key))) {
                return true;
            }
        }
        return false;
    }

    public Object remove(Object key){
        for (int i = 0; i < Keys.size(); i++) {
            if ((Keys.get(i).equal(key))) {
                Object value = Keys.get(i).getValue();
                Keys.remove(i);
                return value;
            }
        }
        return 0;
    }

    */
}