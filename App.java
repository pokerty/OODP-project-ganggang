package oodpassignment;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		CheckTable tableLogic = new TableLogic();
		ReservationLogic reservationLogic = new ReservationLogic(tableLogic);
		ArrayList<Reservation>reservations = reservationLogic.getReservations();
		RestaurantApp restaurant = new RestaurantApp(); 
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<reservations.size();i++){
					if(System.currentTimeMillis()>=reservations.get(i).getDateandtime().getTimeInMillis()){
						reservationLogic.removeReservation(reservations.get(i).getTableNumber(),reservations.get(i).getName(),true);
					}
				}
			}
		};
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(runnable, 15, 15, TimeUnit.MINUTES);
		restaurant.start(tableLogic,reservationLogic);


	}
	
}
