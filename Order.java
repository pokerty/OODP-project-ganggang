import java.util.ArrayList;
import java.util.Calendar;

public class Order {
    private int tableNumber;
    private String timeStamp;
    private ArrayList<MenuItems> orderItems;
    private ArrayList<PromotionalSet> promoItems;
    private boolean isMember;
    private Staff staff;

    public Order(int tableNumber, boolean isMember, Staff staff){
        this.tableNumber = tableNumber;
        this.timeStamp = Time.now();
        ArrayList<MenuItems> orderArrayList = new ArrayList<MenuItems>;
        this.orderItems = orderArrayList;
        this.isMember = isMember;
        this.staff = staff;
    }

    //get and set functions
    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public ArrayList<PromotionalSet> getPromoItems() {
        return promoItems;
    }
    public ArrayList<MenuItems> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(ArrayList<MenuItems> orderItems, MenuItems menuItems) {
        orderItems.add(menuItems);
    }
    public void removeOrderItems(ArrayList<MenuItems> orderItems, MenuItems menuItems) {
        orderItems.remove(menuItems);
    }

    public Staff getStaff() {
        return staff;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public boolean getMember() {
        return isMember;
    }
    public void setMember(boolean member) {
        isMember = member;
    }
}