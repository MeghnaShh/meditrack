package com.airtribe.meditrack.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore<T> {

    private Map<Integer, T> storage= new HashMap<>();

    public void addData(int id, T data){
        storage.put(id, data);
    }

    public T getData(int id){
        return storage.get(id);
    }

    public List<T> getAllData(){
        return new ArrayList<>(storage.values());
    }

    public void remove(int id){
        storage.remove(id);
    }
    public boolean contains(int id){
        return storage.containsKey(id);
    }
}
