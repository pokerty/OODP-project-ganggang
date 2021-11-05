import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
import java.util.ArrayList;

public class OrderLogic {
    public Report report;
    public ReportLogic reportLogic;
        Scanner sc = new Scanner(System.in);

        public void OrderLogic(){
                //txt implementation
                reportLogic.loadReport();
                System.out.println("OrderLogic start-up complete.");
        }

        public void newOrder(){
                System.out.println("INPUT TABLE NO.: ");
                int tableNumber = sc.nextInt();

                System.out.println("MEMBER? (Y/N)");
                String memberStatus = sc.next();

                boolean isMember = false;
                if (memberStatus == "y" || memberStatus == "Y") isMember = true;

                StaffLogic staffLogic = new StaffLogic();
                Staff staff = staffLogic.handler();

                Order order = new Order(tableNumber, isMember, staff);
        }

        public void addItemToOrder(Order order, MenuLogic menuLogic){
                int courseTypeChoice = 0;
                System.out.println("Menu:");
                MenuLogic.displayMenu();
                System.out.println("Input category: (1)MAIN (2)DRINKS (3)DESSERT (4)PROMO SET");
                int categoryChoice = sc.nextInt();
                System.out.println("Input OrderID to add: ");
                int orderIDChoice = sc.nextInt();
                if(categoryChoice == 1) order.getOrderItems().add(MenuLogic.addItemsToOrder(orderIDChoice, MenuItems.courseType.main));
                if(categoryChoice == 2) order.getOrderItems().add(MenuLogic.addItemsToOrder(orderIDChoice, MenuItems.courseType.drink));
                if(categoryChoice == 3) order.getOrderItems().add(MenuLogic.addItemsToOrder(orderIDChoice, MenuItems.courseType.dessert));
                if(categoryChoice == 4) //adding promo set returned
        }

        public void removeItemFromOrder(Order order) {

            //need to add remove for promoitem
            System.out.println("CHOOSE AN ITEM TO REMOVE:");
            for (int i = 0; i < order.getOrderItems().size(); i++) {
                System.out.println(order.getOrderItems().get(i).getID() + "\t" + order.getOrderItems().get(i).getName());
            }
            int removeChoice = sc.nextInt();
            for (int i = 0; i < order.getOrderItems().size(); i++) {
                if (removeChoice == order.getOrderItems().get(i).getID())
                    order.removeOrderItems(order.getOrderItems(), order.getOrderItems().get(i));
            }
        }

        public void viewOrder(Order order){
                        System.out.println("TABLE NO.: " + order.getTableNumber());
                        System.out.println(order.getTimeStamp());
                        System.out.println("ORDER: ");
                        float subTotal = 0;
                        for (int i = 0; i < order.getOrderItems().size(); i++) {
                                System.out.println(order.getOrderItems().get(i).getName() + "\t" + order.getOrderItems().get(i).getPrice());
                                subTotal += order.getOrderItems().get(i).getPrice();
                        }
        }

        public void printOrderInvoice(Order order){
                        System.out.println("\t\tCZ2002 RESTAURANT");
                        System.out.println("Server: " + order.getStaff() + "\tTable: " + order.getTableNumber());
                        System.out.println("Date: " + order.getTimeStamp());
                        System.out.println("________________________");
                        for (int i=0; i<order.getOrderItems().size(); i++){
                                System.out.println(order.getOrderItems().get(i).getID() + " " + order.getOrderItems().get(i).getName() + "\t" + order.getOrderItems().get(i).getPrice());
                        }
                        System.out.println("________________________");
                        float subTotal = 0;
                        for (int i=0; i<order.getOrderItems().size(); i++){
                                subTotal += order.getOrderItems().get(i).getPrice();
                        }
                        System.out.println("\t\t\tSUB-TOTAL: " + subTotal);
                        System.out.println("\t\t\tGST: " + subTotal*0.07);
                        System.out.println("\n\t\t\tTOTAL: " + subTotal*1.07);
                        System.out.println("Thank you for dining with us!");
                }


}