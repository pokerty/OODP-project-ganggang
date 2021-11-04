
import java.util.Scanner;
import java.util.ArrayList;

public class OrderApp {
    Scanner sc = new Scanner(System.in);

    public void view(Order order) {
        System.out.println("ORDER ID: " + order.getOrderID());
        System.out.println("TABLE NO.: " + order.getTableNum());
        System.out.println(order.getTimeStamp());
        System.out.println("ORDER: ");
        float subTotal = 0;
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            System.out.println(order.getOrderItems().get(i).getName() + "\t" + order.getOrderItems().get(i).getPrice());
            subTotal += order.getOrderItems().get(i).getPrice();
        }
        System.out.println("SUB-TOTAL: " + subTotal);
        System.out.println("GST: " + subTotal * 0.07);
        System.out.println("TOTAL: " + subTotal + subTotal * 0.07);
    }

    public void addOrders(Order order) {
        int courseTypeChoice = 0;
        do {
            System.out.println("ADD ORDER - SELECT TYPE:\n(1)MAINS\n(2)DRINKS\n(3)DESSERT\n(4)SET\n(5)QUIT");
            courseTypeChoice = sc.nextInt();
            switch (courseTypeChoice) {
                case 1:
                    for (int i = 0; i < MenuLogic.mains.size(); i++) {
                        System.out.println(MenuLogic.mains.get(i).getID() + ": " + MenuLogic.mains.get(i).getName() + "\t" + MenuLogic.mains.get(i).getPrice());
                    }
                    int mainChoice = sc.nextInt();
                    for (int i = 0; i < MenuLogic.mains.size(); i++) {
                        if (MenuLogic.mains.get(i).getID() == mainChoice)
                            order.setOrderItems(order.getOrderItems(), MenuLogic.mains.get(i));
                    }
                    break;

                case 2:
                    for (int i = 0; i < MenuLogic.drinks.size(); i++) {
                        System.out.println(MenuLogic.drinks.get(i).getID() + ": " + MenuLogic.drinks.get(i).getName() + "\t" + MenuLogic.drinks.get(i).getPrice());
                    }
                    int drinksChoice = sc.nextInt();
                    for (int i = 0; i < MenuLogic.drinks.size(); i++) {
                        if (MenuLogic.drinks.get(i).getID() == drinksChoice)
                            order.setOrderItems(order.getOrderItems(), MenuLogic.drinks.get(i));
                    }
                    break;
                case 3:
                    for (int i = 0; i < MenuLogic.dessert.size(); i++) {
                        System.out.println(MenuLogic.dessert.get(i).getID() + ": " + MenuLogic.dessert.get(i).getName() + "\t" + MenuLogic.dessert.get(i).getPrice());
                    }
                    int dessertChoice = sc.nextInt();
                    for (int i = 0; i < MenuLogic.dessert.size(); i++) {
                        if (MenuLogic.dessert.get(i).getID() == dessertChoice)
                            order.setOrderItems(order.getOrderItems(), MenuLogic.dessert.get(i));
                    }
                    break;
                case 4:
                    //special promo set class is not defined in order.java -> to fix soon
                    for (int i = 0; i < MenuLogic.promo.size(); i++) {
                        System.out.println(MenuLogic.promo.get(i).getID() + ": " + MenuLogic.promo.get(i).getName() + "\t" + MenuLogic.promo.get(i).getPrice());
                    }
                    int promoChoice = sc.nextInt();
                    for (int i = 0; i < MenuLogic.promo.size(); i++) {
                        if (MenuLogic.promo.get(i).getID() == promoChoice)
                            order.setOrderItems(order.getOrderItems(), MenuLogic.promo.get(i));
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (courseTypeChoice != 5);
    }

    public void remove(Order order) {
        System.out.println("CHOOSE AN ITEM TO REMOVE:");
        for (int i = 0; i<order.getOrderItems().size(); i++) {
            System.out.println(order.getOrderItems().get(i).getID() + "\t" + order.getOrderItems().get(i).getName());
        }
        int removeChoice = sc.nextInt();
        for (int i = 0; i<order.getOrderItems().size(); i++) {
            if (removeChoice == order.getOrderItems().get(i).getID())
                order.removeOrderItems(order.getOrderItems(), order.getOrderItems().get(i));
        }
    }

    public void printInvoice(Order order){
        System.out.println("ORDER ID: " + order.getOrderID());
        System.out.println("TABLE NO.: " + order.getTableNum());
        System.out.println(order.getTimeStamp());
        System.out.println("ORDER: ");
        float subTotal = 0;
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            System.out.println(order.getOrderItems().get(i).getName() + "\t" + order.getOrderItems().get(i).getPrice());
            subTotal += order.getOrderItems().get(i).getPrice();
        }
        System.out.println("SUB-TOTAL: " + subTotal);
        System.out.println("GST: " + subTotal * 0.07);
        System.out.println("TOTAL: " + subTotal + subTotal * 0.07);

        //to be stored in txt and add order to saleItems array
    }

    public void printReport(Report report, int period){
        float totalRevenue = 0;
        for (int i=0; i<report.getSaleItems().size(); i++){
            for (int j=0; j<report.getSaleItems().get(i).getOrderItems().size(); j++){
                System.out.println("ALL INDIVIDUAL SALE ITEMS DURING CHOSEN PERIOD OF " + period + " DAYS:");
                System.out.println(report.getSaleItems().get(i).getOrderItems().get(j).getName() + "\t" + report.getSaleItems().get(i).getOrderItems().get(j).getPrice());
                totalRevenue += report.getSaleItems().get(i).getOrderItems().get(j).getPrice();
                //include gst?
            }
        }
        System.out.println("TOTAL REVENUE: " + totalRevenue);
    }

}
