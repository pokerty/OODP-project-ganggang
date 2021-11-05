import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReportLogic {
    private float totalRevenue;
    private float promoRevenue;
    private float alaCarteRevenue;

    public void ReportLogic(float totalRevenue, float promoRevenue, float alaCarteRevenue){
        this.totalRevenue = totalRevenue;
        this.promoRevenue = promoRevenue;
        this.alaCarteRevenue= alaCarteRevenue;
    }

    public float calculateTotalRevenue(Report report){
        totalRevenue = calculateAlaCateRevenue(report) + calculateSetPromoRevenue(report);
        return totalRevenue;
    }

    public float calculateSetPromoRevenue(Report report){
        promoRevenue = 0;
        for(int i=0; i<report.getPromoItemsOrdered().size(); i++){
            promoRevenue += report.getPromoItemsOrdered().get(i).GetPrice(); //syntax change to getPrice() in PromoionalSet.java?
        }
        return promoRevenue;
    }
    public float calculateAlaCateRevenue(Report report){
        alaCarteRevenue = 0;
        for(int i=0; i<report.getMenuItemsOrdered().size(); i++){
            promoRevenue += report.getMenuItemsOrdered().get(i).getPrice();
        }
        return alaCarteRevenue;
    }
    public void showSetPromo(Report report){
        System.out.println("Promotional Set Items sold: ");
        for(int i = 0; i<report.getPromoItemsOrdered().size(); i++){
            System.out.println(report.getPromoItemsOrdered().get(i).GetName() + " " + report.getPromoItemsOrdered().get(i).GetPrice());
        }
    }
    public void showAlaCarte(Report report){
        System.out.println("Ala Carte Items Sold: ");
        for (int i = 0; i<report.getMenuItemsOrdered().size(); i++){
            System.out.println(report.getMenuItemsOrdered().get(i).getName() + " " + report.getMenuItemsOrdered().get(i).getPrice());
        }
    }
    public void showAll(Report report){
        System.out.println("All Items Sold: ");
        for(int i = 0; i<report.getPromoItemsOrdered().size(); i++){
            System.out.println(report.getPromoItemsOrdered().get(i).GetName() + " " + report.getPromoItemsOrdered().get(i).GetPrice());
        }
        for (int i = 0; i<report.getMenuItemsOrdered().size(); i++){
            System.out.println(report.getMenuItemsOrdered().get(i).getName() + " " + report.getMenuItemsOrdered().get(i).getPrice());
        }
    }

    private void loadReport() {
        try {
            int ID;
            float price;
            String name;
            //category and promo set
            coursetype category;
            FileReader reservationList = new FileReader("reservationList.txt");
            BufferedReader reader = new BufferedReader(reservationList);
            ArrayList<String> list = new ArrayList<String>();
            String info = reader.readLine();
            while (info != null) {
                list.add(info.replace("empty_string", ""));
                info = reader.readLine();
            }
            int i = 0;
            while (i < list.size()) {
                name = list.get(i);
                price = Float.parseFloat(list.get(i + 1));
                ID = Integer.parseInt(list.get(i + 2));
                category = coursetype.valueof(list.get(i + 3)); //how to read for promo and menu items enum at the same time??
                i += 9;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private void saveReport(Report report) {
        try {
            FileWriter write = new FileWriter("report.txt");
            @SuppressWarnings("resource")
            BufferedWriter bwrite = new BufferedWriter(write);
            int size = report.getMenuItemsOrdered().size() + report.getPromoItemsOrdered().size();
            for(int i; i<size; i++){
                if(report.getMenuItemsOrdered().get(i) != null){
                    bwrite.write(report.getMenuItemsOrdered().get(i).getName());
                    bwrite.write(Float.toString(report.getMenuItemsOrdered().get(i).getPrice()));
                    bwrite.write(Integer.toString(report.getMenuItemsOrdered().get(i).getID()));
                    bwrite.write((report.getMenuItemsOrdered().get(i).getCategory().name()));
                }
            }
        bwrite.close();

    }
		catch(FileNotFoundException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        }
		catch(IOException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        }
    }
}

