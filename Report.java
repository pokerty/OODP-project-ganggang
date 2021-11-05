package oodpassignment;

import java.util.ArrayList;

public class Report {
    //period in day(s)
    private int period;
    private ArrayList<MenuItems> menuItemsOrdered;
    private ArrayList<PromotionalSet> promoItemsOrdered;
    private float revenue;

    public Report(int period, ArrayList<Order> orderArray, ArrayList<MenuItems> menuItemsOrdered, ArrayList<PromotionalSet> promoItemsOrdered){
        this.period = period;
        this.menuItemsOrdered = menuItemsOrdered;
        this.promoItemsOrdered = promoItemsOrdered;
        this.revenue = revenue;
    }

    public ArrayList<MenuItems> getMenuItemsOrdered() {
        return menuItemsOrdered;
    }

    public void setMenuItemsOrdered(ArrayList<MenuItems> menuItemsOrdered) {
        menuItemsOrdered = menuItemsOrdered;
    }

    public ArrayList<PromotionalSet> getPromoItemsOrdered() {
        return promoItemsOrdered;
    }
    public void setPromoItemsOrdered(ArrayList<PromotionalSet> promoItemsOrdered) {
        promoItemsOrdered = promoItemsOrdered;
    }

    public float getRevenue() {
        return revenue;
    }
    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public int getPeriod() {
        return period;
    }
    public void setPeriod(int period) {
        this.period = period;
    }

}