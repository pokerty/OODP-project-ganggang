package oodpassignment;

import java.util.*;


public class PromotionalSet {
    private int SetId;  //caps set for promoset
    private String SetName;
    private String SetDescription;
    private float SetPrice;
    private ArrayList<MenuItems> SetItems;

    public PromotionalSet(int SetId, String SetName, String SetDescription, float SetPrice, ArrayList<MenuItems> SetItems){
        this.SetId =SetId;
        this.SetName = SetName;
        this.SetDescription = SetDescription;
        this.SetPrice = SetPrice;
        this.SetItems = SetItems; 
    }
    public int getID(){
        return this.SetId;
    }
    public void setID(int SetId){
        this.SetId = SetId; //small letter set for method
    }

    public String getName(){
        return this.SetName;
    }
    public void setName(String SetName){
        this.SetName = SetName;
    }

    public String getDescription(){
        return this.SetDescription;
    }
    public void setDescription(String SetDescription){
        this.SetDescription = SetDescription;
    }

    public float getPrice(){
        return this.SetPrice;
    }
    public void setPrice(float SetPrice){
        this.SetPrice = SetPrice;
    }

    public ArrayList<MenuItems> getMenuItems(){
        return this.SetItems;
    }

    public void addItemsToSet(MenuItems item){
        SetItems.add(item);
    }

    public void removeItemsFromSet(int id){
        for (int i=0; i<SetItems.size(); i++){
            if (SetItems.get(i).getID()==id){
                SetItems.remove(i);
            }
        }
    }
    
}