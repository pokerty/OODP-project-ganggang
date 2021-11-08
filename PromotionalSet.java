package oodpassignment;

import java.util.*;

/**
 * 
 * @author hong po 
 * @version 1.0 
 * @since 07/11/2021 
 *
 */
public class PromotionalSet {
	/**
	 * the promotional set's ID 
	 */
    private int setId;  //caps set for promoset
    /**
     * the promotional set's name 
     */
    private String setName;
    /**
     * the promotional set's description
     */
    private String setDescription;
    /**
     * the promotional set's price 
     */
    private float setPrice;
    /**
     * the promotional set's list of menu items that make up the promotional set 
     */
    private ArrayList<MenuItems> setItems;

    /**
     * creates the promotional set according to its attributes 
     * @param SetId
     * @param SetName
     * @param SetDescription
     * @param SetPrice
     * @param SetItems
     */
    public PromotionalSet(int SetId, String SetName, String SetDescription, float SetPrice, ArrayList<MenuItems> SetItems){
        this.setId =SetId;
        this.setName = SetName;
        this.setDescription = SetDescription;
        this.setPrice = SetPrice;
        this.setItems = SetItems; 
    }
    /**
     * getter method for the promotional set's ID 
     * @return
     */
    public int getID(){
        return this.setId;
    }
    /**
     * setter method for the promotional set's ID 
     * @param SetId
     */
    public void setID(int SetId){
        this.setId = SetId; //small letter set for method
    }
    
/**
 * getter method for the promotional set's name 
 * @return
 */
    public String getName(){
        return this.setName;
    }
    /**
     * setter method for the promotional set's name 
     * @param SetName
     */
    public void setName(String SetName){
        this.setName = SetName;
    }

    /**
     * getter method for the description of the promotional set 
     * @return
     */
    public String getDescription(){
        return this.setDescription;
    }
    /**
     * the setter method for the description of the promotional set 
     * @param SetDescription
     */
    public void setDescription(String SetDescription){
        this.setDescription = SetDescription;
    }

    /**
     * getter method for the price of the promotional set 
     * @return
     */
    public float getPrice(){
        return this.setPrice;
    }
    /**
     * setter method for the price of the promotional set 
     * @param SetPrice
     */
    public void setPrice(float SetPrice){
        this.setPrice = SetPrice;
    }
/**
 * The collection of menu items that make up the promotional set 
 * @return the array list of menu items that make up the promotional set 
 */
    public ArrayList<MenuItems> getMenuItems(){
        return this.setItems;
    }
/**
 * adds an additional menu item to the promotional set by adding the item to the collection of menu items that
 * make up the promotional set 
 * @param item
 */
    public void addItemsToSet(MenuItems item){
        setItems.add(item);
    }

    /**
     * removes a chosen menu item from the promotional set via the menu item ID 
     * @param id
     */
    public void removeItemsFromSet(int id){
        for (int i=0; i<setItems.size(); i++){
            if (setItems.get(i).getID()==id){
                setItems.remove(i);
            }
        }
    }
    
}