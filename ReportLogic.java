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
import java.util.Locale;
import java.text.DateFormat;  


import oodpassignment.MenuItems.courseType;

public class ReportLogic {
	protected Report report;
    

    public ReportLogic(){
       Report report = new Report(); 
       this.report = report; 
       
    }

    public float calculateTotalRevenue(){
        float totalRevenue = calculateAlaCateRevenue() + calculateSetPromoRevenue();
        return totalRevenue;
    }

    public float calculateSetPromoRevenue(){
        float promoRevenue = 0;
        for(int i=0; i<report.getOrders().size(); i++){
            for(int j=0;j<report.getOrders().get(i).getOrderItems().size();j++) {
            	promoRevenue += report.getOrders().get(i).getPromoItems().get(j).getPrice();
            }
        	
        }
        return promoRevenue;
    }
    public float calculateAlaCateRevenue(){
        float alaCarteRevenue = 0;
        for(int i=0; i<report.getOrders().size(); i++){
            for(int j=0;j<report.getOrders().get(i).getOrderItems().size();j++) {
            	alaCarteRevenue += report.getOrders().get(i).getOrderItems().get(j).getPrice();
            }
        }
        return alaCarteRevenue;
    }
    public Report showSetPromo(){
        return report;
    }
    
    public Report showAlaCarte(){
        return report;
    }
    
    public void showAll(){
        showSetPromo();
        showAlaCarte();
    }

    public void loadReport() {
        try {
            float price;
            String name;
            int category; 
            
            courseType type; 
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH); 
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
                cal.setTime(sdf.parse(list.get(i+3)));
                switch(category) {
                case(0):
                	type = courseType.main; 
                	break ;
                case(1): 
                	type = courseType.drink;
                	break;
                case(2):
                	type = courseType.dessert; 
                	break;
                }
                if(category==0){
                	//means its alacarte 
                	MenuItems item = new MenuItems(0,name,1,"null",price); 
                	Order order = new Order(0,false,null);
                	order.getOrderItems().add(item);
                	getReport().getOrders().add(order);
                }
                else { //its set 
                	PromotionalSet item = new PromotionalSet(0,name,"null",price,null); 
                	Order order = new Order(0,false,null);
                	order.getPromoItems().add(item); 
                	getReport().getOrders().add(order);
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
        }
        catch(ParseException e){
        	e.getMessage(); 
        	e.printStackTrace(); 
        }
    }
    public void saveReport() {
        try {
            FileWriter write = new FileWriter("report.txt");
            @SuppressWarnings("resource")
            BufferedWriter bwrite = new BufferedWriter(write);
            
            for(int i = 0; i<report.getOrders().size(); i++){
                for(int j=0;j<report.getOrders().get(i).getOrderItems().size();j++) { 
                        bwrite.write(report.getOrders().get(i).getOrderItems().get(j).getName());
                        bwrite.newLine();
                        bwrite.write(Float.toString(report.getOrders().get(i).getOrderItems().get(j).getPrice()));
                        bwrite.newLine();
                        bwrite.write(0);
                        bwrite.newLine();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                        String strdate = dateFormat.format(report.getOrders().get(i).getTimeStamp());  
                        bwrite.write(strdate);
                        bwrite.newLine();
                        bwrite.newLine();
                    }
                	
                }
            for(int i = 0; i<report.getOrders().size(); i++){
                for(int j=0;j<report.getOrders().get(i).getPromoItems().size();j++) { 
                        bwrite.write(report.getOrders().get(i).getPromoItems().get(j).getName());
                        bwrite.newLine();
                        bwrite.write(Float.toString(report.getOrders().get(i).getPromoItems().get(j).getPrice()));
                        bwrite.newLine();
                        bwrite.write(0);
                        bwrite.newLine();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                        String strdate = dateFormat.format(report.getOrders().get(i).getTimeStamp());  
                        bwrite.write(strdate);
                        bwrite.newLine();
                        bwrite.newLine();
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
    
    
    public Report getReport() {
    	return this.report; 
    }
    
}
