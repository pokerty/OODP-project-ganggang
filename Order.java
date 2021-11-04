import java.lang.reflect.Array;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private int tableNum;
    private String timeStamp;
    private ArrayList<MenuItems> orderItems;
    private boolean isMember;
    private Staff staff;

    public Order(int orderID, int tableNum, ArrayList<MenuItems> orderItems, boolean isMember, Staff staff){
        this.orderID = orderID;
        this.tableNum = tableNum;
        this.timeStamp = "/current time";
        this.orderItems = orderItems;
        this.isMember = isMember;
        this.staff = staff;
    }



    //get and set functions

    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTableNum() {
        return tableNum;
    }
    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public String getTimeStamp() {
        return timeStamp;
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