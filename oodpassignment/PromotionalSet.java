package oodpassignment;

import java.util.*;

import oodpassignment.MenuItems;

/**
 * Promotional set is the entity class that stores the data of promotional sets
 * such as the ID, name, description, price and the menu items that is included
 * in the promotional set
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
    private int setId; // caps set for promoset
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
     * 
     * @param SetId          ID of promo set
     * @param SetName        name of promo set
     * @param SetDescription description of promo set
     * @param SetPrice       price of promo set
     * @param SetItems       the set of items that make up promo set (an array list)
     */
    public PromotionalSet(int SetId, String SetName, String SetDescription, float SetPrice,
            ArrayList<MenuItems> SetItems) {
        this.setId = SetId;
        this.setName = SetName;
        this.setDescription = SetDescription;
        this.setPrice = SetPrice;
        this.setItems = SetItems;
    }

    /**
     * getter method for the promotional set's ID
     * 
     * @return return ID of promo set
     */
    public int getID() {
        return this.setId;
    }

    /**
     * setter method for the promotional set's ID
     * 
     * @param setId the ID you want the promo set to have
     */
    public void setID(int setId) {
        this.setId = setId; // small letter set for method
    }

    /**
     * getter method for the promotional set's name
     * 
     * @return returns the promo set's name
     */
    public String getName() {
        return this.setName;
    }

    /**
     * setter method for the promotional set's name
     * 
     * @param setName the name you want to set the promo set to have
     */
    public void setName(String setName) {
        this.setName = setName;
    }

    /**
     * getter method for the description of the promotional set
     * 
     * @return the description of the promo set
     */
    public String getDescription() {
        return this.setDescription;
    }

    /**
     * the setter method for the description of the promotional set
     * 
     * @param setDescription the description you want the promo set to have
     */
    public void setDescription(String setDescription) {
        this.setDescription = setDescription;
    }

    /**
     * getter method for the price of the promotional set
     * 
     * @return the price of the promo set
     */
    public float getPrice() {
        return this.setPrice;
    }

    /**
     * setter method for the price of the promotional set
     * 
     * @param setPrice the price you want the promo set to have
     */
    public void setPrice(float setPrice) {
        this.setPrice = setPrice;
    }

    /**
     * The collection of menu items that make up the promotional set
     * 
     * @return the array list of menu items that make up the promotional set
     */
    public ArrayList<MenuItems> getMenuItems() {
        return this.setItems;
    }

    /**
     * adds an additional menu item to the promotional set by adding the item to the
     * collection of menu items that make up the promotional set
     * 
     * @param item the menu item you want to add to the promo set
     */
    public void addItemsToSet(MenuItems item) {
        setItems.add(item);
    }

    /**
     * removes a chosen menu item from the promotional set via the menu item ID
     * 
     * @param id the id of the item you want to remove
     */
    public void removeItemsFromSet(int id) {
        for (int i = 0; i < setItems.size(); i++) {
            if (setItems.get(i).getID() == id) {
                setItems.remove(i);
            }
        }
    }

}
