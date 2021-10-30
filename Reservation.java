
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Reservation {

	private Calendar dateandtime;
	private int pax;
	private String name;
	private int contact;
	private int tableNumber;

	public Reservation() {
		// Using Calendar class
	    Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);      // NOTE!!! : Month from 0 to 11
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    int hour = cal.get(Calendar.HOUR_OF_DAY);
	    int minute = cal.get(Calendar.MINUTE);
	    
	    Calendar date = new GregorianCalendar(year,month,day,hour,minute);
	    this.dateandtime = date;
	    this.pax = 0; 
	    this.name = "Invalid"; 
	    this.contact = 0; 
	    this.tableNumber=0; 
	}
	
	
	public Reservation(int month, int day, int hour, int minute, int pax, String name, int contact, int tableNumber) {
		// Using Calendar class
	    Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	    
	    Calendar date = new GregorianCalendar(year,month,day,hour,minute);
	    this.dateandtime = date;
	    this.pax = pax; 
	    this.name = name; 
	    this.contact = contact; 
	    this.tableNumber=tableNumber; 
		
	}

	//getters and setters 

	public Calendar getDateandtime() {
		return dateandtime;
	}


	public void setDateandtime(Calendar dateandtime) {
		this.dateandtime = dateandtime;
	}

	
	public int getPax() {
		return pax;
	}


	public void setPax(int pax) {
		this.pax = pax;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getContact() {
		return contact;
	}


	public void setContact(int contact) {
		this.contact = contact;
	}


	public int getTableNumber() {
		return tableNumber;
	}


	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

}
