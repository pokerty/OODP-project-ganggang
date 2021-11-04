import java.util.ArrayList;

public class Report {
    //period in day(s)
    private int period;
    private ArrayList<Order> saleItems;
    private float revenue;

    public ArrayList<Order> getSaleItems() {
        return saleItems;
    }
    public void setSaleItems(ArrayList<Order> saleItems) {
        this.saleItems = saleItems;
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
