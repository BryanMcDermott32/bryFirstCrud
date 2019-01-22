package com.devopire32.server;

public class SampleClassToTestSpock {


    public SampleClassToTestSpock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOrderFilled() {
        return orderFilled;
    }

    public void setOrderFilled(boolean orderFilled) {
        this.orderFilled = orderFilled;
    }

    private String name;
    private int quantity;
    private boolean orderFilled;
    public boolean isEqualToOne(int a){
        if(a==1){return true;}
        return false;
    }

    void fill(Warehouse warehouse){
        if(warehouse.hasInventory(name, quantity)){
            warehouse.remove(name,quantity);
            orderFilled=true;
        }
    }
}
