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
        SetItems = new ArrayList<MenuItems>();
    }
    
    /** 
     * to get promoset id
     * @return int
     */
    public int getID(){
        return this.SetId;
    }
    
    /** 
     * to change promoset id
     * @param SetId
     */
    public void setID(int SetId){
        this.SetId = SetId; //small letter set for method
    }

    
    /** 
     * to get promoset name
     * @return String
     */
    public String getName(){
        return this.SetName;
    }
    
    /** 
     * to change promoset name
     * @param SetName
     */
    public void setName(String SetName){
        this.SetName = SetName;
    }

    
    /** 
     * to get promoset description
     * @return String
     */
    public String getDescription(){
        return this.SetDescription;
    }
    
    /** 
     * to change promoset description
     * @param SetDescription
     */
    public void setDescription(String SetDescription){
        this.SetDescription = SetDescription;
    }

    
    /** 
     * to get promoset price
     * @return float
     */
    public float getPrice(){
        return this.SetPrice;
    }
    
    /** 
     * to change promoset price
     * @param SetPrice
     */
    public void setPrice(float SetPrice){
        this.SetPrice = SetPrice;
    }

    
    /** 
     * to return the list of menuitems inside the promoset
     * @return ArrayList<MenuItems>
     */
    public ArrayList<MenuItems> getMenuItems(){
        return this.SetItems;
    }

    
    /** 
     * to add a menuitem into the promoset
     * @param item
     */
    public void addItemToSet(MenuItems item){
        SetItems.add(item);
    }

    
    /** 
     * to remove a menuitem from the promoset
     * @param id
     */
    public void removeItemFromSet(int id){
        for (int i=0; i<SetItems.size(); i++){
            if (SetItems.get(i).getID()==id){
                SetItems.remove(i);
            }
        }
    }
    
}