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
	            System.out.println(order.getOrderItems().get(i).getName() + " $" + order.getOrderItems().get(i).getPrice());
	            subTotal += order.getOrderItems().get(i).getPrice();
	        }
	        for (int i = 0; i < order.getPromoItems().size(); i++) {
	            System.out.println(order.getPromoItems().get(i).getName() + " $" + order.getPromoItems().get(i).getPrice());
	            subTotal += order.getPromoItems().get(i).getPrice();
	        }
	        System.out.println("Total excluding discounts and GST: $"+subTotal); 
	    }

    public void newOrder(OrderLogic orderLogic, MenuLogic menuLogic){
        Scanner sc = new Scanner(System.in);
        System.out.println("INPUT TABLE NO.: ");
        int tableNumber = sc.nextInt();

        System.out.println("MEMBER? (Y/N)");
        String memberStatus = sc.next();
        int ordernumber= orderLogic.newOrder(tableNumber,memberStatus); 
        System.out.println("Order number is :" + ordernumber);
        System.out.println("\n"); 
        addItemToOrder(orderLogic,menuLogic,ordernumber); 
        

    }

    public void addItemToOrder(OrderLogic orderLogic,MenuLogic menuLogic, int ordernumber){
        Scanner sc = new Scanner(System.in);
        int categoryChoice =0; 
        System.out.println("Menu:");
        while(true) {
        	System.out.println("Input category: (1)MAIN (2)DESSERT (3)DRINKS (4)PROMO SET (5)Terminate");
            categoryChoice = sc.nextInt();
            if(categoryChoice==5)
            	break; 
            if(categoryChoice!=4)
            	menuLogic.displayMenu(categoryChoice);
            else
            	menuLogic.displayPromoMenu();
            System.out.println("Input ItemID to add: ");
            int orderIDChoice = sc.nextInt();
            orderLogic.addItemToOrder(ordernumber,menuLogic,categoryChoice,orderIDChoice);
            
        }
 }
       
    

    public void removeItemFromOrder(OrderLogic orderLogic) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter order number:");
        int ordernumber = sc.nextInt();
        System.out.println("CHOOSE AN ITEM TO REMOVE:");
        for (int i = 0; i < orderLogic.viewOrder(ordernumber).getOrderItems().size(); i++) {
            System.out.println("ID: "+orderLogic.viewOrder(ordernumber).getOrderItems().get(i).getID() + "\t" + 
            		orderLogic.viewOrder(ordernumber).getOrderItems().get(i).getName());
        }
        System.out.println("Enter ID to remove: ");
        int removeChoice = sc.nextInt();
        orderLogic.removeItemFromOrder(ordernumber, removeChoice);

    }
    public void printOrderInvoice(OrderLogic orderLogic) {
    	Scanner sc = new Scanner(System.in);

        System.out.println("Enter order number:");
        int ordernumber = sc.nextInt();
        orderLogic.printOrderInvoice(ordernumber);
      
    	
    	
    }
}