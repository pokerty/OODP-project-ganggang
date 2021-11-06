package oodpassignment;

import java.util.Scanner;

public class OrderBoundary {


    public void viewOrder(OrderLogic orderLogic){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter order number:");
        Order order =orderLogic.viewOrder(sc.nextInt());
        System.out.println("TABLE NO.: " + order.getTableNumber());
        System.out.println(order.getTimeStamp());
        System.out.println("ORDER: ");
        float subTotal = 0;
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            System.out.println(order.getOrderItems().get(i).getName() + "\t" + order.getOrderItems().get(i).getPrice());
            subTotal += order.getOrderItems().get(i).getPrice();
        }
    }

    public void newOrder(OrderLogic orderLogic){
        Scanner sc = new Scanner(System.in);
        System.out.println("INPUT TABLE NO.: ");
        int tableNumber = sc.nextInt();

        System.out.println("MEMBER? (Y/N)");
        String memberStatus = sc.next();

        System.out.println("Order number is :" + orderLogic.newOrder(tableNumber,memberStatus));

    }

    public void addItemToOrder(OrderLogic orderLogic,MenuLogic menuLogic){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter order number:");
        int ordernumber = sc.nextInt();
        System.out.println("Menu:");

        System.out.println("Input category: (1)MAIN (2)DRINKS (3)DESSERT (4)PROMO SET");
        int categoryChoice = sc.nextInt();
        menuLogic.displayMenu(categoryChoice);
        System.out.println("Input ItemID to add: ");
        int orderIDChoice = sc.nextInt();
        orderLogic.addItemToOrder(ordernumber,menuLogic,categoryChoice,orderIDChoice);
    }

    public void removeItemFromOrder(OrderLogic orderLogic) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter order number:");
        int ordernumber = sc.nextInt();
        orderLogic.removeItemFromOrder(ordernumber);

    }
}
