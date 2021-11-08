package oodpassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * 
 * @author CHANG WEI 
 * @since 07/11/2021 
 * @version 1.0 
 * ReservationLogic is responsible for the logics used to implements the different methods 
 * involving reservations such as creating/removal/checking of reservations 
 *
 */
public class ReservationLogic {
/**
 * A collection of reservation objects - each reservation object belongs to one group of customer(s) 
 */
	private ArrayList<Reservation> reservations;
	/**
	 * TableLogic of the CheckTable type to use some functions in TableLogic. (CheckTable is an interface) 
	 */
	private CheckTable tablelogic;

	
	/**
	 * constructor of ReservationLogic 
	 * @param checkTable
	 */
	public ReservationLogic(CheckTable checkTable) {
		this.reservations = new ArrayList<Reservation>();
 		this.tablelogic = checkTable; 
		loadReservation(); 
		System.out.println("ReservationLogic start-up complete "); 
	}

	/**
	 * gets the list of reservations held by the reservationLogic object 
	 * to be used in the automatic scheduler for deletion of expired reservations 
	 * @return
	 */
	public ArrayList<Reservation>getReservations(){
		return reservations;
	}
	
	/**
	 * creates a reservation object using the inputs taken in the boundary class 
	 * 
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param pax
	 * @param name
	 * @param contact
	 */
	public void makeReservation(int month, int day, int hour, int minute, int pax, String name, int contact){
		int tableNumber = tablelogic.giveTable(pax,hour);
		if(tableNumber==-1) { //no table 
			System.out.println("No available tables at the time, sorry!"); 
			return; 
		}
		Reservation reservation = new Reservation(month,day,hour,minute,pax,name,contact,tableNumber); 
		reservations.add(reservation); 
		System.out.println("Reservation successful at table "+tableNumber+", "+day+"/"+month+","+hour+":"+minute); 
		
	}
	
	
	

	/**
	 * removes reservation based on the inputs taken in boundary class e.g. table number and name of customer 
	 * @param tableNumber
	 * @param name
	 * @param expired
	 */
	public void removeReservation(int tableNumber,String name, boolean expired) {
		int validity = checkReservation(tableNumber, name); 
		if(validity>=0) {
			tablelogic.freeTable(tableNumber-1, reservations.get(validity).getDateandtime().get(Calendar.HOUR_OF_DAY)); 
			//free up the table after reservation removal 
			reservations.remove(validity); //remove from array list
			//rely on java auto garbage collection to delete reservation object. 
			if(expired==true)
				System.out.println("Reservation expired - Removed!"); 
			else
			System.out.println("Reservation will be removed! - Removed!"); 
		}
		else if(validity==-1) {
			System.out.println("No such reservation exists, unable to remove");
		}
		else {
			System.out.println("Please ensure your inputs are correct, especially tableNumber"); 
		}
		
		
		
	}

	/**
	 * checks the validity of the reservation using inputs taken in boundary class - table number and name of customer 
	 * @param TableNumber
	 * @param name
	 * @return
	 */
	public int checkReservation(int TableNumber, String name) {
		if(TableNumber>0 && TableNumber<= 15) { // change parameters 
			for(int i=0;i<reservations.size();i++) {
				if(reservations.get(i).getName().equalsIgnoreCase(name)
						&& reservations.get(i).getTableNumber() == TableNumber) {
					System.out.println("Reservation is valid on " + reservations.get(i).getDateandtime().getTime()); 
					return i; 	
				}
			}
			//finished searching, cant find 
			System.out.println("Said person does not have such a reservation!"); 
			return -1; 
			}
					
		else {  //error checking code 
			System.out.println("Table input exceeded bounds"); 
			return -2; 
		}
		
	}
	
	/**
	 * loads the day's reservations from a txt file that serves as the database 
	 */
	private void loadReservation(){
		try {
			int month,day,hour,minute,pax,contact,tablenumber;
			String name; 
			FileReader reservationList = new FileReader("reservationList.txt"); 
			BufferedReader reader = new BufferedReader(reservationList);
			ArrayList<String> list = new ArrayList<String>(); 
			String info = reader.readLine(); 
			while(info!=null) {
				list.add(info.replace("empty_string", "")); 
	            info = reader.readLine();
			}
			
			int i =0; 
			
			while(i<list.size()) {
				name = list.get(i); //format is first:name
				tablenumber = Integer.parseInt(list.get(i+1)); //Integer.parseInt() to convert string to integer. second is tablenum
				contact = Integer.parseInt(list.get(i+2)); //3rd is contact 
				pax = Integer.parseInt(list.get(i+3)); //4th is no of pax 
				month = Integer.parseInt(list.get(i+4)); //5th is month 
				day = Integer.parseInt(list.get(i+5)); //6th is day 
				hour = Integer.parseInt(list.get(i+6)); //7th is hour 
				minute = Integer.parseInt(list.get(i+7)); //8th is minute 
				Reservation reservation = new Reservation(month,day,hour,minute,pax,name,contact,tablenumber); //create reservation
				reservations.add(reservation); 
				i = i+9; //should be start of next entry , don't take empty string 
			}
			
			reader.close(); //close file reader 
			
			 /*for testing 
			for(int j=0;j<reservations.size();j++) {
				if(reservations.get(j)!=null) {
					System.out.println(reservations.get(j).getName());
					System.out.println(reservations.get(j).getTableNumber());
				}
			}
			*/
		
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
	
	/**
	 * saves the reservation made for the next day in a txt file once the restaurant app is terminated 
	 */
	public void saveReservation() {
		try {
			FileWriter write = new FileWriter("reservationList.txt"); 
			@SuppressWarnings("resource")
			BufferedWriter bwrite = new BufferedWriter(write); 
			int noOfReservations = reservations.size();
			int i;   //need write in order of name,tablenumber,contact,pax,month,day,hour,minute; 
			for(i=0;i<noOfReservations;i++) {
				if(reservations.get(i)!=null){
					bwrite.write(reservations.get(i).getName());//write name
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getTableNumber())); //convert table no to string and write 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getContact())); //write contact 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getPax())); //write pax 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getDateandtime().get(Calendar.MONTH))); //write month 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getDateandtime().get(Calendar.DAY_OF_MONTH)));//write day 
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getDateandtime().get(Calendar.HOUR_OF_DAY)));
					bwrite.newLine();
					bwrite.write(Integer.toString(reservations.get(i).getDateandtime().get(Calendar.MINUTE)));
					bwrite.newLine();
					bwrite.newLine(); //TO SEPERATE THE DIFFERENT RESERVATIONS 
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