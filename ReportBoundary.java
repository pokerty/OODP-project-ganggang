package oodpassignment;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner; 


public class ReportBoundary {
	
	Scanner sc = new Scanner(System.in); 
	
	
    public void reportTotal(ReportLogic reportLogic){
    	// Using Calendar class
	      Calendar cal = Calendar.getInstance();
	      Date dateandtime = cal.getTime(); 
	      cal.setTime(dateandtime);
	      System.out.println("Enter choice");
	      System.out.println("1)To get total revenue for 1 month(30days)\n2)To get total revenue for 1 day"); 
	      int choice = sc.nextInt(); 
	      switch(choice) {
	      case(1):
	    	  cal.add(Calendar.MONTH, -1); 
	      	  float value = reportLogic.calculateTotalRevenue(cal); 
	      	  System.out.println("Past 30 days revenue is : "+value);
	      	  break; 
	      case(2): 
	    	cal.add(Calendar.DAY_OF_MONTH, -1); 
      	  	float value1 = reportLogic.calculateTotalRevenue(cal); 
      	  	System.out.println("Past 1 day revenue is : "+value1);
      	  	break;
	      }
    }
    
    
    public void reportAlaCarte(ReportLogic reportLogic){
    	 Calendar cal = Calendar.getInstance();
	      Date dateandtime = cal.getTime(); 
	      cal.setTime(dateandtime);
	      System.out.println("Enter choice");
	      System.out.println("1)To get ala carte revenue for 1 month(30days)\n2)To get ala carte revenue for 1 day"); 
	      int choice = sc.nextInt(); 
	      switch(choice) {
	      case(1):
	    	  cal.add(Calendar.MONTH, -1); 
	      	  float value = reportLogic.calculateAlaCarteRevenue(cal); 
	      	  System.out.println("Past 30 days ala carte revenue is : "+value);
	      	  break; 
	      case(2): 
	    	cal.add(Calendar.DAY_OF_MONTH, -1); 
     	  	float value1 = reportLogic.calculateAlaCarteRevenue(cal); 
     	  	System.out.println("Past 1 day ala carte revenue is : "+value1);
     	  	break;
	      }
        
    }
    public void reportSetPromo(ReportLogic reportLogic){
    	Calendar cal = Calendar.getInstance();
	      Date dateandtime = cal.getTime(); 
	      cal.setTime(dateandtime);
	      System.out.println("Enter choice");
	      System.out.println("1)To get set promo revenue for 1 month(30days)\n2)To get set promo revenue for 1 day"); 
	      int choice = sc.nextInt(); 
	      switch(choice) {
	      case(1):
	    	  cal.add(Calendar.MONTH, -1); 
	      	  float value = reportLogic.calculateSetPromoRevenue(cal); 
	      	  System.out.println("Past 30 days set promo revenue is : "+value);
	      	  break; 
	      case(2): 
	    	cal.add(Calendar.DAY_OF_MONTH, -1); 
   	  	float value1 = reportLogic.calculateSetPromoRevenue(cal); 
   	  	System.out.println("Past 1 day set promo revenue is : "+value1);
   	  	break;
	      }

    }

}