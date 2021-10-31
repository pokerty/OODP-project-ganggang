import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReservationLogic {

	private Reservation[] reservations;

	public ReservationLogic() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				
			}
		};
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(runnable, 10, 10, TimeUnit.SECONDS);

		// TODO - implement ReservationLogic.ReservationLogic
		throw new UnsupportedOperationException();
	}

	public void makeReservation() {
		// TODO - implement ReservationLogic.makeReservation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Boolean
	 */
	public void removeReservation(int Boolean) {
		// TODO - implement ReservationLogic.removeReservation
		throw new UnsupportedOperationException();
	}

	public void checkReservation() {
		// TODO - implement ReservationLogic.checkReservation
		throw new UnsupportedOperationException();
	}

}