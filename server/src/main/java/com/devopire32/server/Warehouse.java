package com.devopire32.server;

public class Warehouse {
    public boolean hasInventory(String name, int quantity){
        if(name.isEmpty()||quantity<=0){return false;}
        return true;
    }

    public String remove(String name, int quantity){
        return "Removed";
    }
}
