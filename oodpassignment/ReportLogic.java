package oodpassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

import oodpassignment.Report;
import oodpassignment.PromotionalSet;
import oodpassignment.Order;
import oodpassignment.MenuItems;
import oodpassignment.MenuItems.courseType;

/**
 * ReportLogic is responsible for the logics behind all functions related to the report (i.e. revenue generated)
 * 
 * @author chang wei
 * @since 07/11/2021
 * @version 1.0
 *
 */

public class ReportLogic {

    /**
     * constructor for the reportlogic object - initialised in main normally
     * 
     * @param report the object that stores all the completed order
     */
    public ReportLogic(Report report) {
        loadReport(report);
        System.out.println("ReportLogic start-up complete.");

    }

    /**
     * calculates the total revenue depending on the time period stated in the
     * boundary class
     * 
     * @param cal the calendar object that stores the date of the completed orders
     * @param report the object that stores all the completed order
     * @return float value corresponding to total revenue
     */
    public float calculateTotalRevenue(Calendar cal, Report report) {
        float totalRevenue = calculateAlaCarteRevenue(cal, report) + calculateSetPromoRevenue(cal, report);
        return totalRevenue;
    }

    /**
     * calculates only the revenue from promotional set items of a specified time
     * frame in the boundary class
     * 
     * @param cal the calendar object that stores the date of the completed orders
     * @param report the object that stores all the completed order
     * @return float value corresponding to revenue from promotional set items
     */
    public float calculateSetPromoRevenue(Calendar cal, Report report) {
        float promoRevenue = 0;
        Date dateandtime = cal.getTime();
        for (int i = 0; i < report.getOrders().size(); i++) {
            for (int j = 0; j < report.getOrders().get(i).getPromoItems().size(); j++) {
                if (dateandtime.before(report.getOrders().get(i).getTimeStamp())) {
                    System.out.println(report.getOrders().get(i).getPromoItems().get(j).getName());
                    promoRevenue += report.getOrders().get(i).getPromoItems().get(j).getPrice();
                }
            }

        }
        return promoRevenue;
    }

    /**
     * calculates revenue from ala carte items according to time frame specified in
     * boundary class
     * 
     * @param cal the calendar object that stores the date of the completed orders
     * @param report the object that stores all the completed order
     * @return float value corresponding to revenue from ala carte items
     */
    public float calculateAlaCarteRevenue(Calendar cal, Report report) {
        float alaCarteRevenue = 0;
        Date dateandtime = cal.getTime();
        for (int i = 0; i < report.getOrders().size(); i++) {
            for (int j = 0; j < report.getOrders().get(i).getOrderItems().size(); j++) {
                if (dateandtime.before(report.getOrders().get(i).getTimeStamp())) {
                    System.out.println(report.getOrders().get(i).getOrderItems().get(j).getName());
                    alaCarteRevenue += report.getOrders().get(i).getOrderItems().get(j).getPrice();
                }

            }
        }
        return alaCarteRevenue;
    }

    /**
     * prints the whole list of promotional set items sold thus far
     * @param report the object that stores all the completed order
     */
    public void showSetPromo(Report report) {
        System.out.println("Promotional Set Items sold: ");
        for (int i = 0; i < report.getOrders().size(); i++) {
            for (int j = 0; j < report.getOrders().get(i).getPromoItems().size(); j++) {
                System.out.println(report.getOrders().get(i).getPromoItems().get(j).getName());
            }
        }
    }

    /**
     * prints the whole list of ala carte items sold thus far
     * @param report the object that stores all the completed order
     */
    public void showAlaCarte(Report report) {
        System.out.println("Ala Carte Items Sold: ");
        for (int i = 0; i < report.getOrders().size(); i++) {
            for (int j = 0; j < report.getOrders().get(i).getOrderItems().size(); j++) {
                System.out.println(report.getOrders().get(i).getOrderItems().get(j).getName());
            }
        }
    }

    /**
     * prints all items sold thus far
     * @param report the object that stores all the completed order
     */
    public void showAll(Report report) {
        showSetPromo(report);
        showAlaCarte(report);
    }

    /**
     * loads the report particulars from the txt database
     * 
     * @param thereport report object to be populated with data from txt file
     */
    public void loadReport(Report thereport) {
        try {
            float price;
            String name;
            int category;

            courseType type;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            FileReader report = new FileReader("Report.txt");
            BufferedReader reader = new BufferedReader(report);
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
                category = Integer.parseInt(list.get(i + 2));
                Calendar cal = Calendar.getInstance();
                cal.setTime(dateFormat.parse(list.get(i + 3)));
                switch (category) {
                case (0):
                    type = courseType.main;
                    break;
                case (1):
                    type = courseType.drink;
                    break;
                case (2):
                    type = courseType.dessert;
                    break;
                }
                if (category == 0) {
                    // means its alacarte

                    MenuItems item = new MenuItems(0, name, 1, "null", price);
                    Order order = new Order(0, false, null, cal);
                    order.getOrderItems().add(item);
                    thereport.getOrders().add(order);
                } else { // its set
                    PromotionalSet item = new PromotionalSet(0, name, "null", price, null);
                    Order order = new Order(0, false, null);
                    order.getPromoItems().add(item);
                    thereport.getOrders().add(order);
                }
                i += 5;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ParseException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    /**
     * saves the report particulars to a txt file to serve as a database \
     * 
     * @param report the report that needs to be saved to txt file
     */
    public void saveReport(Report report) {
        try {
            FileWriter write = new FileWriter("report.txt");

            BufferedWriter bwrite = new BufferedWriter(write);

            for (int i = 0; i < report.getOrders().size(); i++) {
                for (int j = 0; j < report.getOrders().get(i).getOrderItems().size(); j++) {
                    bwrite.write(report.getOrders().get(i).getOrderItems().get(j).getName());
                    bwrite.newLine();
                    bwrite.write(Float.toString(report.getOrders().get(i).getOrderItems().get(j).getPrice()));
                    bwrite.newLine();
                    bwrite.write("0");
                    bwrite.newLine();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String strdate = dateFormat.format(report.getOrders().get(i).getTimeStamp());
                    bwrite.write(strdate);
                    bwrite.newLine();
                    bwrite.newLine();
                }

            }
            for (int i = 0; i < report.getOrders().size(); i++) {
                for (int j = 0; j < report.getOrders().get(i).getPromoItems().size(); j++) {
                    bwrite.write(report.getOrders().get(i).getPromoItems().get(j).getName());
                    bwrite.newLine();
                    bwrite.write(Float.toString(report.getOrders().get(i).getPromoItems().get(j).getPrice()));
                    bwrite.newLine();
                    bwrite.write("1");
                    bwrite.newLine();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String strdate = dateFormat.format(report.getOrders().get(i).getTimeStamp());
                    bwrite.write(strdate);
                    bwrite.newLine();
                    bwrite.newLine();
                }

            }
            bwrite.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
